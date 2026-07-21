package za.ac.cput.Service.impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.Skill;
import za.ac.cput.factory.SkillFactory;
import za.ac.cput.repository.ISkillRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SkillServiceImpTest {

    @Autowired
    private SkillServiceImp skillService;

    @Autowired
    private ISkillRepository skillRepository;

    private static Skill testSkill;

    @BeforeEach
    void setUp() {
        skillRepository.deleteAll();
    }

    @Test
    @Order(1)
    void create() {
        testSkill = SkillFactory.createSkill("Java", "Programming", 5);
        assertNotNull(testSkill);
        assertNotNull(skillService.create(testSkill));
        System.out.println("Create passed");
    }

    @Test
    @Order(2)
    void read() {
        Skill saved = skillService.create(createTestSkill());
        assertNotNull(saved);
        assertNotNull(skillService.read(saved.getSkillId()));
        System.out.println("Read passed");
    }

    @Test
    @Order(3)
    void update() {
        Skill saved = skillService.create(createTestSkill());
        assertNotNull(saved);

        Skill updated = new Skill.Builder()
                .copy(saved)
                .setName("Updated")
                .build();

        assertNotNull(skillService.update(updated));
        System.out.println("Update passed");
    }

    @Test
    @Order(4)
    @Disabled
    void delete() {
        Skill saved = skillService.create(createTestSkill());
        assertNotNull(saved);

        assertTrue(skillService.delete(saved.getSkillId()));
        assertNull(skillService.read(saved.getSkillId()));
        System.out.println("Delete passed");
    }
    private Skill createTestSkill() {
        return SkillFactory.createSkill("JavaScript", "Web", 3);
    }

    private Skill createTestSkill2() {
        return SkillFactory.createSkill("React", "Frontend", 2);
    }
}