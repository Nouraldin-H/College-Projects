/********************************************************************************************************
 * File:  PatientResource.java Course Materials CST 8277
 *
 * @author Teddy Yap
 * 
 */
package acmemedical.rest.resource;

import static acmemedical.utility.MyConstants.ADMIN_ROLE;
import static acmemedical.utility.MyConstants.PATIENT_RESOURCE_NAME;
import static acmemedical.utility.MyConstants.RESOURCE_PATH_ID_ELEMENT;
import static acmemedical.utility.MyConstants.RESOURCE_PATH_ID_PATH;
import static acmemedical.utility.MyConstants.USER_ROLE;

import java.util.List;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.security.enterprise.SecurityContext;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import acmemedical.ejb.ACMEMedicalService;
import acmemedical.entity.Patient;

@Path(PATIENT_RESOURCE_NAME)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PatientResource {

    private static final Logger LOG = LogManager.getLogger();

    @EJB
    protected ACMEMedicalService service;

    @Inject
    protected SecurityContext sc;

    @GET
    // Only a user with the SecurityRole ‘ADMIN_ROLE’ can get the list of all patients.
    @RolesAllowed({ADMIN_ROLE})
    public Response getPatients() {
        LOG.debug("retrieving all patients ...");
        List<Patient> patients = service.getAllPatients();
        return Response.ok(patients).build();
    }

    @GET
    // A user with either the role ‘ADMIN_ROLE’ or ‘USER_ROLE’ can get a specific patient.
    @RolesAllowed({ADMIN_ROLE, USER_ROLE})
    @Path(RESOURCE_PATH_ID_PATH)
    public Response getPatientById(@PathParam(RESOURCE_PATH_ID_ELEMENT) int id) {
        LOG.debug("retrieving patient with ID: {}", id);
        Patient patient = service.getPatientById(id);
        if (patient == null) {
            return Response.status(Status.NOT_FOUND).build();
        }
        return Response.ok(patient).build();
    }

    @POST
    // Only a user with the SecurityRole ‘ADMIN_ROLE’ can add a new patient.
    @RolesAllowed({ADMIN_ROLE})
    public Response addPatient(Patient newPatient) {
        LOG.debug("adding new patient ...");
        Patient createdPatient = service.persistPatient(newPatient);
        return Response.ok(createdPatient).build();
    }

    @PUT
    // Only a user with the SecurityRole ‘ADMIN_ROLE’ can update an existing patient.
    @RolesAllowed({ADMIN_ROLE})
    @Path(RESOURCE_PATH_ID_PATH)
    public Response updatePatient(@PathParam(RESOURCE_PATH_ID_ELEMENT) int id, Patient updatedPatient) {
        LOG.debug("updating patient with ID: {}", id);
        Patient existingPatient = service.getPatientById(id);
        if (existingPatient == null) {
            return Response.status(Status.NOT_FOUND).build();
        }
        updatedPatient.setId(id); // Ensure the correct ID is used
        Patient savedPatient = service.updatePatient(updatedPatient);
        return Response.ok(savedPatient).build();
    }

    @DELETE
    // Only a user with the SecurityRole ‘ADMIN_ROLE’ can delete a patient.
    @RolesAllowed({ADMIN_ROLE})
    @Path(RESOURCE_PATH_ID_PATH)
    public Response deletePatient(@PathParam(RESOURCE_PATH_ID_ELEMENT) int id) {
        LOG.debug("deleting patient with ID: {}", id);
        try {
            service.deletePatientById(id);
            return Response.status(Status.NO_CONTENT).build(); // HTTP 204 No Content
        } catch (Exception e) {
            LOG.error("Error deleting patient with ID: {}", id, e);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
