package za.ac.cput.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Service.IJobSeekerService;
import za.ac.cput.domain.JobSeeker;
import za.ac.cput.repository.IJobSeekerRepository;

import java.util.List;

@Service
public class JobSeekerServiceImpl implements IJobSeekerService {

    private final IJobSeekerRepository repository;

    @Autowired
    public JobSeekerServiceImpl(IJobSeekerRepository repository) {
        this.repository = repository;
    }

    @Override
    public JobSeeker create(JobSeeker jobSeeker) {
        if (jobSeeker.getEmail() != null &&
                !repository.existsByEmail(jobSeeker.getEmail())) {
            return repository.save(jobSeeker);
        }
        return null;
    }

    @Override
    public JobSeeker read(String id) {
        return repository.findByUserId(id).orElse(null);
    }

    @Override
    public JobSeeker update(JobSeeker jobSeeker) {
        if (jobSeeker.getUserId() != null &&
                repository.existsById(jobSeeker.getUserId())) {
            return repository.save(jobSeeker);
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<JobSeeker> getAll() {
        return repository.findAll();
    }

    @Override
    public List<JobSeeker> getByEmail(String email) {
        return repository.findByEmail(email)
                .map(List::of)
                .orElse(List.of());
    }
}