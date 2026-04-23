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

    @PostMapping("/create")
    public JobSeeker create(@RequestBody JobSeeker jobSeeker) {
        return this.jobSeekerServiceRepo.create(jobSeeker);
    }

//    @GetMapping("/read/{userId}")
//    public JobSeeker read(PathVariable String id){
//        return this.jobSeekerServiceRepo.read(id);
//    }

    @PutMapping("/update")
    public JobSeeker update(@RequestBody JobSeeker jobSeeker){
        return this.jobSeekerServiceRepo.update(jobSeeker);
    }

//    @DeleteMapping("/delete/{userId}")
//    public boolean delete(@PathVariable String userId){
//        return this.jobSeekerServiceRepo.delete(id);
//    }

    @GetMapping("/getAll")
    public List<JobSeeker> getAll(){
        return this.jobSeekerServiceRepo.getAll();
    }


}
