package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.JobSeeker;
import static org.junit.jupiter.api.Assertions.*; // 👈 This handles ALL assertions safely

class JobSeekerFactoryTest {

    @Test
    void createJobSeeker() {
        JobSeeker jobSeeker = JobSeekerFactory.createJobSeeker(
                "U001",
                "test@mycput.ac.za",
                "password123",
                "Inga",
                "Mbobo",
                "Java Developer",
                "Backend enthusiast"
        );

        assertNotNull(jobSeeker);
        assertEquals("U001", jobSeeker.getUserId());
        System.out.println(jobSeeker);
    }

    @Test
    void testCreateJobSeeker() {
        JobSeeker jobSeeker = JobSeekerFactory.createJobSeeker(
                "test@mycput.ac.za",
                "password123",
                "Themba",
                "Thembelani",
                "Frontend Dev",
                "Loves UI"
        );

        assertNotNull(jobSeeker);
        assertNotNull(jobSeeker.getUserId());
        System.out.println(jobSeeker);
    }

    @Test
    void createFullJobSeeker() {
        JobSeeker jobSeeker = JobSeekerFactory.createFullJobSeeker(
                "U002",
                "full@mail.com",
                "password123",
                "Full",
                "User",
                "profile.jpg",
                "0123456789",
                "Cape Town",
                "Full Stack Dev",
                "Experienced developer",
                "resume.pdf"
        );

        assertNotNull(jobSeeker);
        assertEquals("resume.pdf", jobSeeker.getResumePath());
        System.out.println(jobSeeker);
    }
}
