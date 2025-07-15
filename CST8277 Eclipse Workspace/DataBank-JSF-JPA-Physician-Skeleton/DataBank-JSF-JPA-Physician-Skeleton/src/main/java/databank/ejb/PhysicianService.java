/********************************************************************************************************2*4*w*
 * File:  PhysicianService.java
 *
 * @author Teddy Yap
 * @author Shahriar (Shawn) Emami
 * @author (original) Mike Norman
 */
package databank.ejb;

import jakarta.ejb.Singleton;
import jakarta.ejb.Stateless;

import java.util.List;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import databank.model.PhysicianPojo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * Stateless Session Bean - InventoryService
 */
@Stateless
//@Singleton
public class PhysicianService {
	
	public PhysicianService() {
	}

	private static final Logger LOG = LogManager.getLogger();

	@PersistenceContext(name = "PU_DataBank")
	protected EntityManager em;

	public List<PhysicianPojo> readAllPhysicians() {
		LOG.debug("reading all physicians in service");
		TypedQuery<PhysicianPojo> allPhysiciansQuery = em.createNamedQuery(PhysicianPojo.PHYSICIAN_FIND_ALL, PhysicianPojo.class);
		return allPhysiciansQuery.getResultList();
	}

	@Transactional
	public PhysicianPojo createPhysician(PhysicianPojo physician) {
		LOG.debug("creating a physician in service = {}", physician);
		em.persist(physician);
		return physician;
	}

	public PhysicianPojo readPhysicianById(int physicianId) {
		LOG.debug("reading a specific physician in service = {}", physicianId);
		return em.find(PhysicianPojo.class, physicianId);
	}

	@Transactional
	public PhysicianPojo updatePhysician(PhysicianPojo physicianWithUpdates) {
		LOG.debug("updating a specific physician in service = {}", physicianWithUpdates);
		return em.merge(physicianWithUpdates);
	}

	public void deletePhysicianById(int physicianId) {
		LOG.debug("deleting a specific physicianID in service = {}", physicianId);
		PhysicianPojo physician = em.find(PhysicianPojo.class, physicianId);
		if (physician != null) {
			em.refresh(physician);
			em.remove(physician);
		}
	}
}