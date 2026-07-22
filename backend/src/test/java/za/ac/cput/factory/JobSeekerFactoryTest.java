package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.JobSeeker;

import static org.junit.jupiter.api.Assertions.*;

class JobSeekerFactoryTest {

    @Test
    void createJobSeeker() {
        JobSeeker jobSeeker = JobSeekerFactory.createJobSeeker(
                "test@mycput.ac.za",
                "password123",
                "Inga",
                "Mbobo",
                "profile.jpg",
                "0123456789",
                "Cape Town",
                "Java Developer",
                "Backend enthusiast",
                "resume.pdf"
        );

        assertNotNull(jobSeeker);
        System.out.println(jobSeeker);
    }

    @Test
    void createJobSeekerInvalidEmail() {
        JobSeeker jobSeeker = JobSeekerFactory.createJobSeeker(
                "invalidEmail",
                "password123",
                "Inga",
                "Mbobo",
                null,
                null,
                null,
                "Developer",
                "Summary",
                null
        );

        assertNull(jobSeeker); //is null? yes so pass the test
        System.out.println("Failed as expected");
    }

}