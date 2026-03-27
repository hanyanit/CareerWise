package za.ac.cput.repository;

import za.ac.cput.domain.Job;
import java.util.List;

/**
 * Author: Phumlani Mdlalo, 241093813
 * Date: March 2026
 */

public interface IJobRepository extends IRepository<Job, String> {
    List<Job> getAll();
    List<Job> findOpenPositions();
    List<Job> findJobsByLocation(String location);
    List<Job> findJobsByEmploymentType(String employmentType);
    List<Job> findJobsByRemoteOption(Boolean remoteOption);
}