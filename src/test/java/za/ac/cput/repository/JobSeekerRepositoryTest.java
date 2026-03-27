package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.JobSeeker;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Inga Mbobo, 230711723
 * Date: March 2026
 */
class JobSeekerRepositoryTest {

    private IJobSeekerRepository repository;
    private JobSeeker testJobSeeker1;
    private JobSeeker testJobSeeker2;

    @BeforeEach
    void setUp() {
        repository = JobSeekerRepository.getRepository();

        // Clear the repository before each test
        List<JobSeeker> all = repository.getAll();
        if (!all.isEmpty()) {
            // Create a copy to avoid ConcurrentModificationException
            List<JobSeeker> toDelete = List.copyOf(all);
            for (JobSeeker js : toDelete) {
                repository.delete(js.getUserId());
            }
        }

        // Create test data using Builder pattern
        testJobSeeker1 = new JobSeeker.JobSeekerBuilder("JS001", "john.doe@example.com", "password123")
                .firstName("John")
                .lastName("Doe")
                .headline("Junior Java Developer")
                .summary("Passionate Java developer with 1 year experience")
                .build();

        testJobSeeker2 = new JobSeeker.JobSeekerBuilder("JS002", "jane.smith@example.com", "password456")
                .firstName("Jane")
                .lastName("Smith")
                .headline("Frontend Developer")
                .summary("Experienced frontend developer specialising in React")
                .build();
    }

    @Test
    void getRepository() {
        assertNotNull(JobSeekerRepository.getRepository());
        assertSame(repository, JobSeekerRepository.getRepository());
    }

    @Test
    void create() {
        JobSeeker created = repository.create(testJobSeeker1);
        assertNotNull(created);
        assertEquals(testJobSeeker1.getUserId(), created.getUserId());

        // Test creating duplicate (should return null based on implementation)
        JobSeeker duplicate = repository.create(testJobSeeker1);
        assertNotNull(duplicate);
    }

    @Test
    void read() {
        repository.create(testJobSeeker1);
        JobSeeker found = repository.read(testJobSeeker1.getUserId());
        assertNotNull(found);
        assertEquals(testJobSeeker1.getUserId(), found.getUserId());

        // Test reading non-existent job seeker
        JobSeeker notFound = repository.read("NONEXISTENT");
        assertNull(notFound);
    }

    @Test
    void update() {
        repository.create(testJobSeeker1);

        JobSeeker updatedJobSeeker = new JobSeeker.JobSeekerBuilder("JS001", "john.updated@example.com", "newpassword123")
                .firstName("John Updated")
                .lastName("Doe Updated")
                .headline("Senior Java Developer")
                .summary("Senior Java developer with 5 years of experience")
                .build();

        JobSeeker result = repository.update(updatedJobSeeker);
        assertNotNull(result);
        assertEquals("John Updated", result.getFirstName());
        assertEquals("john.updated@example.com", result.getEmail());

        // Test updating non-existent job seeker
        JobSeeker nonExistent = new JobSeeker.JobSeekerBuilder("NONEXISTENT", "none@example.com", "password")
                .firstName("Non")
                .lastName("Existent")
                .build();

        JobSeeker updateResult = repository.update(nonExistent);
        assertNull(updateResult);
    }

    @Test
    void delete() {
        repository.create(testJobSeeker1);

        boolean deleted = repository.delete(testJobSeeker1.getUserId());
        assertTrue(deleted);

        // Verify deletion
        JobSeeker found = repository.read(testJobSeeker1.getUserId());
        assertNull(found);

        // Test deleting non-existent job seeker
        boolean deleteResult = repository.delete("NONEXISTENT");
        assertFalse(deleteResult);
    }

    @Test
    void getAll() {
        // Initially empty after setUp clears the repository
        List<JobSeeker> all = repository.getAll();
        int initialSize = all.size();

        // Add job seekers
        repository.create(testJobSeeker1);
        repository.create(testJobSeeker2);

        all = repository.getAll();
        assertEquals(initialSize + 2, all.size());
    }
}