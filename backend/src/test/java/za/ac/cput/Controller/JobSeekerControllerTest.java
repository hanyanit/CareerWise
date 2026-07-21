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
import za.ac.cput.domain.JobSeeker;
import za.ac.cput.factory.JobSeekerFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JobSeekerControllerTest {

    @LocalServerPort
    private int port;

    private String BASE_URL;

    private static JobSeeker testJobSeeker;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        BASE_URL = "http://localhost:" + port + "/jobseeker/";
    }

    @Test
    @Order(1)
    void create() {
        testJobSeeker = JobSeekerFactory.createJobSeeker(
                "inga.dev@gmail.com",
                "securePassword123",
                "Inga",
                "Mbobo",
                "profile_picture.png",
                "0712345678",
                "Cape Town",
                "Java Software Engineer",
                "Passionate backend developer with 5 years of experience",
                "inga_resume.pdf",
                "Java, Spring Boot",
                "Diploma in ICT"
        );

        assertNotNull(testJobSeeker);

        String url = BASE_URL + "create";
        ResponseEntity<JobSeeker> response = restTemplate.postForEntity(url, testJobSeeker, JobSeeker.class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        JobSeeker createdJobSeeker = response.getBody();
        assertNotNull(createdJobSeeker.getUserId());

        testJobSeeker = createdJobSeeker;

        System.out.println("Created JobSeeker with ID: " + createdJobSeeker.getUserId());
        System.out.println("Name: " + createdJobSeeker.getFirstName() + " " + createdJobSeeker.getLastName());
    }

    @Test
    @Order(2)
    void read() {
        assertNotNull(testJobSeeker);
        assertNotNull(testJobSeeker.getUserId());

        String url = BASE_URL + "read/" + testJobSeeker.getUserId();
        ResponseEntity<JobSeeker> response = restTemplate.getForEntity(url, JobSeeker.class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        JobSeeker retrievedJobSeeker = response.getBody();
        assertNotNull(retrievedJobSeeker.getUserId());

        System.out.println("Retrieved JobSeeker: " + retrievedJobSeeker.getFirstName() + " " + retrievedJobSeeker.getLastName());
    }

    @Test
    @Order(3)
    void update() {
        assertNotNull(testJobSeeker);
        assertNotNull(testJobSeeker.getUserId());

        JobSeeker updatedJobSeeker = new JobSeeker.Builder()
                .copy(testJobSeeker)
                .setFirstName("Inga Updated")
                .setLastName("Mbobo Updated")
                .setHeadline("Senior Java Software Engineer")
                .setSummary("Updated: Senior backend developer with 7 years of experience")
                .setResumePath("inga_resume_updated.pdf")
                .build();


        String url = BASE_URL + "update";
        HttpEntity<JobSeeker> requestEntity = new HttpEntity<>(updatedJobSeeker);
        ResponseEntity<JobSeeker> response = restTemplate.exchange(
                url,
                HttpMethod.PUT,
                requestEntity,
                JobSeeker.class
        );

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        JobSeeker updated = response.getBody();
        assertNotNull(updated.getUserId());

        testJobSeeker = updated;

        System.out.println("Updated JobSeeker with ID: " + updated.getUserId());
        System.out.println("New Name: " + updated.getFirstName() + " " + updated.getLastName());
    }

    @Test
    @Order(4)
    void getAll() {
        String url = BASE_URL + "getAll";
        ResponseEntity<JobSeeker[]> response = restTemplate.getForEntity(url, JobSeeker[].class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        JobSeeker[] jobSeekers = response.getBody();
        assertNotNull(jobSeekers);
        assertTrue(jobSeekers.length > 0);

        System.out.println("Found " + jobSeekers.length + " JobSeekers in the system");
        for (JobSeeker js : jobSeekers) {
            System.out.println(" - " + js.getFirstName() + " " + js.getLastName() + " (" + js.getUserId() + ")");
        }
    }

    @Test
    @Order(5)
    @Disabled
    void delete() {
        assertNotNull(testJobSeeker);
        assertNotNull(testJobSeeker.getUserId());

        String url = BASE_URL + "delete/" + testJobSeeker.getUserId();
        ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);

        assertNotNull(response);
        assertTrue(response.getStatusCode().is2xxSuccessful());

        String readUrl = BASE_URL + "read/" + testJobSeeker.getUserId();
        ResponseEntity<JobSeeker> getResponse = restTemplate.getForEntity(readUrl, JobSeeker.class);
        assertNotNull(getResponse);

        System.out.println("Deleted JobSeeker with ID: " + testJobSeeker.getUserId());
    }

//    @Test
//    @Order(6)
//    void createWithAutoGeneratedId() {
//        JobSeeker newJobSeeker = JobSeekerFactory.createJobSeeker(
//        "auto.test@gmail.com",
//        "password123",
//        "AutoFistName",
//        "GeneratedLastName",
//        "Auto Generated Headline Example",
//        "This is a test with auto-generated ID"
//);
//
//        assertNotNull(newJobSeeker);
//        assertNotNull(newJobSeeker.getUserId());
//
//        String url = BASE_URL + "create";
//        ResponseEntity<JobSeeker> response = restTemplate.postForEntity(url, newJobSeeker, JobSeeker.class);
//
//        assertNotNull(response);
//        assertTrue(response.getStatusCode().is2xxSuccessful());
//        assertNotNull(response.getBody());
//
//        JobSeeker created = response.getBody();
//        assertNotNull(created.getUserId());
//
//        System.out.println("Created JobSeeker with auto-generated ID: " + created.getUserId());
//        System.out.println("Name: " + created.getFirstName() + " " + created.getLastName());
//
//        String deleteUrl = BASE_URL + "delete/" + created.getUserId();
//        restTemplate.exchange(deleteUrl, HttpMethod.DELETE, null, Void.class);
//        System.out.println("Cleaned up test data");
//    }
}