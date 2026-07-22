package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Employer;

import static org.junit.jupiter.api.Assertions.*;

class EmployerFactoryTest {

    @Test
    void createEmployer_Success() {
        Employer employer = EmployerFactory.createEmployer(
                "capitec@email.com",
                "password123",
                "Avatar",
                "Ang",
                "Capitec",
                "Banking"
        );

        assertNotNull(employer);
        System.out.println(employer);
    }

    @Test
    void createEmployer_Fail_EmptyCompanyName() {
        Employer employer = EmployerFactory.createEmployer(
                "test@email.com",
                "password123",
                "John",
                "Ang",
                "",
                "Retail"
        );

        assertNull(employer);
        System.out.println("Failed as expected");
    }
}