package acmemedical.rest.resource;

import acmemedical.entity.MedicalTraining;
import acmemedical.ejb.ACMEMedicalService;
import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import static acmemedical.utility.MyConstants.MEDICAL_TRAINING_RESOURCE_NAME;

@Path(MEDICAL_TRAINING_RESOURCE_NAME)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MedicalTrainingResource {

    @EJB
    private ACMEMedicalService medicalService;

    @GET
    @Path("/{id}")
    public Response getMedicalTrainingById(@PathParam("id") int id) {
        try {
            MedicalTraining training = medicalService.getMedicalTrainingById(id);
            return Response.ok(training).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND)
                           .entity("Medical Training not found with ID: " + id).build();
        }
    }

    @POST
    public Response addMedicalTraining(MedicalTraining newTraining) {
        try {
            MedicalTraining training = medicalService.persistMedicalTraining(newTraining);
            return Response.status(Response.Status.CREATED).entity(training).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Error adding training: " + e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateMedicalTraining(@PathParam("id") int id, MedicalTraining updatedTraining) {
        try {
            MedicalTraining training = medicalService.updateMedicalTraining(id, updatedTraining);
            return Response.ok(training).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Error updating training: " + e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMedicalTraining(@PathParam("id") int id) {
        try {
            medicalService.deleteMedicalCertificate(id);  // Ensure relationships are handled
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Error deleting training: " + e.getMessage()).build();
        }
    }
}
