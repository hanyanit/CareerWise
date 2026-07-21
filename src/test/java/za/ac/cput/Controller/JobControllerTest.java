package za.ac.cput.Controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Job;
import za.ac.cput.factory.JobFactory;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JobControllerTest {

    @LocalServerPort
    private int port;

    private String BASE_URL;

    private static Job testJob;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        BASE_URL = "http://localhost:" + port + "/Job/";
    }

    @Test
    @Order(1)
    void create() {
        testJob = JobFactory.createJob(
                "201",
                "Backend Developer",
                "Build and maintain REST APIs using Java and Spring Boot",
                List.of("3 years experience", "Spring Boot", "SQL databases"),
                List.of("Design REST endpoints", "Write unit tests", "Participate in code reviews"),
                "Cape Town",
                false,
                "60 000 - 80 000",
                "Permanent",
                LocalDate.of(2026, 12, 1),
                "OPEN"
        );

        assertNotNull(testJob);
        assertNotNull(testJob.getJobId());

        String url = BASE_URL + "create";
        ResponseEntity<Job> response = restTemplate.postForEntity(url, testJob, Job.class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        Job createdJob = response.getBody();
        assertNotNull(createdJob.getJobId());

        testJob = createdJob;

        System.out.println("Created Job with ID: " + createdJob.getJobId());
        System.out.println("Title: " + createdJob.getTitle());
    }

    @Test
    @Order(2)
    void read() {
        assertNotNull(testJob);
        assertNotNull(testJob.getJobId());

        String url = BASE_URL + "read/" + testJob.getJobId();
        ResponseEntity<Job> response = restTemplate.getForEntity(url, Job.class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        Job retrievedJob = response.getBody();
        assertNotNull(retrievedJob.getJobId());

        System.out.println("Retrieved Job: " + retrievedJob.getTitle());
    }

    @Test
    @Order(3)
    void update() {
        assertNotNull(testJob);
        assertNotNull(testJob.getJobId());

        Job updatedJob = new Job.Builder()
                .copy(testJob)
                .setLocation("Durban")
                .setStatus("CLOSED")
                .build();

        String url = BASE_URL + "update";
        HttpEntity<Job> requestEntity = new HttpEntity<>(updatedJob);
        ResponseEntity<Job> response = restTemplate.exchange(
                url,
                HttpMethod.PUT,
                requestEntity,
                Job.class
        );

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        Job updated = response.getBody();
        assertNotNull(updated.getJobId());
        assertEquals("Durban", updated.getLocation());
        assertEquals("CLOSED", updated.getStatus());

        testJob = updated;

        System.out.println("Updated Job with ID: " + updated.getJobId());
        System.out.println("New Location: " + updated.getLocation());
    }

    @Test
    @Order(4)
    void getAll() {
        String url = BASE_URL + "getAll";
        ResponseEntity<Job[]> response = restTemplate.getForEntity(url, Job[].class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        Job[] jobs = response.getBody();
        assertNotNull(jobs);
        assertTrue(jobs.length > 0);

        System.out.println("Found " + jobs.length + " Jobs in the system");
        for (Job j : jobs) {
            System.out.println(" - " + j.getTitle() + " (" + j.getJobId() + ")");
        }
    }

    @Test
    @Order(5)
    void findOpenPositions() {
        String url = BASE_URL + "findOpenPositions";
        ResponseEntity<Job[]> response = restTemplate.getForEntity(url, Job[].class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        Job[] jobs = response.getBody();
        assertNotNull(jobs);

        for (Job j : jobs) {
            assertEquals("OPEN", j.getStatus());
        }

        System.out.println("Found " + jobs.length + " open positions");
    }

    @Test
    @Order(6)
    void findJobsByLocation() {
        String url = BASE_URL + "findJobsByLocation/Durban";
        ResponseEntity<Job[]> response = restTemplate.getForEntity(url, Job[].class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        Job[] jobs = response.getBody();
        assertNotNull(jobs);
        assertFalse(jobs.length == 0);

        System.out.println("Found " + jobs.length + " Jobs in Durban");
    }

    @Test
    @Order(7)
    void findJobsByEmploymentType() {
        String url = BASE_URL + "findJobsByEmploymentType/Permanent";
        ResponseEntity<Job[]> response = restTemplate.getForEntity(url, Job[].class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        Job[] jobs = response.getBody();
        assertNotNull(jobs);
        assertFalse(jobs.length == 0);

        System.out.println("Found " + jobs.length + " Permanent Jobs");
    }

    @Test
    @Order(8)
    void findJobsByRemoteOption() {
        String url = BASE_URL + "findJobsByRemoteOption/false";
        ResponseEntity<Job[]> response = restTemplate.getForEntity(url, Job[].class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        Job[] jobs = response.getBody();
        assertNotNull(jobs);

        System.out.println("Found " + jobs.length + " non-remote Jobs");
    }

    @Test
    @Order(9)
    void delete() {
        assertNotNull(testJob);
        assertNotNull(testJob.getJobId());

        String url = BASE_URL + "delete/" + testJob.getJobId();
        ResponseEntity<Boolean> response = restTemplate.exchange(url, HttpMethod.DELETE, null, Boolean.class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(Boolean.TRUE.equals(response.getBody()));

        System.out.println("Deleted Job with ID: " + testJob.getJobId());
    }
}