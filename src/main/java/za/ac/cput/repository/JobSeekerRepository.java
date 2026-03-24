package za.ac.cput.repository;

import za.ac.cput.domain.JobSeeker;

import java.util.ArrayList;
import java.util.List;
/**
 * Author: Inga Mbobo, 230711723
 * Date: March 2026
 */
public class JobSeekerRepository implements IJobSeekerRepository {

    private static IJobSeekerRepository repository = null;
    private List<JobSeeker> jobSeekerList;

    private JobSeekerRepository() {
        jobSeekerList = new ArrayList<>();
    }

    public static IJobSeekerRepository getRepository() {
        if (repository == null) {
            repository = new JobSeekerRepository();
        }
        return repository;
    }

    @Override
    public JobSeeker create(JobSeeker jobSeeker) {
        boolean success = jobSeekerList.add(jobSeeker);
        if (success) {
            return jobSeeker;
        }
        return null;
    }

    @Override
    public JobSeeker read(String userId) { // I will code this method using lambda expression
        return jobSeekerList.stream()
                .filter(jobSeeker -> jobSeeker.getUserId().equals(userId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public JobSeeker update(JobSeeker jobSeeker) {
        String id = jobSeeker.getUserId();
        JobSeeker oldJobSeeker = read(id);

        if (oldJobSeeker == null) {
            return null;
        }

        boolean success = jobSeekerList.remove(oldJobSeeker);
        if (!success) {
            return null;
        }

        if (jobSeekerList.add(jobSeeker)) {
            return jobSeeker;
        }

        return null;
    }

    @Override
    public boolean delete(String userId) {
        JobSeeker jobSeekerToDelete = read(userId);
        if (jobSeekerToDelete == null) {
            return false;
        }
        return jobSeekerList.remove(jobSeekerToDelete);
    }

    @Override
    public List<JobSeeker> getAll() {
        return jobSeekerList;
    }
}