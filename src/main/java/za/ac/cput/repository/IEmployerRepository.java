package za.ac.cput.repository;

import za.ac.cput.domain.Employer;
import java.util.List;

/**
 * IEmployerRepository.java
 * Author: Andile Pamela Masina, 221568816
 * Date: 24 March 2026
 */

public interface IEmployerRepository extends IRepository<Employer, String> {
    List<Employer> getAll();
}