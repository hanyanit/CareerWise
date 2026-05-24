package za.ac.cput.Controller;

import com.fasterxml.classmate.members.ResolvedParameterizedMember;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.JobSeeker;
import za.ac.cput.domain.Skill;
import za.ac.cput.factory.JobSeekerFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JobSeekerControllerTest {

    private JobSeeker jobSeeker;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String BASE_URL = "http://localhost:";

   private JobSeeker jobseeker2 = JobSeekerFactory.createJobSeeker("emailexample@Gmail.com","passwordexample"
           ,"firstnameExample","lastnameExample","headLineExample","summaryExample : sknadoiashdaiohdadhoaidsa");

    @Test
    @Order(1)
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
    @Order(2)
    void read() {
        String url = BASE_URL + port + "/jobseeker/read/"+ jobseeker2.getSkills();
        ResponseEntity<Skill> response = restTemplate.getForEntity(url,Skill.class);
        assertNotNull(response,"response empty");
//        assertNotNull(response.getBody());
//        System.out.println(response.getBody());
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