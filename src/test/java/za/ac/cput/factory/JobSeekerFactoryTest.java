package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.JobSeeker;
import za.ac.cput.domain.Skill;
import za.ac.cput.domain.Education;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        System.out.println(jobSeeker.toString());
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
        System.out.println(jobSeeker.toString());
    }

    @Test
    void createFullJobSeeker() {

        List<Skill> skills = new ArrayList<>();
        List<Education> education = new ArrayList<>();

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
                "resume.pdf",
                skills,
                education
        );

        assertNotNull(jobSeeker);
        System.out.println(jobSeeker.toString());
    }
}