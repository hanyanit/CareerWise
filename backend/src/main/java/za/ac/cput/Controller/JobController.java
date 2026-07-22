package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Service.IJobService;
import za.ac.cput.domain.Job;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "*")
public class JobController {

    private final IJobService jobService;

    @Autowired
    public JobController(IJobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping("/create")
    public ResponseEntity<Job> create(@RequestBody Job job) {
        Job created = jobService.create(job);
        if (created != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Job> read(@PathVariable String id) {
        Job job = jobService.read(id);
        if (job != null) {
            return ResponseEntity.ok(job);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Job> update(@RequestBody Job job) {
        Job updated = jobService.update(job);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        boolean deleted = jobService.delete(id);
        if (deleted) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Job>> getAll() {
        return ResponseEntity.ok(jobService.getAll());
    }

    @GetMapping("/findOpenPositions")
    public ResponseEntity<List<Job>> findOpenPositions() {
        return ResponseEntity.ok(jobService.findOpenPositions());
    }

    @GetMapping("/findByLocation")
    public ResponseEntity<List<Job>> findJobsByLocation(@RequestParam String location) {
        return ResponseEntity.ok(jobService.findJobsByLocation(location));
    }

    @GetMapping("/findByEmploymentType")
    public ResponseEntity<List<Job>> findJobsByEmploymentType(@RequestParam String employmentType) {
        return ResponseEntity.ok(jobService.findJobsByEmploymentType(employmentType));
    }

    @GetMapping("/findByRemoteOption")
    public ResponseEntity<List<Job>> findJobsByRemoteOption(@RequestParam Boolean remoteOption) {
        return ResponseEntity.ok(jobService.findJobsByRemoteOption(remoteOption));
    }
}