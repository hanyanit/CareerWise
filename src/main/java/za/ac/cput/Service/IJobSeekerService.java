package za.ac.cput.Service;

import za.ac.cput.domain.JobSeeker;

import java.util.List;

public interface IJobSeekerService extends IService<JobSeeker, String>{
    List<JobSeeker> getAll();
    List<JobSeeker> getByEmail(String email);

//    JobSeeker create(JobSeeker jobSeeker);
//    JobSeeker read(String id);
//    List<JobSeeker> getAll();
//    boolean delete(String id);

    //then add these methods above, since jpa uses them as contract
    //this is still optional in Spring Boot
    //Not required anymore technically

}
