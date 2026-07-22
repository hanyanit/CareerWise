package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Employer;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEmployerRepository extends JpaRepository<Employer, String> { // Fix: String not Integer (userId is String)

    Optional<Employer> findByUserId(String userId);
    Optional<Employer> findByCompanyName(String companyName);
    List<Employer> findByIndustry(String industry);
    boolean existsByEmail(String email);
}