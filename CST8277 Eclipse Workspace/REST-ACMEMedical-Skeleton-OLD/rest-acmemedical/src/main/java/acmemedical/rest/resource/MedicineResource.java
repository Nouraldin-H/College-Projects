package acmemedical.rest.resource;

import acmemedical.entity.Medicine;
import acmemedical.ejb.ACMEMedicalService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import static acmemedical.utility.MyConstants.ADMIN_ROLE;
import static acmemedical.utility.MyConstants.USER_ROLE;
import static acmemedical.utility.MyConstants.MEDICINE_RESOURCE_NAME;

import java.util.List;

@Path(MEDICINE_RESOURCE_NAME)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MedicineResource {

    @EJB
    private ACMEMedicalService medicalService;

    @GET
    @RolesAllowed({ADMIN_ROLE, USER_ROLE})
    public Response getAllMedicines() {
        try {
            List<Medicine> medicines = medicalService.getAllMedicines(); // Updated method name
            return Response.ok(medicines).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Error fetching medicines: " + e.getMessage()).build();
        }
    }
    
    @GET
    @Path("/{id}")
    @RolesAllowed({ADMIN_ROLE, USER_ROLE})
    public Response getMedicineById(@PathParam("id") int id) {
        try {
            Medicine medicine = medicalService.getMedicineById(id);
            if (medicine == null) {
                return Response.status(Response.Status.NOT_FOUND)
                               .entity("Medicine not found with ID: " + id).build();
            }
            return Response.ok(medicine).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Error fetching medicine: " + e.getMessage()).build();
        }
    }

    @POST
    @RolesAllowed({ADMIN_ROLE})
    public Response addMedicine(Medicine newMedicine) {
        try {
            Medicine medicine = medicalService.persistMedicine(newMedicine); // Updated method name
            return Response.status(Response.Status.CREATED).entity(medicine).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Error adding medicine: " + e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({ADMIN_ROLE})
    public Response updateMedicine(@PathParam("id") int id, Medicine updatedMedicine) {
        try {
            Medicine existingMedicine = medicalService.getMedicineById(id); // Updated method name
            if (existingMedicine == null) {
                return Response.status(Response.Status.NOT_FOUND)
                               .entity("Medicine not found with ID: " + id).build();
            }
            existingMedicine.setDrugName(updatedMedicine.getDrugName());
            existingMedicine.setManufacturerName(updatedMedicine.getManufacturerName());
            existingMedicine.setDosageInformation(updatedMedicine.getDosageInformation());
            medicalService.updateMedicine(existingMedicine); // Updated method name
            return Response.ok(existingMedicine).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Error updating medicine: " + e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({ADMIN_ROLE})
    public Response deleteMedicine(@PathParam("id") int id) {
        try {
            medicalService.deleteMedicine(id); // Updated method name
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Error deleting medicine: " + e.getMessage()).build();
        }
    }
}