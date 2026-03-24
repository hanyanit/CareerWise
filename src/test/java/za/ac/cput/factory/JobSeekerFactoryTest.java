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
                "I am a CPUT Applications Development Student With a Higher Certificate In IT, Currently " +
                        "pursuing diploma, Holding AWS certificate on Cloud computing and Have majored in Python for a year");

        assertNotNull(js);
        System.out.println(js.toString());
    }

    @Test
    void testJobSeekerWrongEmail() {
        JobSeeker js = JobSeekerFactory.createJobSeeker("230711723mycput.ac.za", "1234@mycput", "Ingas", "Mbobo"
                ,"Java Software Developer","I am a CPUT Applications Development Student With a Higher Certificate In IT, Currently \" +\n" +
                " \"pursuing final year diploma, Holding AWS certificate on Cloud computing and Have majored in Python for a year");

        assertNotNull(js);
        System.out.println(js);
    }
}