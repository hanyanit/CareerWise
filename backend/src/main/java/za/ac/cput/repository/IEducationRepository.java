package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Education;

import java.util.List;

@Repository
public interface IEducationRepository extends JpaRepository<Education, String> {
    List<Education> findByInstitutionContainingIgnoreCase(String institution);
    List<Education> findByDegreeContainingIgnoreCase(String degree);
}