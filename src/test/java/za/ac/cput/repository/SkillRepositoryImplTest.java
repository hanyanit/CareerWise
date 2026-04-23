package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Skill;
import za.ac.cput.repository.impl.SkillRepositoryImpl;
/**
 * Employer.java
 * Author: Hanyani Masinge, 222693452
 */

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SkillRepositoryImplTest {

    private ISkillRepository repository;
    private Skill skill1;
    private Skill skill2;

    @BeforeEach
    void setUp() {
        repository = SkillRepositoryImpl.getRepository();

        // Clear repository before each test (important because of Singleton)
        repository.getAll().clear();

        skill1 = new Skill.Builder()
                .skillId("S001")
                .skillName("Java")
                .build();

        skill2 = new Skill.Builder()
                .skillId("S002")
                .skillId("Spring Boot")
                .build();
    }

    @Test
    void create() {
        Skill created = repository.create(skill1);
        assertNotNull(created);
        assertEquals("S001", created.getSkillId());
    }

    @Test
    void read() {
        repository.create(skill1);
        Skill found = repository.read("S001");

        assertNotNull(found);
        assertEquals("Java", found.getName());
    }

    @Test
    void update() {
        repository.create(skill1);

        Skill updatedSkill = new Skill.Builder()
                .copy(skill1)
                .skillName("Advanced Java")
                .build();

        Skill result = repository.update(updatedSkill);

        assertNotNull(result);
        assertEquals("Advanced Java", result.getName());
    }

    @Test
    void delete() {
        repository.create(skill1);

        boolean deleted = repository.delete("S001");

        assertTrue(deleted);
        assertNull(repository.read("S001"));
    }

    @Test
    void getAll() {
        repository.create(skill1);
        repository.create(skill2);

        List<Skill> skills = repository.getAll();

        assertEquals(2, skills.size());
    }}