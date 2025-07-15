package acmemedical;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.lang.invoke.MethodHandles;
import java.net.URI;
import java.util.List;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.logging.LoggingFeature;
import org.junit.jupiter.api.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class TestACMEMedicalSystem {
    private static final Class<?> _thisClaz = MethodHandles.lookup().lookupClass();
    private static final Logger logger = LogManager.getLogger(_thisClaz);

    static final String HTTP_SCHEMA = "http";
    static final String HOST = "localhost";
    static final int PORT = 8080;

    static final String PHYSICIAN_RESOURCE = "physician";
    static final String PATIENT_RESOURCE = "patient";
    static final String MEDICINE_RESOURCE = "medicine";
    static final String MEDICALSCHOOL_RESOURCE = "medicalschool";

    static URI uri;
    static HttpAuthenticationFeature adminAuth;
    static HttpAuthenticationFeature userAuth8277;
    static HttpAuthenticationFeature userAuth8288;

    @BeforeAll
    public static void oneTimeSetUp() throws Exception {
        uri = UriBuilder.fromUri("/rest-acmemedical/api/v1").scheme(HTTP_SCHEMA).host(HOST).port(PORT).build();
        adminAuth = HttpAuthenticationFeature.basic("admin", "admin");
        userAuth8277 = HttpAuthenticationFeature.basic("cst8277", "8277");
        userAuth8288 = HttpAuthenticationFeature.basic("cst8288", "8288");
    }

    protected WebTarget webTarget;

    @BeforeEach
    public void setUp() {
        Client client = ClientBuilder.newClient().register(MyObjectMapperProvider.class).register(new LoggingFeature());
        webTarget = client.target(uri);
    }

    // ---------- PHYSICIAN TESTS ----------
    // 1. GET All Physicians (admin)
    @Test
    public void test01_getAllPhysicians_admin() {
        Response response = webTarget.register(adminAuth).path(PHYSICIAN_RESOURCE).request().get();
        assertThat(response.getStatus(), is(200));
        List<Object> list = response.readEntity(new GenericType<List<Object>>() {});
        assertThat(list, is(not(empty())));
    }

    // 2. GET All Physicians (user)
    @Test
    public void test02_getAllPhysicians_user() {
        Response response = webTarget.register(userAuth8277).path(PHYSICIAN_RESOURCE).request().get();
        assertThat(response.getStatus(), is(403));
    }

    // 3. GET Physician By ID (admin)
    @Test
    public void test03_getPhysicianById_admin() {
        Response response = webTarget.register(adminAuth).path(PHYSICIAN_RESOURCE).path("1").request().get();
        assertThat(response.getStatus(), anyOf(is(200), is(404)));
    }
    
    // 4. POST a new Physician (admin)
    @Test
    public void test04_createPhysician_admin() {
        String newPhysician = "{\"name\":\"Dr. Smith\",\"specialization\":\"Cardiology\"}";
        Response response = webTarget.register(adminAuth).path(PHYSICIAN_RESOURCE)
                .request().post(Entity.json(newPhysician));
        assertThat(response.getStatus(), is(201));
    }

    // 5. DELETE a Physician (admin)
    @Test
    public void test05_deletePhysician_admin() {
        Response response = webTarget.register(adminAuth).path(PHYSICIAN_RESOURCE).path("1").request().delete();
        assertThat(response.getStatus(), anyOf(is(200), is(404)));
    }

    // ---------- PATIENT TESTS ----------
    // 6. GET All Patients (admin)
    @Test
    public void test06_getAllPatients_admin() {
        Response response = webTarget.register(adminAuth).path(PATIENT_RESOURCE).request().get();
        assertThat(response.getStatus(), is(200));
        List<Object> list = response.readEntity(new GenericType<List<Object>>() {});
        assertThat(list, is(not(empty())));
    }

    // 7. GET Patient By ID (user)
    @Test
    public void test07_getPatientById_user() {
        Response response = webTarget.register(userAuth8288).path(PATIENT_RESOURCE).path("1").request().get();
        assertThat(response.getStatus(), anyOf(is(200), is(404)));
    }

    // ---------- MEDICINE TESTS ----------
    // 8. GET All Medicines (admin)
    @Test
    public void test08_getAllMedicines_admin() {
        Response response = webTarget.register(adminAuth).path(MEDICINE_RESOURCE).request().get();
        assertThat(response.getStatus(), is(200));
        List<Object> list = response.readEntity(new GenericType<List<Object>>() {});
        assertThat(list, is(not(empty())));
    }

    // 9. POST a new Medicine (admin)
    @Test
    public void test09_createMedicine_admin() {
        String newMedicine = "{\"name\":\"Aspirin\",\"manufacturer\":\"PharmaCo\"}";
        Response response = webTarget.register(adminAuth).path(MEDICINE_RESOURCE)
                .request().post(Entity.json(newMedicine));
        assertThat(response.getStatus(), is(201));
    }

    // 10. DELETE a Medicine (admin)
    @Test
    public void test10_deleteMedicine_admin() {
        Response response = webTarget.register(adminAuth).path(MEDICINE_RESOURCE).path("1").request().delete();
        assertThat(response.getStatus(), anyOf(is(200), is(404)));
    }
}