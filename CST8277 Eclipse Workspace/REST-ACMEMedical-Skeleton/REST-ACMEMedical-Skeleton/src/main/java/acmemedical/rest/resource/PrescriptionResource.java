package acmemedical.rest.resource;

import acmemedical.entity.Prescription;
import acmemedical.entity.PrescriptionPK;
import acmemedical.ejb.ACMEMedicalService;
import jakarta.ejb.EJB;
import jakarta.persistence.EntityNotFoundException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import static acmemedical.utility.MyConstants.PRESCRIPTION_RESOURCE_NAME;

@Path(PRESCRIPTION_RESOURCE_NAME)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PrescriptionResource {

    @EJB
    private ACMEMedicalService medicalService;

    /**
     * Get all prescriptions.
     */
    @GET
    public Response getAllPrescriptions() {
        try {
            List<Prescription> prescriptions = medicalService.getAllPrescriptions();
            return Response.ok(prescriptions).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Error fetching prescriptions: " + e.getMessage()).build();
        }
    }

    /**
     * Get prescriptions by physician ID.
     */
    @GET
    @Path("/physician/{physicianId}")
    public Response getPrescriptionsByPhysician(@PathParam("physicianId") int physicianId) {
        try {
            List<Prescription> prescriptions = medicalService.getPrescriptionsByPhysicianId(physicianId);
            return Response.ok(prescriptions).build();
        } catch (EntityNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND)
                           .entity("Physician with ID " + physicianId + " not found.").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Error fetching prescriptions: " + e.getMessage()).build();
        }
    }

    /**
     * Get prescriptions by patient ID.
     */
    @GET
    @Path("/patient/{patientId}")
    public Response getPrescriptionsByPatient(@PathParam("patientId") int patientId) {
        try {
            List<Prescription> prescriptions = medicalService.getPrescriptionsByPatientId(patientId);
            return Response.ok(prescriptions).build();
        } catch (EntityNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND)
                           .entity("Patient with ID " + patientId + " not found.").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Error fetching prescriptions: " + e.getMessage()).build();
        }
    }

    /**
     * Add a new prescription.
     */
    @POST
    public Response addPrescription(Prescription newPrescription) {
        try {
            Prescription prescription = medicalService.persistPrescription(newPrescription);
            return Response.status(Response.Status.CREATED).entity(prescription).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Error adding prescription: " + e.getMessage()).build();
        }
    }

    /**
     * Update an existing prescription.
     */
    @PUT
    public Response updatePrescription(Prescription updatedPrescription) {
        try {
            Prescription prescription = medicalService.updatePrescription(updatedPrescription);
            return Response.ok(prescription).build();
        } catch (EntityNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND)
                           .entity("Prescription not found with ID: " + updatedPrescription.getId()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Error updating prescription: " + e.getMessage()).build();
        }
    }

    /**
     * Delete a prescription by composite key (physicianId and patientId).
     */
    @DELETE
    @Path("/{physicianId}/{patientId}")
    public Response deletePrescription(@PathParam("physicianId") int physicianId,
                                       @PathParam("patientId") int patientId) {
        try {
            PrescriptionPK prescriptionPK = new PrescriptionPK(physicianId, patientId);
            medicalService.deletePrescriptionById(prescriptionPK);
            return Response.noContent().build();
        } catch (EntityNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND)
                           .entity("Prescription not found with Physician ID: " + physicianId +
                                   " and Patient ID: " + patientId).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Error deleting prescription: " + e.getMessage()).build();
        }
    }

    /**
     * Get a prescription by composite key (physicianId and patientId).
     */
    @GET
    @Path("/{physicianId}/{patientId}")
    public Response getPrescriptionById(@PathParam("physicianId") int physicianId,
                                        @PathParam("patientId") int patientId) {
        try {
            PrescriptionPK prescriptionPK = new PrescriptionPK(physicianId, patientId);
            Prescription prescription = medicalService.getPrescriptionById(prescriptionPK);
            return Response.ok(prescription).build();
        } catch (EntityNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND)
                           .entity("Prescription not found with Physician ID: " + physicianId +
                                   " and Patient ID: " + patientId).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Error fetching prescription: " + e.getMessage()).build();
        }
    }
}