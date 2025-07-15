package acmemedical.rest.resource;

import acmemedical.entity.MedicalCertificate;
import acmemedical.entity.Physician;
import acmemedical.ejb.ACMEMedicalService;

import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/medical-certificates")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MedicalCertificateResource {

    // Injecting the service that manages MedicalCertificate entities
    @EJB
    private ACMEMedicalService medicalService;

    /**
     * Get all medical certificates for a specific physician.
     *
     * @param physicianId The ID of the physician whose medical certificates are to be fetched.
     * @return A list of medical certificates.
     */
    @GET
    @Path("/physician/{physicianId}")
    public Response getMedicalCertificatesByPhysician(@PathParam("physicianId") int physicianId) {
        try {
            Physician physician = medicalService.getPhysicianById(physicianId);
            if (physician == null) {
                return Response.status(Response.Status.NOT_FOUND)
                               .entity("Physician with ID " + physicianId + " not found.")
                               .build();
            }
            return Response.ok(physician.getMedicalCertificates()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Error fetching certificates: " + e.getMessage())
                           .build();
        }
    }

    /**
     * Delete a specific medical certificate.
     *
     * @param certificateId The ID of the medical certificate to delete.
     * @return A response indicating the result of the deletion.
     */
    @DELETE
    @Path("/{certificateId}")
    public Response deleteMedicalCertificate(@PathParam("certificateId") int certificateId) {
        try {
            MedicalCertificate certificate = medicalService.findMedicalCertificateById(certificateId);
            if (certificate == null) {
                return Response.status(Response.Status.NOT_FOUND)
                               .entity("Medical Certificate with ID " + certificateId + " not found.")
                               .build();
            }

            // Remove the certificate
            medicalService.deleteMedicalCertificate(certificateId);

            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Error deleting certificate: " + e.getMessage())
                           .build();
        }
    }
}
