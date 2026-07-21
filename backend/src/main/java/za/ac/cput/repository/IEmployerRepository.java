package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Employer;
import java.util.List;

/**
 * IEmployerRepository.java
 * Author: Andile Pamela Masina, 221568816
 * Date: 24 March 2026
 */

@Repository
public interface IEmployerRepository extends JpaRepository<Employer, Integer> {

}