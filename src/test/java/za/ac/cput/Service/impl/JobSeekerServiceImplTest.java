package za.ac.cput.Service.impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.JobSeeker;
import za.ac.cput.factory.JobSeekerFactory;
import za.ac.cput.repository.IJobSeekerRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional
class JobSeekerServiceImplTest {

    @Autowired
    private JobSeekerServiceImpl jobSeekerService;

    @Autowired
    private IJobSeekerRepository jobSeekerRepository;

    private static JobSeeker testJobSeeker;
    private static String testUserId;

    @BeforeEach
    void setUp() {
        jobSeekerRepository.deleteAll();
    }

    @Test
    @Order(1)
    void create() {
        testJobSeeker = JobSeekerFactory.createFullJobSeeker(
                "U12345",
                "inga.dev@gmail.com",
                "securePassword123",
                "NameExample",
                "SurnameExample",
                "profile_picture.png",
                "0712345678",
                "Cape Town",
                "Java Software Engineer",
                "Passionate backend developer with 5 years of experience",
                "resume.pdf"
        );

        assertNotNull(testJobSeeker);

        JobSeeker created = jobSeekerService.create(testJobSeeker);
        assertNotNull(created);
        assertNotNull(created.getUserId());

        testJobSeeker = created;
        testUserId = created.getUserId();

        System.out.println("Created JobSeeker: " + created.getFirstName() + " " + created.getLastName());
        System.out.println("   ID: " + created.getUserId());
    }

    @Test
    @Order(2)
    void read() {
        JobSeeker jobSeeker = createTestJobSeeker();
        JobSeeker saved = jobSeekerService.create(jobSeeker);
        assertNotNull(saved);

        JobSeeker found = jobSeekerService.read(saved.getUserId());
        assertNotNull(found);
        assertNotNull(found.getUserId());

        System.out.println("Read JobSeeker: " + found.getFirstName() + " " + found.getLastName());
    }


    @Test
    @Order(3)
    void update() {
        JobSeeker jobSeeker = createTestJobSeeker();
        JobSeeker saved = jobSeekerService.create(jobSeeker);
        assertNotNull(saved);

        JobSeeker updatedJobSeeker = new JobSeeker.JobSeekerBuilder(
                saved.getUserId(),
                saved.getEmail(),
                saved.getPassword()
        )
                .firstName("Name Updated")
                .lastName("Surname Updated")
                .profilePicture("updated_profile.png")
                .phoneNumber("0823456789")
                .location("Johannesburg")
                .headline("Senior Java Software Engineer")
                .summary("Updated: Senior backend developer with 7 years of experience")
                .resumePath("name_resume_updated.pdf")
                .build();

        JobSeeker updated = jobSeekerService.update(updatedJobSeeker);
        assertNotNull(updated);
        assertNotNull(updated.getUserId());

        System.out.println("Updated JobSeeker: " + updated.getFirstName() + " " + updated.getLastName());
    }

    @Test
    @Order(4)
    void delete() {
        JobSeeker jobSeeker = createTestJobSeeker();
        JobSeeker saved = jobSeekerService.create(jobSeeker);
        assertNotNull(saved);

        String userId = saved.getUserId();
        boolean deleted = jobSeekerService.delete(userId);
        assertTrue(deleted);

        JobSeeker found = jobSeekerService.read(userId);
        assertNull(found);

        System.out.println("Deleted JobSeeker with ID: " + userId);
    }

    @Test
    @Order(5)
    void getAll() {
        JobSeeker jobSeeker1 = createTestJobSeeker();

        jobSeekerService.create(jobSeeker1);

        List<JobSeeker> jobSeekers = jobSeekerService.getAll();
        assertNotNull(jobSeekers);
        assertTrue(jobSeekers.size() >= 2);

        System.out.println("Found " + jobSeekers.size() + " JobSeekers");
    }

    @Test
    @Order(6)
    void getByEmail() {
        String testEmail = "getbyemail.test@gmail.com";
        JobSeeker jobSeeker = new JobSeeker.JobSeekerBuilder(
                "U99999",
                testEmail,
                "password123"
        )
                .firstName("Email")
                .lastName("Test")
                .headline("Test Headline")
                .summary("Test Summary")
                .build();

        jobSeekerService.create(jobSeeker);

        List<JobSeeker> found = jobSeekerService.getByEmail(testEmail);
        assertNotNull(found);
        assertTrue(found.size() > 0);

        System.out.println("Found " + found.size() + " JobSeeker(s) with email: " + testEmail);
    }

    @Test
    @Order(7)
    void getByEmailNotFound() {
        List<JobSeeker> found = jobSeekerService.getByEmail("nonexistent@email.com");
        assertNotNull(found);
        assertTrue(found.isEmpty());
        System.out.println("Successfully handled non-existent email search");
    }

    @Test
    @Order(8)
    void createJobSeekerWithAutoGeneratedId() {
        JobSeeker jobSeeker = JobSeekerFactory.createJobSeeker(
                "auto.test@gmail.com",
                "password123",
                "Auto",
                "Generated",
                "Auto Generated Headline",
                "This is a test with auto-generated ID"
        );

        assertNotNull(jobSeeker);
        assertNotNull(jobSeeker.getUserId());

        JobSeeker created = jobSeekerService.create(jobSeeker);
        assertNotNull(created);
        assertNotNull(created.getUserId());

        System.out.println("Created JobSeeker with auto-generated ID: " + created.getUserId());
    }

    private JobSeeker createTestJobSeeker() {
        return JobSeekerFactory.createFullJobSeeker(
                "U" + System.currentTimeMillis(),
                "test" + System.currentTimeMillis() + "@gmail.com",
                "securePassword123",
                "Test",
                "User",
                "profile_picture.png",
                "0712345678",
                "Cape Town",
                "Software Engineer",
                "Test summary for job seeker",
                "test_resume.pdf"
        );
    }
}