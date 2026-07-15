package za.ac.cput.Service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.Service.IJobSeekerService;
import za.ac.cput.domain.JobSeeker;
import za.ac.cput.repository.IJobSeekerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobSeekerServiceImpl implements IJobSeekerService {

        private final IJobSeekerRepository repository;

    public JobSeekerServiceImpl(IJobSeekerRepository repository) {
        this.repository = repository;
    }

    @Override
    public JobSeeker create(JobSeeker jobSeeker) {
        return repository.save(jobSeeker); //not create
    }

    @Override
    public JobSeeker read(String id) {
        return repository.findByUserId(id);
    }

    @Override
    public JobSeeker update(JobSeeker jobSeeker) {
        return repository.save(jobSeeker);// no more update
    }

    @Override
    public boolean delete(String id) {
         repository.deleteById(id);
        return true;
    }

    @Override
    public List<JobSeeker> getAll() {
        return repository.findAll();
    }

    @Override
    public List<JobSeeker> getByEmail(String email) {
        List<JobSeeker> result = new ArrayList<>();

        for (JobSeeker jobSeeker : repository.findAll()) {
            if (jobSeeker.getEmail() != null &&
                    jobSeeker.getEmail().equalsIgnoreCase(email)) {
                result.add(jobSeeker);
            }
        }

        return result;
    }
}