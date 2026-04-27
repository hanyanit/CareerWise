package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Service.IEducationService;
import za.ac.cput.Service.IJobService;
import za.ac.cput.domain.Job;

import java.util.List;

@RestController
@RequestMapping("/Job")
public class JobController {

    private IJobService jobServiceRepo;

    @Autowired
    public JobController(IJobService jobServiceRepo) {
        this.jobServiceRepo = jobServiceRepo;
    }

    @PostMapping("/create")
    public Job create(@RequestBody Job job) {
        return this.jobServiceRepo.create(job);
    }

    @GetMapping("/read")
    public Job read(@RequestParam String id) {
        return this.jobServiceRepo.read(id);
    }

    @PutMapping("/update")
    public Job update(@RequestBody Job job) {
        return this.jobServiceRepo.update(job);
    }

    @DeleteMapping("/delete/{jobId}")
    public boolean delete(@PathVariable("jobId") String id) {
        return this.jobServiceRepo.delete(id);
    }

    @GetMapping("/getAll")
    public List<Job> getAll() {
        return this.jobServiceRepo.getAll();
    }

    @GetMapping("/findOpenPositions")
    public List<Job> findOpenPositions() {
        return this.jobServiceRepo.findOpenPositions();
    }

    @GetMapping("/findJobsByLocation")
    public List<Job> findJobsByLocation(@RequestParam String location) {
        return this.jobServiceRepo.findJobsByLocation(location);
    }

    @GetMapping("/findJobsByEmploymentType")
    public List<Job> findJobsByEmploymentType(@RequestParam String employmentType) {
        return this.jobServiceRepo.findJobsByEmploymentType(employmentType);
    }

    @GetMapping("/findJobsByRemoteOption")
    public List<Job> findJobsByRemoteOption(@RequestParam Boolean remoteOption) {
        return this.jobServiceRepo.findJobsByRemoteOption(remoteOption);
    }
}