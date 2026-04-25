package za.ac.cput.Service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import za.ac.cput.Service.IJobService;
import za.ac.cput.domain.Job;
import za.ac.cput.repository.IJobRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements IJobService {

    private final IJobRepository repository;
    private List<Job> jobList;

    public JobServiceImpl(@Qualifier("IJobRepository") IJobRepository repository) {
        this.repository = repository;
    }

    @Override
    public Job create(Job job) {
        return repository.save(job);
    }

    @Override
    public Job read(String id) { return repository.findById(id).orElse(null);
    }

    @Override
    public Job update(Job job) {
        return repository.save(job);
    }

    @Override
    public boolean delete(String id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<Job> getAll() {
        return repository.findAll();
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
