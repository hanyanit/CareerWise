package za.ac.cput.repository;

import za.ac.cput.domain.Job;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Phumlani Mdlalo, 241093813
 * Date: March 2026
 */

public class JobRepository implements IJobRepository {

    private static IJobRepository repository = null;
    private List<Job> jobList;

    private JobRepository() {
        jobList = new ArrayList<>();
    }

    public static IJobRepository getRepository() {
        if (repository == null) {
            repository = new JobRepository();
        }
        return repository;
    }

    @Override
    public Job create(Job job) {
        boolean success = jobList.add(job);
        if (success) return job;
        return null;
    }

    @Override
    public Job read(String jobId) {
        for (Job job : jobList) {
            if (job.getJobId().equals(jobId)) {
                return job;
            }
        }
        return null;
    }

    @Override
    public Job update(Job job) {
        String id = job.getJobId();
        Job oldJob = read(id);
        if (oldJob == null) return null;

        boolean success = jobList.remove(oldJob);
        if (!success) return null;

        if (jobList.add(job)) return job;
        return null;
    }

    @Override
    public boolean delete(String jobId) {
        Job toDelete = read(jobId);
        if (toDelete == null) return false;
        return jobList.remove(toDelete);
    }

    @Override
    public List<Job> getAll() {
        return new ArrayList<>(jobList);
    }

    @Override
    public List<Job> findOpenPositions() {
        List<Job> openPositions = new ArrayList<>();
        for (Job job : jobList) {
            if ("OPEN".equalsIgnoreCase(job.getStatus())) {
                openPositions.add(job);
            }
        }
        return openPositions;
    }

    @Override
    public List<Job> findJobsByLocation(String location) {
        List<Job> result = new ArrayList<>();
        for (Job job : jobList) {
            if (job.getLocation() != null && job.getLocation().equalsIgnoreCase(location)) {
                result.add(job);
            }
        }
        return result;
    }

    @Override
    public List<Job> findJobsByEmploymentType(String employmentType) {
        List<Job> result = new ArrayList<>();
        for (Job job : jobList) {
            if (job.getEmploymentType() != null && job.getEmploymentType().equalsIgnoreCase(employmentType)) {
                result.add(job);
            }
        }
        return result;
    }

    @Override
    public List<Job> findJobsByRemoteOption(Boolean remoteOption) {
        List<Job> result = new ArrayList<>();
        if (remoteOption == null) return result;
        for (Job job : jobList) {
            if (remoteOption.equals(job.getRemoteOption())) {
                result.add(job);
            }
        }
        return result;
    }
}