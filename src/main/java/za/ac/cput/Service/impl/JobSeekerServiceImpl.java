package za.ac.cput.Service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.Service.IJobSeekerService;
import za.ac.cput.domain.JobSeeker;
//import za.ac.cput.repository.IJobSeekerRepository;
import za.ac.cput.repository.JobSeekerRepository;
//import za.ac.cput.repository.impl.JobSeekerRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobSeekerServiceImpl implements IJobSeekerService {

    // Singleton instance
//    private static JobSeekerService service = null;

    // Repository (singleton from your implementation)
//    private final IJobSeekerRepository repository;

        private final JobSeekerRepository repository;

    public JobSeekerServiceImpl(JobSeekerRepository repository) {
        this.repository = repository;
    }
    // Private constructor
//    private JobSeekerServiceImpl() {
//        this.repository = JobSeekerRepositoryImpl.getRepository();
//    }

    // Singleton getter
//    public static JobSeekerService getService() {
//        if (service == null) {
//            service = new JobSeekerServiceImpl();
//        }
//        return service;
//    }

    @Override
    public JobSeeker create(JobSeeker jobSeeker) {
        return repository.save(jobSeeker); //not create
    }

    @Override
    public JobSeeker read(String id) {
        return repository.findById(id).orElse(null);
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