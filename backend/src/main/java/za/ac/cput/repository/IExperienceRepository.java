package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Experience;

import java.util.List;

@Repository
public interface IExperienceRepository extends JpaRepository<Experience, String> {
    List<Experience> findByCompanyContainingIgnoreCase(String company);
}