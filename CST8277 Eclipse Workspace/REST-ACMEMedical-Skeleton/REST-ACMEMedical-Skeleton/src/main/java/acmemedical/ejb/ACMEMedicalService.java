/********************************************************************************************************
 * File:  ACMEMedicalService.java Course Materials CST 8277
 *
 * @author Teddy Yap
 * @author Shariar (Shawn) Emami
 * 
 */
package acmemedical.ejb;

import static acmemedical.utility.MyConstants.DEFAULT_KEY_SIZE;
import static acmemedical.utility.MyConstants.DEFAULT_PROPERTY_ALGORITHM;
import static acmemedical.utility.MyConstants.DEFAULT_PROPERTY_ITERATIONS;
import static acmemedical.utility.MyConstants.DEFAULT_SALT_SIZE;
import static acmemedical.utility.MyConstants.DEFAULT_USER_PASSWORD;
import static acmemedical.utility.MyConstants.DEFAULT_USER_PREFIX;
import static acmemedical.utility.MyConstants.PARAM1;
import static acmemedical.utility.MyConstants.PROPERTY_ALGORITHM;
import static acmemedical.utility.MyConstants.PROPERTY_ITERATIONS;
import static acmemedical.utility.MyConstants.PROPERTY_KEY_SIZE;
import static acmemedical.utility.MyConstants.PROPERTY_SALT_SIZE;
import static acmemedical.utility.MyConstants.PU_NAME;
import static acmemedical.utility.MyConstants.USER_ROLE;
import static acmemedical.entity.Physician.ALL_PHYSICIANS_QUERY_NAME;
import static acmemedical.entity.MedicalSchool.ALL_MEDICAL_SCHOOLS_QUERY_NAME;
import static acmemedical.entity.MedicalSchool.IS_DUPLICATE_QUERY_NAME;
import static acmemedical.entity.MedicalSchool.SPECIFIC_MEDICAL_SCHOOL_QUERY_NAME;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jakarta.ejb.Singleton;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;
import jakarta.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import acmemedical.entity.MedicalTraining;
import acmemedical.entity.Patient;
import acmemedical.entity.MedicalCertificate;
import acmemedical.entity.Medicine;
import acmemedical.entity.Prescription;
import acmemedical.entity.PrescriptionPK;
import acmemedical.entity.SecurityRole;
import acmemedical.entity.SecurityUser;
import acmemedical.entity.Physician;
import acmemedical.entity.MedicalSchool;

@SuppressWarnings("unused")

/**
 * Stateless Singleton EJB Bean - ACMEMedicalService
 */
