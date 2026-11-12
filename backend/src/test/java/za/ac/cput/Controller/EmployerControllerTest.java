package za.ac.cput.Controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Employer;
import za.ac.cput.domain.Role;
import za.ac.cput.factory.EmployerFactory;
import za.ac.cput.security.JwtUtil;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployerControllerTest {

    @LocalServerPort
    private int port;

    private String BASE_URL;

    private static Employer employer;
    private static String employerToken;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private JwtUtil jwtUtil;

    @BeforeEach
    void setUp() {
        BASE_URL = "http://localhost:" + port + "/api/employers/";
    }

    @Test
    @Order(1)
    void createEmployer() {
        employer = EmployerFactory.createEmployer(
                "masinaa55@gmail.com", "123masina",
                "Pamela", "Masina",
                "CPUT", "Information Technology");
        assertNotNull(employer);
        assertNull(employer.getUserId());

        String url = BASE_URL + "create";
        ResponseEntity<Employer> response = restTemplate.postForEntity(url, employer, Employer.class);

        assertNotNull(response.getBody());
        employer = response.getBody();
        assertNotNull(employer.getUserId());
        employerToken = jwtUtil.generateToken(employer.getEmail(), Role.EMPLOYER);
    }

    @Test
    @Order(2)
    void readEmployer() {
        assertNotNull(employer);

        String url = BASE_URL + "read/" + employer.getUserId();
        ResponseEntity<Employer> response = restTemplate.getForEntity(url, Employer.class);

        assertNotNull(response.getBody());
    }

    @Test
    @Order(3)
    void updateEmployer() {
        assertNotNull(employer);

        Employer updatedEmployer = Employer.builder()
                .userId(employer.getUserId())
                .email(employer.getEmail())
                .password(employer.getPassword())
                .firstName(employer.getFirstName())
                .lastName(employer.getLastName())
                .companyName("CPUT Updated")
                .industry(employer.getIndustry())
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(employerToken);

        String url = BASE_URL + "update";
        HttpEntity<Employer> requestEntity = new HttpEntity<>(updatedEmployer, headers);
        ResponseEntity<Employer> response = restTemplate.exchange(
                url,
                HttpMethod.PUT,
                requestEntity,
                Employer.class
        );

        assertNotNull(response.getBody());
        employer = response.getBody();
    }

    @Test
    @Order(4)
    void getAllEmployers() {
        String url = BASE_URL + "getAll";
        ResponseEntity<Employer[]> response = restTemplate.getForEntity(url, Employer[].class);

        assertNotNull(response.getBody());
}

    @Test
    @Order(5)
    @Disabled
    void deleteEmployer() {
        assertNotNull(employer);

        String url = BASE_URL + "delete/" + employer.getUserId();
        restTemplate.delete(url);

        String readUrl = BASE_URL + "read/" + employer.getUserId();
        ResponseEntity<Employer> getResponse = restTemplate.getForEntity(readUrl, Employer.class);

        assertNull(getResponse.getBody());
}
}