package za.ac.cput.Controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Skill;
import za.ac.cput.factory.SkillFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SkillControllerTest {

    @LocalServerPort
    private int port;

    private String BASE_URL = "http://localhost:";

    private Skill skill = SkillFactory.createSkill("COBOL","Soft Skill", 6);

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @Order(1)
    void create(){

        String  URL = BASE_URL + port + "/skill/create";
        ResponseEntity<Skill> response = restTemplate.postForEntity(URL,skill,Skill.class);
        assertNotNull(skill,"Failed Object creation before hitting the api");
        System.out.println(skill.toString());
        assertNotNull(response);

    }

    @Test
    @Order(2)
    void read(){
        String url = BASE_URL + port + "/skill/read/" + skill.getSkillId();

        ResponseEntity<Skill> response = restTemplate.getForEntity(url,Skill.class);

        assertNotNull(response);
        assertNotNull(response.getBody(),"The response body is empty");
    }

}