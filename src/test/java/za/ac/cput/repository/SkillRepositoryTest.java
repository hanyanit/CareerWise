package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import za.ac.cput.domain.Skill;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SkillRepositoryTest {

    @Autowired
    private SkillRepository repository;

    private Skill skill1;
    private Skill skill2;

    @BeforeEach
    void setUp() {
        skill1 = new Skill.Builder()
                .setSkillId("S001")
                .setName("Java")
                .setCategory("Programming")
                .setYearsOfExperience(5)
                .build();

        skill2 = new Skill.Builder()
                .setSkillId("S002")
                .setName("Spring Boot")
                .setCategory("Framework")
                .setYearsOfExperience(3)
                .build();
    }

    @Test
    void create() {
        Skill created = repository.save(skill1);
        assertNotNull(created);
        assertEquals("S001", created.getSkillId());
    }

    @Test
    void read() {
        repository.save(skill1);
        Skill found = repository.findById("S001").orElse(null);
        assertNotNull(found);
        assertEquals("Java", found.getName());
    }

    @Test
    void update() {
        repository.save(skill1);

        Skill updatedSkill = new Skill.Builder()
                .setSkillId("S001")
                .setName("Advanced Java")
                .setCategory("Programming")
                .setYearsOfExperience(5)
                .build();

        Skill result = repository.save(updatedSkill);
        assertNotNull(result);
        assertEquals("Advanced Java", result.getName());
    }

    @Test
    void delete() {
        repository.save(skill1);
        repository.deleteById("S001");
        boolean exists = repository.existsById("S001");
        assertFalse(exists);
    }

    @Test
    void getAll() {
        repository.save(skill1);
        repository.save(skill2);
        List<Skill> skills = repository.findAll();
        assertEquals(2, skills.size());
    }
}