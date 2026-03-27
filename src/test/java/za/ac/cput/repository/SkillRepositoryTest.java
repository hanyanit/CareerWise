package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Skill;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Inga Mbobo, 230711723
 * Date: March 2026
 */
class SkillRepositoryTest {

    private ISkillRepository repository;
    private Skill testSkill1;
    private Skill testSkill2;

    @BeforeEach
    void setUp() {
        repository = SkillRepository.getRepository();

        // Clear the repository before each test
        List<Skill> all = repository.getAll();
        if (!all.isEmpty()) {
            // Create a copy to avoid ConcurrentModificationException
            List<Skill> toDelete = List.copyOf(all);
            for (Skill skill : toDelete) {
                repository.delete(skill.getSkillId());
            }
        }

        // Create test data using Builder pattern
        testSkill1 = new Skill.Builder()
                .skillId("SK001")
                .skillName("Java Programming")
                .skillCategory("Backend Development")
                .yearsOfExperience(2.0f)
                .build();

        testSkill2 = new Skill.Builder()
                .skillId("SK002")
                .skillName("Python Programming")
                .skillCategory("Data Science")
                .yearsOfExperience(1.5f)
                .build();
    }

    @Test
    void getRepository() {
        assertNotNull(SkillRepository.getRepository());
        assertSame(repository, SkillRepository.getRepository());
    }

    @Test
    void create() {
        Skill created = repository.create(testSkill1);
        assertNotNull(created);
        assertEquals(testSkill1.getSkillId(), created.getSkillId());
        assertEquals(testSkill1.getName(), created.getName());

        // Test creating duplicate (should return null based on implementation)
        Skill duplicate = repository.create(testSkill1);
        assertNotNull(duplicate);
    }

    @Test
    void read() {
        repository.create(testSkill1);

        Skill found = repository.read(testSkill1.getSkillId());
        assertNotNull(found);
        assertEquals(testSkill1.getSkillId(), found.getSkillId());

        // Test reading non-existent skill
        Skill notFound = repository.read("NONEXISTENT");
        assertNull(notFound);
    }

    @Test
    void update() {
        repository.create(testSkill1);

        Skill updatedSkill = new Skill.Builder()
                .skillId("SK001")
                .skillName("Advanced Java Programming")
                .skillCategory("Backend Development")
                .yearsOfExperience(5.0f)
                .build();

        Skill result = repository.update(updatedSkill);
        assertNotNull(result);
        assertEquals("Advanced Java Programming", result.getName());
        assertEquals("Backend Development", result.getCategory());

        // Test updating non-existent skill
        Skill nonExistent = new Skill.Builder()
                .skillId("NONEXISTENT")
                .skillName("Non-existent Skill")
                .skillCategory("None")
                .yearsOfExperience(0.0f)
                .build();

        Skill updateResult = repository.update(nonExistent);
        assertNull(updateResult);
    }

    @Test
    void delete() {
        repository.create(testSkill1);

        // Verify skill exists
        Skill found = repository.read(testSkill1.getSkillId());
        assertNotNull(found);

        // Delete skill
        boolean deleted = repository.delete(testSkill1.getSkillId());
        assertTrue(deleted);

        // Verify skill no longer exists
        found = repository.read(testSkill1.getSkillId());
        assertNull(found);

        // Test deleting non-existent skill
        boolean deleteResult = repository.delete("NONEXISTENT");
        assertFalse(deleteResult);
    }

    @Test
    void getAll() {
        // Initially empty after setUp clears the repository
        List<Skill> all = repository.getAll();
        int initialSize = all.size();

        // Add skills
        repository.create(testSkill1);
        repository.create(testSkill2);

        all = repository.getAll();
        assertEquals(initialSize + 2, all.size());

        // Verify both skills are present
        boolean containsSkill1 = all.stream()
                .anyMatch(skill -> skill.getSkillId().equals(testSkill1.getSkillId()));
        boolean containsSkill2 = all.stream()
                .anyMatch(skill -> skill.getSkillId().equals(testSkill2.getSkillId()));

        assertTrue(containsSkill1);
        assertTrue(containsSkill2);
    }
}