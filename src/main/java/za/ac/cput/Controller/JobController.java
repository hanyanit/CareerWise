package za.ac.cput.Controller;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.Service.IJobService;
import za.ac.cput.domain.Job;

import java.util.List;

@RestController
@RequestMapping("/Job")
public class JobController {

    private IJobService jobServiceRepo;

    @PostMapping("/create")
    public Job create(@RequestBody Job job){
        return this.jobServiceRepo.create(job);
    }

    @GetMapping("/read")
    public Job read(String id){
        return this.jobServiceRepo.read(id);
    }

    @PutMapping("/update")
    public Job update(Job job){
        return this.jobServiceRepo.update(job);
    }

    @DeleteMapping("/delete{jobId}")
    public boolean delete(String id){
        return this.jobServiceRepo.delete(id);
    }

    @GetMapping("/getAll")
    public List<Job> getAll(){
        return this.jobServiceRepo.getAll();
    }

    @GetMapping("/findOpenPositions")
    public List<Job> findOpenPositions(){
        return this.jobServiceRepo.findOpenPositions();
    }

    @GetMapping("/findJobsByLocation")
    public List<Job> findJobsByLocation(String location){
        return this.jobServiceRepo.findJobsByLocation(location);
    }

    @GetMapping("/findJobsByEmploymentType")
    public List<Job> findJobsByEmploymentType(String employmentType){
        return this.jobServiceRepo.findJobsByEmploymentType(employmentType);
    }

    @GetMapping("/findJobsByRemoteOption")
    public List<Job> findJobsByRemoteOption(Boolean remoteOption) {
        return this.jobServiceRepo.findJobsByRemoteOption(remoteOption);
    }
}
