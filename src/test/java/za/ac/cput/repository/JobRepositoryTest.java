package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Job;
import za.ac.cput.repository.impl.JobRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JobRepositoryTest {
    private IJobRepository repository;
    private Job job1;
    private Job job2;
    private Job job3;
    private Job job4;

    @BeforeEach
    void setup() {
        repository = JobRepository.getRepository();

        // Clear repository
        List<Job> all = repository.getAll();
        for (Job job : all) {
            repository.delete(job.getJobId());
        }

        job1 = new Job.Builder()
                .setJobId("0001")
                .setTitle("Software Developer")
                .setEmploymentType("Permanent")
                .setDescription("Junior Java Developer")
                .setStatus("OPEN")
                .setRemoteOption(false)
                .setLocation("Cape Town")
                .setSalaryRange("50000-60000")
                .build();

        job2 = new Job.Builder()
                .setJobId("0002")
                .setTitle("Software Developer")
                .setEmploymentType("Permanent")
                .setDescription("Senior Python Developer")
                .setStatus("OPEN")
                .setRemoteOption(true)
                .setLocation("Johannesburg")
                .setSalaryRange("60000-70000")
                .build();

        job3 = new Job.Builder()
                .setJobId("0003")
                .setTitle("Web Developer")
                .setEmploymentType("Contract")
                .setDescription("Junior Web Developer")
                .setStatus("OPEN")
                .setRemoteOption(false)
                .setLocation("Cape Town")
                .setSalaryRange("40000-50000")
                .build();

        job4 = new Job.Builder()
                .setJobId("0004")
                .setTitle("Data Scientist")
                .setEmploymentType("Permanent")
                .setDescription("Senior Data Scientist")
                .setStatus("CLOSED")
                .setRemoteOption(true)
                .setLocation("Durban")
                .setSalaryRange("80000-100000")
                .build();
    }

    @Test
    void create() {
        Job created = repository.create(job1);
        assertNotNull(created);
        assertEquals(job1.getJobId(), created.getJobId());

        Job found = repository.read(job1.getJobId());
        assertNotNull(found);
        assertEquals(job1.getJobId(), found.getJobId());
    }

    @Test
    void read() {
        repository.create(job1);

        Job found = repository.read("0001");
        assertNotNull(found);
        assertEquals(job1.getJobId(), found.getJobId());

        Job notFound = repository.read("9999");
        assertNull(notFound);
    }

    @Test
    void update() {
        repository.create(job1);

        Job updatedJob = new Job.Builder()
                .setJobId("0001") // Keep same ID for update
                .setTitle("Senior Software Developer")
                .setEmploymentType("Permanent")
                .setDescription("Senior Java Developer")
                .setStatus("OPEN")
                .setRemoteOption(true)
                .setLocation("Cape Town")
                .setSalaryRange("70000-80000")
                .build();

        Job result = repository.update(updatedJob);

        assertNotNull(result);
        assertEquals("Senior Java Developer", result.getDescription());
        assertEquals("Senior Software Developer", result.getTitle());
        assertEquals("0001", result.getJobId());

        Job found = repository.read("0001");
        assertNotNull(found);
        assertEquals("Senior Java Developer", found.getDescription());
    }

    @Test
    void delete() {
        repository.create(job1);

        boolean deleted = repository.delete("0001");
        assertTrue(deleted);

        Job found = repository.read("0001");
        assertNull(found);
    }

    @Test
    void getAll() {
        repository.create(job1);
        repository.create(job2);
        repository.create(job3);

        List<Job> allJobs = repository.getAll();
        assertNotNull(allJobs);
        assertEquals(3, allJobs.size());
        assertTrue(allJobs.contains(job1));
        assertTrue(allJobs.contains(job2));
        assertTrue(allJobs.contains(job3));
    }

    @Test
    void findOpenPositions() {
        // Add jobs with different statuses
        repository.create(job1); // OPEN
        repository.create(job2); // OPEN
        repository.create(job3); // OPEN
        repository.create(job4); // CLOSED

        List<Job> openPositions = repository.findOpenPositions();

        // Verify - Should find 3 open positions
        assertNotNull(openPositions);
        assertEquals(3, openPositions.size());
        assertTrue(openPositions.contains(job1));
        assertTrue(openPositions.contains(job2));
        assertTrue(openPositions.contains(job3));
        assertFalse(openPositions.contains(job4));
    }

    @Test
    void findJobsByLocation() {
        repository.create(job1); // Cape Town
        repository.create(job2); // Johannesburg
        repository.create(job3); // Cape Town
        repository.create(job4); // Durban

        List<Job> capeTownJobs = repository.findJobsByLocation("Cape Town");
        List<Job> johannesburgJobs = repository.findJobsByLocation("Johannesburg");
        List<Job> nonExistentLocation = repository.findJobsByLocation("Port Elizabeth");

        assertNotNull(capeTownJobs);
        assertEquals(2, capeTownJobs.size());
        assertTrue(capeTownJobs.contains(job1));
        assertTrue(capeTownJobs.contains(job3));

        assertNotNull(johannesburgJobs);
        assertEquals(1, johannesburgJobs.size());
        assertTrue(johannesburgJobs.contains(job2));

        assertNotNull(nonExistentLocation);
        assertEquals(0, nonExistentLocation.size());
    }

    @Test
    void findJobsByEmploymentType() {
        repository.create(job1); // Permanent
        repository.create(job2); // Permanent
        repository.create(job3); // Contract
        repository.create(job4); // Permanent

        List<Job> permanentJobs = repository.findJobsByEmploymentType("Permanent");
        List<Job> contractJobs = repository.findJobsByEmploymentType("Contract");
        List<Job> nonExistentType = repository.findJobsByEmploymentType("Internship");

        assertNotNull(permanentJobs);
        assertEquals(3, permanentJobs.size());
        assertTrue(permanentJobs.contains(job1));
        assertTrue(permanentJobs.contains(job2));
        assertTrue(permanentJobs.contains(job4));

        assertNotNull(contractJobs);
        assertEquals(1, contractJobs.size());
        assertTrue(contractJobs.contains(job3));

        assertNotNull(nonExistentType);
        assertEquals(0, nonExistentType.size());
    }

    @Test
    void findJobsByRemoteOption() {
        repository.create(job1); // remoteOption = false
        repository.create(job2); // remoteOption = true
        repository.create(job3); // remoteOption = false
        repository.create(job4); // remoteOption = true

        List<Job> remoteJobs = repository.findJobsByRemoteOption(true);
        List<Job> onSiteJobs = repository.findJobsByRemoteOption(false);

        assertNotNull(remoteJobs);
        assertEquals(2, remoteJobs.size());
        assertTrue(remoteJobs.contains(job2));
        assertTrue(remoteJobs.contains(job4));

        assertNotNull(onSiteJobs);
        assertEquals(2, onSiteJobs.size());
        assertTrue(onSiteJobs.contains(job1));
        assertTrue(onSiteJobs.contains(job3));
    }
}