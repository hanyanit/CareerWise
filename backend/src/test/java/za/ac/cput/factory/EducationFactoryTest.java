package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Education;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class EducationFactoryTest {
    private static Education ed1,ed2;

    @BeforeEach
    void createEducation() {
        ed1 = EducationFactory.createEducation("ed01","CPUT","ICT: Application Development",
                "Computer Science", LocalDate.of(2024, 1, 25), LocalDate.of(2026, 1, 25) ,
                "ICT: Application Development - Computer Science");

        ed2 = EducationFactory.createEducation("ed02","CPUT","ICT: Multimedia",
                "Multimedia", LocalDate.of(2022, 1, 25), LocalDate.of(2024, 1, 25) ,
                "ICT: Multimedia - Multimedia");
    }

    @Test
    void a_testEducation(){
        assertNotNull(ed1);
        System.out.println(ed1.toString());
    }

    @Test
    void b_testEducation(){
        assertNotNull(ed2);
        System.out.println(ed2.toString());
    }
}