//package za.ac.cput.repository;
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import za.ac.cput.domain.Employer;
//import za.ac.cput.factory.EmployerFactory;
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * EmployerRepositoryTest.java
// * Author: Andile Pamela Masina, 221568816
// * Date: 27 March 2026
// */
//
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.MethodName.class)
//class EmployerRepositoryTest {
//    @Autowired
//    private IEmployerRepository repository;
//    private static Employer employer = EmployerFactory.createEmployer("Capitec", "Banking", "Large", "Stellenbosch");
//
//    @Test
//    void a_create() {
//        Employer created = repository.save(employer);
//        assertNotNull(created);
//        System.out.println("Create: " + created);
//    }
//
//    @Test
//    void b_read() {
//        Employer read = repository.findById(employer.getId());
//        assertNotNull(read);
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    void c_update() {
//        Employer updated = new Employer.Builder().copy(employer)
//                .setCompanySize("Large")
//                .build();
//        assertNotNull(repository.save(updated));
//        System.out.println("Update: " + updated);
//    }
//
//    @Test
//    void d_delete() {
//        boolean success = repository.deleteById(employer.getId());
//        assertTrue(success);
//        System.out.println("Delete: " + success);
//    }
//
//    @Test
//    void e_getAll() {
//        System.out.println("Show all: " + repository.getAll());
//    }
//}