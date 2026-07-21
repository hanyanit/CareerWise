package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Job;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JobFactoryTest {
    private static Job job1,job2;

    @BeforeEach
    void createJob() {
      job1 = JobFactory.createJob("001","Software Developer","Build clean code using Java and Springboot",
              List.of("2 years experience", "Spring Framework", "RESTful APIs: @RestController, HTTP methods, status codes"),
              List.of("Participate in code refactoring sessions", "Update dependencies and security patches", "Review and update documentation"),
              "Cape Town",false,"50 000 - 70 000","Permanent",
              LocalDate.of(2026, 11, 25),"OPEN");

        job2 = JobFactory.createJob("002","Software Developer","Build clean code using Python",
                List.of("3 years experience", "Flask (Micro-framework)", "Django (Full-stack framework)"),
                List.of(" Participate in code refactoring sessions", "Update dependencies and security patches", "Performance testing and optimization"),
                "Cape Town",false,"70 000 - 75 000","Permanent",
                LocalDate.of(2026, 11, 25),"OPEN");
    }

    @Test
    void a_testJob(){
        assertNotNull(job1);
        System.out.println(job1.toString());
    }

    @Test
    void b_testJob(){
        assertNotNull(job2);
        System.out.println(job2.toString());
    }
}