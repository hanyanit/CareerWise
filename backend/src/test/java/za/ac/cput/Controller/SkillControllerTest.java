package za.ac.cput.Controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Skill;
import za.ac.cput.factory.SkillFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SkillControllerTest {

    @LocalServerPort
    private int port;

    private String BASE_URL;

    private static Skill skill;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    void setUp() {

        BASE_URL = "http://localhost:" + port + "/skill/";
    }

    @Test
    @Order(1)
    void create() {
        // Create a new skill
        skill = SkillFactory.createSkill("COBOL", "Programming Language", 6);
        assertNotNull(skill, "Skill object creation failed");
        assertNotNull(skill.getSkillId(), "Skill ID should be generated");

        System.out.println("Creating skill: " + skill);

        String url = BASE_URL + "create";
        ResponseEntity<Skill> response = restTemplate.postForEntity(url, skill, Skill.class);

        assertNotNull(response.getBody(), "Response body should not be null");

        Skill createdSkill = response.getBody();
        assertNotNull(createdSkill.getSkillId(), "Created skill should have an ID");
        assertEquals(skill.getName(), createdSkill.getName(), "Skill names should match");
        assertEquals(skill.getCategory(), createdSkill.getCategory(), "Skill categories should match");
        assertEquals(skill.getYearsOfExperience(), createdSkill.getYearsOfExperience(), "Years of experience should match");

        // Update the static skill with the response
        skill = createdSkill;

        System.out.println("Created skill with ID: " + createdSkill.getSkillId());
    }

    @Test
    @Order(2)
    void read() {
        assertNotNull(skill, "Skill should have been created in previous test");
        assertNotNull(skill.getSkillId(), "Skill ID should not be null");

        String url = BASE_URL + "read/" + skill.getSkillId();
        System.out.println("Reading skill at URL: " + url);

        ResponseEntity<Skill> response = restTemplate.getForEntity(url, Skill.class);

        assertNotNull(response.getBody(), "Response body should not be null");

        Skill retrievedSkill = response.getBody();
        assertEquals(skill.getSkillId(), retrievedSkill.getSkillId(), "Skill IDs should match");
        assertEquals(skill.getName(), retrievedSkill.getName(), "Skill names should match");
        assertEquals(skill.getCategory(), retrievedSkill.getCategory(), "Skill categories should match");
        assertEquals(skill.getYearsOfExperience(), retrievedSkill.getYearsOfExperience(), "Years of experience should match");

        System.out.println("Retrieved skill: " + retrievedSkill);
    }

    @Test
    @Order(3)
    void update() {
        assertNotNull(skill, "Skill should have been created in previous test");
        assertNotNull(skill.getSkillId(), "Skill ID should not be null");

        // Update the skill
        Skill updatedSkill = new Skill.Builder()
                .copy(skill)
                .setName("COBOL Updated")
                .setYearsOfExperience(8)
                .build();

        String url = BASE_URL + "update";
        System.out.println("Updating skill at URL: " + url);

        ResponseEntity<Skill> response = restTemplate.postForEntity(url, updatedSkill, Skill.class);

        assertNotNull(response.getBody(), "Response body should not be null");

        Skill updated = response.getBody();
//        assertEquals(skill.getSkillId(), updated.getSkillId(), "Skill IDs should match");
        assertEquals("COBOL Updated", updated.getName(), "Skill name should be updated");
        assertEquals(8, updated.getYearsOfExperience(), "Years of experience should be updated");

        skill = updated;

        System.out.println("Updated skill: " + updated);
    }

    @Test
    @Order(4)
    void getAll() {
        String url = BASE_URL + "getAll";
        System.out.println("Getting all skills at URL: " + url);

        ResponseEntity<Skill[]> response = restTemplate.getForEntity(url, Skill[].class);



        Skill[] skills = response.getBody();
        assertTrue(skills.length > 0, "Should have at least one skill");

        System.out.println("Found " + skills.length + " skills");
        for (Skill s : skills) {
            System.out.println("- " + s.getName() + " (" + s.getSkillId() + ")");
        }
    }

    @Test
    @Order(5)
    @Disabled
    void delete() {
        assertNotNull(skill, "Skill should have been created in previous test");
        assertNotNull(skill.getSkillId(), "Skill ID should not be null");

        String url = BASE_URL + "delete/" + skill.getSkillId();
        System.out.println("Deleting skill at URL: " + url);

        restTemplate.delete(url);

        // Verify deletion - try to read the skill
        String readUrl = BASE_URL + "read/" + skill.getSkillId();
        ResponseEntity<Skill> getResponse = restTemplate.getForEntity(readUrl, Skill.class);


        System.out.println("Deleted skill with ID: " + skill.getSkillId());
    }
}