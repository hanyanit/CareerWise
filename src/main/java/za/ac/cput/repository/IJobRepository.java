package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Job;

import java.util.List;

@Repository
public interface IJobRepository extends JpaRepository<Job, Integer> {

    Job findByJobId(String jobId);

    List<Job> findByStatusIgnoreCase(String status);

    List<Job> findByLocationIgnoreCase(String location);

    List<Job> findByEmploymentTypeIgnoreCase(String employmentType);

    List<Job> findByRemoteOption(Boolean remoteOption);
}