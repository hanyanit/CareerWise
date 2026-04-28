//package za.ac.cput.repository;
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
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
//@TestMethodOrder(MethodOrderer.MethodName.class)
//class EmployerRepositoryTest {
//    private static EmployerRepository repository = EmployerRepository.getRepository();
//    private static Employer employer = EmployerFactory.buildEmployer("Capitec", "Banking", "Large", "Stellenbosch");
//
//    @Test
//    void a_create() {
//        Employer created = repository.create(employer);
//        assertNotNull(created);
//        System.out.println("Create: " + created);
//    }
//
//    @Test
//    void b_read() {
//        Employer read = repository.read(employer.getCompanyName());
//        assertNotNull(read);
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    void c_update() {
//        Employer updated = new Employer.Builder().copy(employer)
//                .setCompanySize("Large")
//                .build();
//        assertNotNull(repository.update(updated));
//        System.out.println("Update: " + updated);
//    }
//
//    @Test
//    void d_delete() {
//        boolean success = repository.delete(employer.getCompanyName());
//        assertTrue(success);
//        System.out.println("Delete: " + success);
//    }
//
//    @Test
//    void e_getAll() {
//        System.out.println("Show all: " + repository.getAll());
//    }
//}