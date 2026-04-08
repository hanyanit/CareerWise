package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.JobSeeker;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class JobSeekerFactoryTest {

    @Test
    void createJobSeeker_ValidData_ShouldPass() {
        JobSeeker js = JobSeekerFactory.createJobSeeker(
                "2307111313@mycput.ac.za", "1234@mycput",
                "Ing", "Mbobo", "Java Software Developer",
                "I am a CPUT Applications Development Student"
        );

        assertNotNull(js);
        System.out.println("PASSED: JobSeeker created successfully");
        System.out.println(js.toString());
    }

    @Test
    void createJobSeeker_InvalidEmail_ShouldFail() {
        JobSeeker js = JobSeekerFactory.createJobSeeker(
                "230711mycput.ac.za", "1234@mycput",
                "Inganathi", "Mbobo", "Java Software Developer",
                "I am a CPUT Applications Development Student"
        );

        assertNull(js);
        System.out.println("FAILED: Invalid email correctly returned null");
        System.out.println("JobSeeker is: " + js);
    }
}