package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Service.IJobSeekerService;
import za.ac.cput.domain.JobSeeker;

import java.util.List;

@RestController
@RequestMapping("/jobseeker")
public class JobSeekerController {

    private IJobSeekerService jobSeekerServiceRepo;

    @Autowired
    public JobSeekerController(IJobSeekerService jobSeekerServiceRepo) {
        this.jobSeekerServiceRepo = jobSeekerServiceRepo;
    }

    @PutMapping("/create")
    public JobSeeker createJobSeeker(@RequestBody JobSeeker jobSeeker) {
        return this.jobSeekerServiceRepo.create(jobSeeker);
    }

    @GetMapping("/read/{userId}")
    public JobSeeker readJobSeeker(@PathVariable String userId){
        return this.jobSeekerServiceRepo.read(userId);
    }

    @PostMapping("/update")
    public JobSeeker updateJobSeeker(@RequestBody JobSeeker jobSeeker){
        return this.jobSeekerServiceRepo.update(jobSeeker);
    }

    @DeleteMapping("/delete/{userId}")
    public boolean delete(@PathVariable String userId){
        return this.jobSeekerServiceRepo.delete(userId);
    }

    @GetMapping("/getAll")
    public List<JobSeeker> getAllJobSeekers(){
        return this.jobSeekerServiceRepo.getAll();
    }


}
