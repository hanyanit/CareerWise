package za.ac.cput.repository;

import za.ac.cput.domain.JobSeeker;

import java.util.ArrayList;
import java.util.List;

public class JobSeekerRepository implements IJobSeekerRepository{

    private static IJobSeekerRepository repository = null;
    private List<JobSeeker> jobSeekerList;

    private JobSeekerRepository(){
        jobSeekerList = new ArrayList<>();
    }

    private static IJobSeekerRepository getRepository(){
        if(repository == null){
            repository = new JobSeekerRepository();
        }
        return repository;
    }

    @Override
    public JobSeeker create(JobSeeker jobSeeker) {
        return null;
    }

    @Override
    public JobSeeker read(String s) {
        return null;
    }

    @Override
    public JobSeeker update(JobSeeker jobSeeker) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public List<JobSeeker> getAll() {
        return List.of();
    }
}
