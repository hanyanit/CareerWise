package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.JobSeeker;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class JobSeekerFactoryTest {

    @Test
    void createJobSeeker() {
        File myResume = new File("resume.pdf");


        JobSeeker js = JobSeekerFactory.createJobSeeker("230711723@mycput.ac.za","1234@mycput",
                "Inganathi", "Mbobo","Java Software Developer",
                "I am a CPUT Applications Development Strudent With a Higher Certificate In IT, Currently " +
                        "persuing diploma, Holding AWS certificate on Cloud computing and Have majored in Python for a year");

        assertNotNull(js);

        assertEquals("Java Software Developer", js.getHeadline());

        System.out.println(js.toString());
    }

    @Test
    void testJobSeekerFail() {
        // If your factory has validation (like email check), test it here
//        JobSeeker js = JobSeekerFactory.createJobSeeker("", "", "", "", "");
//        assertNull(js, "Factory should return null for empty mandatory User fields");
    }
}