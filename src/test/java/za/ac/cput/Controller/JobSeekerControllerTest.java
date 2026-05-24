package za.ac.cput.Controller;

import com.fasterxml.classmate.members.ResolvedParameterizedMember;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.JobSeeker;
import za.ac.cput.factory.JobSeekerFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class JobSeekerControllerTest {

    private JobSeeker jobSeeker;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String BASE_URL = "http://localhost:";

    @Test
    void create() {
        String URL = BASE_URL + port + "/jobseeker/create";


        jobSeeker = JobSeekerFactory.createFullJobSeeker(
                "U12345",
                "inga.dev@gmail.com",
                "securePassword123",
                "Inga",
                "Mbobo",
                "profile_picture.png",
                "0712345678",
                "Cape Town",
                "Java Software Engineer",
                "Passionate backend developer",
                "inga_resume.pdf"
        );

        assertNotNull(jobSeeker);

        ResponseEntity<JobSeeker> response = restTemplate.postForEntity(URL,jobSeeker,JobSeeker.class);
        assertNotNull(response);
        System.out.println(response);
    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }
}