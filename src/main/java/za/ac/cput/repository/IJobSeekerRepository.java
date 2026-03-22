package za.ac.cput.repository;

import za.ac.cput.domain.JobSeeker;

import java.util.List;

public interface IJobSeekerRepository extends IRepository<JobSeeker, String>{
    List<JobSeeker> getAll();
}
