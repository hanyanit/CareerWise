package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Employer;
import static org.junit.jupiter.api.Assertions.*;

/**
 * EmployerFactoryTest.java
 * Author: Andile Pamela Masina, 221568816
 * Date: 24 March 2026
 */
class EmployerFactoryTest {

    @Test
    void buildEmployer_Success() {
        Employer employer = EmployerFactory.buildEmployer(
                "Capitec",
                "Accounting",
                "1000 - 5000",
                "Cape Town"
        );

        assertNotNull(employer);
        assertEquals("Capitec", employer.getCompanyName());
        System.out.println("Success Test: " + employer.toString());
    }

    @Test
    void buildEmployer_WithNull_ReturnsNull() {
        Employer employer = EmployerFactory.buildEmployer(
                "",
                "Retail",
                "1-10",
                "Durban"
        );

        assertNull(employer);
        System.out.println("Failure Test (Empty Name): Successfully returned null");
    }
}