@Singleton
public class ACMEMedicalService implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private static final Logger LOG = LogManager.getLogger();
    
    @PersistenceContext(name = PU_NAME)
    protected EntityManager em;
    
    @Inject
    protected Pbkdf2PasswordHash pbAndjPasswordHash;

    public List<Physician> getAllPhysicians() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Physician> cq = cb.createQuery(Physician.class);
        cq.select(cq.from(Physician.class));
        return em.createQuery(cq).getResultList();
    }

    public Physician getPhysicianById(int id) {
        return em.find(Physician.class, id);
    }

    @Transactional
    public Physician persistPhysician(Physician newPhysician) {
        em.persist(newPhysician);
        return newPhysician;
    }

    @Transactional
    public void buildUserForNewPhysician(Physician newPhysician) {
        SecurityUser userForNewPhysician = new SecurityUser();
        userForNewPhysician.setUsername(
            DEFAULT_USER_PREFIX + "_" + newPhysician.getFirstName() + "." + newPhysician.getLastName());
        Map<String, String> pbAndjProperties = new HashMap<>();
        pbAndjProperties.put(PROPERTY_ALGORITHM, DEFAULT_PROPERTY_ALGORITHM);
        pbAndjProperties.put(PROPERTY_ITERATIONS, DEFAULT_PROPERTY_ITERATIONS);
        pbAndjProperties.put(PROPERTY_SALT_SIZE, DEFAULT_SALT_SIZE);
        pbAndjProperties.put(PROPERTY_KEY_SIZE, DEFAULT_KEY_SIZE);
        pbAndjPasswordHash.initialize(pbAndjProperties);
        String pwHash = pbAndjPasswordHash.generate(DEFAULT_USER_PASSWORD.toCharArray());
        userForNewPhysician.setPwHash(pwHash);
        userForNewPhysician.setPhysician(newPhysician);
        
        TypedQuery<SecurityRole> query = em.createNamedQuery("SecurityRole.findByRoleName", SecurityRole.class);
        query.setParameter("roleName", USER_ROLE);
        SecurityRole userRole = /* TODO ACMECS01 - Use NamedQuery on SecurityRole to find USER_ROLE */ query.getSingleResult();
        
        userForNewPhysician.getRoles().add(userRole);
        userRole.getUsers().add(userForNewPhysician);
        em.persist(userForNewPhysician);
    }

    @Transactional
    public Medicine setMedicineForPhysicianPatient(int physicianId, int patientId, Medicine newMedicine) {
        Physician physicianToBeUpdated = em.find(Physician.class, physicianId);
        if (physicianToBeUpdated != null) { // Physician exists
            Set<Prescription> prescriptions = physicianToBeUpdated.getPrescriptions();
            prescriptions.forEach(p -> {
                if (p.getPatient().getId() == patientId) {
                    if (p.getMedicine() != null) { // Medicine exists
                        Medicine medicine = em.find(Medicine.class, p.getMedicine().getId());
                        medicine.setMedicine(newMedicine.getDrugName(),
                        				  newMedicine.getManufacturerName(),
                        				  newMedicine.getDosageInformation());
                        em.merge(medicine);
                    }
                    else { // Medicine does not exist
                        p.setMedicine(newMedicine);
                        em.merge(physicianToBeUpdated);
                    }
                }
            });
            return newMedicine;
        }
        else return null;  // Physician doesn't exists
    }

    /**
     * To update a physician
     * 
     * @param id - id of entity to update
     * @param physicianWithUpdates - entity with updated information
     * @return Entity with updated information
     */
    @Transactional
    public Physician updatePhysicianById(int id, Physician physicianWithUpdates) {
    	Physician physicianToBeUpdated = getPhysicianById(id);
        if (physicianToBeUpdated != null) {
            em.refresh(physicianToBeUpdated);
            em.merge(physicianWithUpdates);
            em.flush();
        }
        return physicianToBeUpdated;
    }

    /**
     * To delete a physician by id
     * 
     * @param id - physician id to delete
     */
    @Transactional
    public void deletePhysicianById(int id) {
        Physician physician = getPhysicianById(id);
        LOG.info("Deleting physician with ID: " + id);
        if (physician != null) {
        	LOG.info("Physician found: " + physician.getId());
            em.refresh(physician);
            
            
            TypedQuery<SecurityUser> findUser = em.createNamedQuery("SecurityUser.findByPhysician", SecurityUser.class);
            /* TODO ACMECS02 - Use NamedQuery on SecurityRole to find this related Student
               so that when we remove it, the relationship from SECURITY_USER table
               is not dangling
            */ 
//            findUser.setParameter(PARAM1, physician.getId());
            findUser.setParameter("physicianId", physician.getId());
            SecurityUser sUser = findUser.getSingleResult();
            if (sUser != null) {
            	LOG.info("Removing related security user for physician: " + sUser.getUsername());
                em.remove(sUser);  // Remove the user first
            }
            else {
                LOG.warn("Physician not found with ID: " + id);
            }

//            em.remove(sUser);
            em.remove(physician);
        }
    }
    
    public List<MedicalSchool> getAllMedicalSchools() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<MedicalSchool> cq = cb.createQuery(MedicalSchool.class);
        cq.select(cq.from(MedicalSchool.class));
        return em.createQuery(cq).getResultList();
    }

    // Why not use the build-in em.find?  The named query SPECIFIC_MEDICAL_SCHOOL_QUERY_NAME
    // includes JOIN FETCH that we cannot add to the above API
    public MedicalSchool getMedicalSchoolById(int id) {
//        TypedQuery<MedicalSchool> specificMedicalSchoolQuery = em.createNamedQuery(SPECIFIC_MEDICAL_SCHOOL_QUERY_NAME, MedicalSchool.class);
//        specificMedicalSchoolQuery.setParameter(PARAM1, id);
//        return specificMedicalSchoolQuery.getSingleResult();
    	
    	TypedQuery<MedicalSchool> specificMedicalSchoolQuery = em.createNamedQuery(SPECIFIC_MEDICAL_SCHOOL_QUERY_NAME, MedicalSchool.class);
        specificMedicalSchoolQuery.setParameter("id", id);  // Ensure correct parameter name here
        return specificMedicalSchoolQuery.getSingleResult();
    }
    
    // These methods are more generic.

    public <T> List<T> getAll(Class<T> entity, String namedQuery) {
        TypedQuery<T> allQuery = em.createNamedQuery(namedQuery, entity);
        return allQuery.getResultList();
    }
    
    public <T> T getById(Class<T> entity, String namedQuery, int id) {
        TypedQuery<T> allQuery = em.createNamedQuery(namedQuery, entity);
//        allQuery.setParameter(PARAM1, id);
        allQuery.setParameter("id", id);
        return allQuery.getSingleResult();
    }

    @Transactional
    public MedicalSchool deleteMedicalSchool(int id) {
        //MedicalSchool ms = getMedicalSchoolById(id);
    	MedicalSchool ms = getById(MedicalSchool.class, MedicalSchool.SPECIFIC_MEDICAL_SCHOOL_QUERY_NAME, id);
        if (ms != null) {
            Set<MedicalTraining> medicalTrainings = ms.getMedicalTrainings();
            List<MedicalTraining> list = new LinkedList<>();
            medicalTrainings.forEach(list::add);
            list.forEach(mt -> {
                if (mt.getCertificate() != null) {
                    MedicalCertificate mc = getById(MedicalCertificate.class, MedicalCertificate.ID_CARD_QUERY_NAME, mt.getCertificate().getId());
                    mc.setMedicalTraining(null);
                }
                mt.setCertificate(null);
                em.merge(mt);
            });
            em.remove(ms);
            return ms;
        }
        return null;
    }
    
    // Please study & use the methods below in your test suites
    
    public boolean isDuplicated(MedicalSchool newMedicalSchool) {
        TypedQuery<Long> allMedicalSchoolsQuery = em.createNamedQuery(IS_DUPLICATE_QUERY_NAME, Long.class);
//        allMedicalSchoolsQuery.setParameter(PARAM1, newMedicalSchool.getName());
        allMedicalSchoolsQuery.setParameter("name", newMedicalSchool.getName());
        return (allMedicalSchoolsQuery.getSingleResult() >= 1);
    }

    @Transactional
    public MedicalSchool persistMedicalSchool(MedicalSchool newMedicalSchool) {
        em.persist(newMedicalSchool);
        return newMedicalSchool;
    }

    @Transactional
    public MedicalSchool updateMedicalSchool(int id, MedicalSchool updatingMedicalSchool) {
    	MedicalSchool medicalSchoolToBeUpdated = getMedicalSchoolById(id);
        if (medicalSchoolToBeUpdated != null) {
            em.refresh(medicalSchoolToBeUpdated);
            medicalSchoolToBeUpdated.setName(updatingMedicalSchool.getName());
            em.merge(medicalSchoolToBeUpdated);
            em.flush();
        }
        return medicalSchoolToBeUpdated;
    }
    
    @Transactional
    public MedicalTraining persistMedicalTraining(MedicalTraining newMedicalTraining) {
        em.persist(newMedicalTraining);
        return newMedicalTraining;
    }
    
    public MedicalTraining getMedicalTrainingById(int mtId) {
        TypedQuery<MedicalTraining> allMedicalTrainingQuery = em.createNamedQuery(MedicalTraining.FIND_BY_ID, MedicalTraining.class);
        allMedicalTrainingQuery.setParameter(PARAM1, mtId);
        return allMedicalTrainingQuery.getSingleResult();
    }

    @Transactional
    public MedicalTraining updateMedicalTraining(int id, MedicalTraining medicalTrainingWithUpdates) {
    	MedicalTraining medicalTrainingToBeUpdated = getMedicalTrainingById(id);
        if (medicalTrainingToBeUpdated != null) {
            em.refresh(medicalTrainingToBeUpdated);
            em.merge(medicalTrainingWithUpdates);
            em.flush();
        }
        return medicalTrainingToBeUpdated;
    }
    
    public List<Patient> getAllPatients() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Patient> cq = cb.createQuery(Patient.class);
        cq.select(cq.from(Patient.class)); // Select all patients
        return em.createQuery(cq).getResultList(); // Return list of all patients
    }
    
    
 // New method to get a patient by ID
    public Patient getPatientById(int id) {
        return em.find(Patient.class, id);
    }

    // New method to add a new patient
    @Transactional
    public Patient persistPatient(Patient newPatient) {
        em.persist(newPatient);
        return newPatient;
    }

    // New method to update a patient
    @Transactional
    public Patient updatePatient(Patient updatedPatient) {
        return em.merge(updatedPatient);
    }

    // New method to delete a patient by ID
    @Transactional
    public void deletePatientById(int id) {
        Patient patient = em.find(Patient.class, id);
        if (patient != null) {
            em.remove(patient);
        } else {
            throw new EntityNotFoundException("Patient not found with ID: " + id);
        }
        
    }
    
    public MedicalCertificate findMedicalCertificateById(int certificateId) {
        MedicalCertificate certificate = em.find(MedicalCertificate.class, certificateId);
        if (certificate == null) {
            throw new EntityNotFoundException("Medical certificate not found for ID: " + certificateId);
        }
        return certificate;
    }
    
    @Transactional
    public void deleteMedicalCertificate(int id) {
        // Step 1: Find the MedicalCertificate by ID
        MedicalCertificate certificate = em.find(MedicalCertificate.class, id);
        
        if (certificate != null) {
            LOG.info("Deleting MedicalCertificate with ID: " + id);
            
            // Step 2: Handle relationships (if necessary)
            MedicalTraining medicalTraining = certificate.getMedicalTraining();
            if (medicalTraining != null) {
                medicalTraining.setCertificate(null);  // Remove the reference to the certificate
                em.merge(medicalTraining);  // Merge the updated medicalTraining entity
            }
            
            // Step 3: Remove the certificate
            em.remove(certificate);
            LOG.info("MedicalCertificate with ID " + id + " has been deleted.");
        } else {
            LOG.warn("MedicalCertificate not found with ID: " + id);
        }
    }
    
    // ============================
    // Medicine-Related Methods
    // ============================

    /**
     * Fetch all medicines from the database.
     *
     * @return List of all medicines
     */
    public List<Medicine> getAllMedicines() {
        LOG.info("Fetching all medicines.");
        TypedQuery<Medicine> query = em.createNamedQuery("Medicine.findAll", Medicine.class);
        return query.getResultList();
    }

    /**
     * Fetch a specific medicine by ID.
     *
     * @param id - the ID of the medicine
     * @return The medicine entity, or null if not found
     */
    public Medicine getMedicineById(int id) {
        LOG.info("Fetching medicine with ID: {}", id);
        return em.find(Medicine.class, id);
    }

    /**
     * Add a new medicine to the database.
     *
     * @param newMedicine - The medicine entity to persist
     * @return The persisted medicine entity
     */
    @Transactional
    public Medicine persistMedicine(Medicine newMedicine) {
        LOG.info("Persisting new medicine: {}", newMedicine);
        em.persist(newMedicine);
        return newMedicine;
    }

    /**
     * Update an existing medicine in the database.
     *
     * @param updatedMedicine - The updated medicine entity
     * @return The merged medicine entity
     */
    @Transactional
    public Medicine updateMedicine(Medicine updatedMedicine) {
        LOG.info("Updating medicine with ID: {}", updatedMedicine.getId());
        Medicine existingMedicine = em.find(Medicine.class, updatedMedicine.getId());
        if (existingMedicine == null) {
            throw new EntityNotFoundException("Medicine not found with ID: " + updatedMedicine.getId());
        }
        existingMedicine.setDrugName(updatedMedicine.getDrugName());
        existingMedicine.setManufacturerName(updatedMedicine.getManufacturerName());
        existingMedicine.setDosageInformation(updatedMedicine.getDosageInformation());
        return em.merge(existingMedicine);
    }

    /**
     * Delete a medicine by its ID.
     *
     * @param id - The ID of the medicine to delete
     */
    @Transactional
    public void deleteMedicine(int id) {
        LOG.info("Deleting medicine with ID: {}", id);
        Medicine medicine = em.find(Medicine.class, id);
        if (medicine == null) {
            throw new EntityNotFoundException("Medicine not found with ID: " + id);
        }
        em.remove(medicine);
    }
    
    public List<Prescription> getAllPrescriptions() {
        TypedQuery<Prescription> allPrescriptionsQuery = em.createNamedQuery("Prescription.findAll", Prescription.class);
        return allPrescriptionsQuery.getResultList();
    }
    
    public List<Prescription> getPrescriptionsByPhysicianId(int physicianId) {
        Physician physician = em.find(Physician.class, physicianId);
        if (physician != null) {
            return new LinkedList<>(physician.getPrescriptions());
        } else {
            throw new EntityNotFoundException("Physician not found with ID: " + physicianId);
        }
    }
    
    public List<Prescription> getPrescriptionsByPatientId(int patientId) {
        Patient patient = em.find(Patient.class, patientId);
        if (patient != null) {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Prescription> cq = cb.createQuery(Prescription.class);
            Root<Prescription> prescription = cq.from(Prescription.class);
            cq.select(prescription).where(cb.equal(prescription.get("patient"), patient));
            return em.createQuery(cq).getResultList();
        } else {
            throw new EntityNotFoundException("Patient not found with ID: " + patientId);
        }
    }
    
    
    
    
    @Transactional
    public Prescription persistPrescription(Prescription newPrescription) {
        em.persist(newPrescription);
        return newPrescription;
    }

    
    @Transactional
    public Prescription updatePrescription(Prescription updatedPrescription) {
        Prescription existingPrescription = em.find(Prescription.class, updatedPrescription.getId());
        if (existingPrescription != null) {
            em.merge(updatedPrescription);
            return updatedPrescription;
        } else {
            throw new EntityNotFoundException("Prescription not found with ID: " + updatedPrescription.getId());
        }
    }
    
    @Transactional
    public void deletePrescriptionById(PrescriptionPK prescriptionPK) {
        Prescription prescription = em.find(Prescription.class, prescriptionPK);
        if (prescription != null) {
            em.remove(prescription);
        } else {
            throw new EntityNotFoundException("Prescription not found with ID: " + prescriptionPK);
        }
    }
    
    public Prescription getPrescriptionById(PrescriptionPK prescriptionPK) {
        Prescription prescription = em.find(Prescription.class, prescriptionPK);
        if (prescription == null) {
            throw new EntityNotFoundException("Prescription not found with ID: " + prescriptionPK);
        }
        return prescription;
    }


    
}