package za.ac.cput.Controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.DTO.LoginRequest;
import za.ac.cput.DTO.LoginResponse;
import za.ac.cput.domain.JobSeeker;
import za.ac.cput.factory.JobSeekerFactory;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserControllerTest {

    @LocalServerPort
    private int port;

    private String BASE_URL;

    private static LoginResponse testLoginResponse;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        BASE_URL = "http://localhost:" + port + "/api/users/";
    }

    @Test
    @Order(1)
    void signUp() {
        JobSeeker jobSeeker = JobSeekerFactory.createJobSeeker(
                "user.signup@gmail.com",
                "myPass123",
                "User",
                "Test",
                "0844445555",
                "Cape Town",
                "Developer",
                "Test summary"
        );

        String url = BASE_URL + "signup";
        ResponseEntity<LoginResponse> response = restTemplate.postForEntity(url, jobSeeker, LoginResponse.class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getToken());

        testLoginResponse = response.getBody();
    }

    @Test
    @Order(2)
    void login() {
        assertNotNull(testLoginResponse);

        LoginRequest loginRequest = new LoginRequest("user.signup@gmail.com", "myPass123");

        String url = BASE_URL + "login";
        ResponseEntity<LoginResponse> response = restTemplate.postForEntity(url, loginRequest, LoginResponse.class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("user.signup@gmail.com", response.getBody().getEmail());
        assertNotNull(response.getBody().getToken());
    }

    @Test
    @Order(3)
    void changePassword() {
        assertNotNull(testLoginResponse);

        Map<String, String> payload = Map.of(
                "userId", testLoginResponse.getUserId(),
                "oldPassword", "myPass123",
                "newPassword", "newPass456"
        );

        String url = BASE_URL + "change-password";
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(testLoginResponse.getToken());
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(payload, headers);

        ResponseEntity<Boolean> response = restTemplate.postForEntity(url, requestEntity, Boolean.class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody());
    }
}
