/********************************************************************************************************2*4*w*
 * File:  PhysicianDaoImpl.java Course Materials CST8277
 *
 * @author Teddy Yap
 * @author Shahriar (Shawn) Emami
 * @author (original) Mike Norman
 */
package databank.dao;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import databank.ejb.PhysicianService;
import databank.model.PhysicianPojo;


/**
 * Description:  Implements the C-R-U-D API for the database
 * 
 * TODO 01 - Some components are managed by CDI.<br>
 * TODO 02 - Methods which perform DML need @Transactional annotation.<br>
 * TODO 03 - Fix the syntax errors to correct methods. <br>
 * TODO 04 - Refactor this class.  Move all the method bodies and EntityManager to a new service class (e.g. StudentService) which is a
 * singleton (EJB).<br>
 * TODO 05 - Inject the service class using EJB.<br>
 * TODO 06 - Call all the methods of service class from each appropriate method here.
 */
@Named
@ApplicationScoped
public class PhysicianDaoImpl implements PhysicianDao, Serializable {
	/** explicitly set serialVersionUID */
	private static final long serialVersionUID = 1L;

	//Get the log4j2 logger for this class
	private static final Logger LOG = LogManager.getLogger();
    
	@PersistenceContext(name = "PU_Databank")
	protected EntityManager em;
	
@Transactional
	@Override
	public List<PhysicianPojo> readAllPhysicians() {
        LOG.debug("reading all physicians");
        TypedQuery<PhysicianPojo> allPhysiciansQuery = em.createNamedQuery(PhysicianPojo.PHYSICIAN_FIND_ALL, PhysicianPojo.class);
        return allPhysiciansQuery.getResultList();
	}
@Transactional
@Override
public PhysicianPojo createPhysician(PhysicianPojo physician) {
    LOG.debug("creating a physician = {}", physician);
    em.persist(physician);
    return physician;
}
@Transactional
@Override
public PhysicianPojo readPhysicianById(int physicianId) {
    LOG.debug("reading a specific physician by id = {}", physicianId);
    return em.find(PhysicianPojo.class, physicianId);
}

@Transactional
@Override
public PhysicianPojo updatePhysician(PhysicianPojo physicianWithUpdates) {
    LOG.debug("updating a specific physician = {}", physicianWithUpdates);
    return em.merge(physicianWithUpdates);
}

@Transactional
@Override
public void deletePhysicianById(int physicianId) {
    LOG.debug("deleting a specific physician by id = {}", physicianId);
    PhysicianPojo physician = readPhysicianById(physicianId);
    if (physician != null) {
        em.remove(physician);
    } else {
        LOG.warn("Physician with id {} not found, nothing to delete.", physicianId);
    }

}
}
