package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.JobSeeker;

import java.util.Optional;

@Repository
public interface IJobSeekerRepository extends JpaRepository<JobSeeker, String> {
    Optional<JobSeeker> findByUserId(String userId);
    Optional<JobSeeker> findByEmail(String email);
    boolean existsByEmail(String email);
}