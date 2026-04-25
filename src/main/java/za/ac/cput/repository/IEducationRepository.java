package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Education;
import java.util.List;

/**
 * Author: Phumlani Mdlalo, 241093813
 * Date: March 2026
 */
@Repository
public interface IEducationRepository extends JpaRepository<Education, String> {
//    List<Education> getAll();
//    List<Education> findByInstitution(String institution);
//    List<Education> findByDegree(String degree);
}