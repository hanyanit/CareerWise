package za.ac.cput.Service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import za.ac.cput.Service.IJobService;
import za.ac.cput.domain.Job;
import za.ac.cput.repository.IJobRepository;

import java.util.List;

@Service
public class JobServiceImpl implements IJobService {

    private final IJobRepository repository;

    public JobServiceImpl(@Qualifier("IJobRepository") IJobRepository repository) {
        this.repository = repository;
    }

    @Override
    public Job create(Job job) {
        return repository.save(job);
    }

    @Override
    public Job read(String jobId) {
        return repository.findByJobId(jobId);
    }

    @Override
    public Job update(Job job) {
        return repository.save(job);
    }

    @Override
    public boolean delete(String jobId) {
        Job job = repository.findByJobId(jobId);

        if (job == null) {
            return false;
        }

        repository.delete(job);

        return true;
    }

    @Override
    public List<Job> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Job> findOpenPositions() {
        return repository.findByStatusIgnoreCase("OPEN");
    }

    @Override
    public List<Job> findJobsByLocation(String location) {
        return repository.findByLocationIgnoreCase(location);
    }

    @Override
    public List<Job> findJobsByEmploymentType(String employmentType) {
        return repository.findByEmploymentTypeIgnoreCase(employmentType);
    }

    @Override
    public List<Job> findJobsByRemoteOption(Boolean remoteOption) {
        return repository.findByRemoteOption(remoteOption);
    }
}