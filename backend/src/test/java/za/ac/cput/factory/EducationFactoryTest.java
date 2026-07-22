package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Education;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EducationFactoryTest {

    @Test
    void createEducation() {
        Education education = EducationFactory.createEducation(
                "ED001",  // educationId
                "CPUT",   // institution
                "ICT: Application Development",  // degree
                "Computer Science",  // fieldOfStudy
                LocalDate.of(2024, 1, 25),  // startDate
                LocalDate.of(2026, 1, 25),  // endDate
                "ICT: Application Development - Computer Science"  // description
        );

        assertNotNull(education);
        System.out.println(education);
    }

    @Test
    void createEducationFails() {
        Education education = EducationFactory.createEducation(
                "",  // Empty educationId should cause failure
                "CPUT",
                "ICT: Application Development",
                "Computer Science",
                LocalDate.of(2024, 1, 25),
                LocalDate.of(2026, 1, 25),
                "ICT: Application Development - Computer Science"
        );

        assertNull(education);
        System.out.println("Failed as expected - empty educationId");
    }

    @Test
    void createEducationFailsMissingInstitution() {
        Education education = EducationFactory.createEducation(
                "ED002",
                "",  // Empty institution should cause failure
                "ICT: Application Development",
                "Computer Science",
                LocalDate.of(2024, 1, 25),
                LocalDate.of(2026, 1, 25),
                "ICT: Application Development - Computer Science"
        );

        assertNull(education);
        System.out.println("Failed as expected - empty institution");
    }
}