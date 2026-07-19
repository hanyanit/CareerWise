package za.ac.cput.Service.impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.Job;
import za.ac.cput.domain.JobSeeker;
import za.ac.cput.factory.JobFactory;
import za.ac.cput.repository.IJobRepository;
import za.ac.cput.repository.ISkillRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class JobServiceImplTest {

    @Autowired
    private IJobRepository jobRepository;

    @Autowired
    private JobServiceImpl jobService;

    private static Job job = JobFactory.createJob("101","Software Developer","Build clean code using Java and Springboot",
            List.of("2 years experience", "Spring Framework", "RESTful APIs: @RestController, HTTP methods, status codes"),
            List.of("Participate in code refactoring sessions", "Update dependencies and security patches", "Review and update documentation"),
            "Cape Town",false,"50 000 - 70 000","Permanent",
            LocalDate.of(2026, 11, 25),"OPEN");

    @BeforeAll
    static void setUp(@Autowired IJobRepository jobRepository) {
        jobRepository.deleteAll();
    }

    @Test
    @Order(1)
    void create() {

        Job created = jobService.create(job);
        assertNotNull(created);

        System.out.println("Created Job" + created);
    }

    @Test
    @Order(2)
    void read() {
        Job found = jobService.read(job.getJobId());
        assertNotNull(found);
        assertEquals(job.getJobId(), found.getJobId());

        System.out.println("Read: " + found);
    }

    @Test
    @Order(3)
    void update() {
        Job updated = new Job.Builder()
                .copy(job)
                .setLocation("Durban")
                .build();

        Job result = jobService.update(updated);

        assertNotNull(result);
        assertEquals("Durban", result.getLocation());

        System.out.println("Updated: " + result);
    }

    @Test
    @Order(4)
    void getAll() {
        List<Job> job = jobService.getAll();

        assertNotNull(job);
        assertFalse(job.isEmpty());

        System.out.println("All jobs: " + job);
    }

    @Test
    @Order(5)
    void findOpenPositions() {
        List<Job> jobs = jobService.findOpenPositions();
        assertTrue(
                jobs.stream()
                        .allMatch(j -> j.getStatus().equals("OPEN"))
        );
    }

    @Test
    @Order(6)
    void findJobsByLocation() {
        List<Job> jobs = jobService.findJobsByLocation("Durban");

        assertNotNull(jobs);
        assertFalse(jobs.isEmpty());
        assertTrue(jobs.stream()
                .allMatch(j -> j.getLocation().equals("Durban")));

        System.out.println("Found by location: " + jobs);
    }

    @Test
    @Order(7)
    void findJobsByEmploymentType() {
        List<Job> jobs = jobService.findJobsByEmploymentType("Permanent");

        assertNotNull(jobs);
        assertFalse(jobs.isEmpty());
        assertTrue(jobs.stream()
                .allMatch(j -> j.getEmploymentType().equals("Permanent")));

        System.out.println("Found by Employment Type: " + jobs);
    }

    @Test
    @Order(8)
    void findJobsByRemoteOption() {
        List<Job> jobs = jobService.findJobsByRemoteOption(false);

        assertNotNull(jobs);
        assertFalse(jobs.isEmpty());
        assertTrue(jobs.stream()
                .allMatch(j -> j.getRemoteOption().equals(false)));

        System.out.println("Found by Remote Option: " + jobs);
    }

    @Test
    @Order(9)
    void delete() {
        String id = job.getJobId();
        jobService.delete(id);

        // Verify deletion by attempting to read — expect null or empty
        Job deleted = jobService.read(id);
        assertNull(deleted);
    }
}
