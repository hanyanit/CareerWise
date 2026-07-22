package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Service.IJobSeekerService;
import za.ac.cput.domain.JobSeeker;

import java.util.List;

@RestController
@RequestMapping("/api/jobseekers")
@CrossOrigin(origins = "*")
public class JobSeekerController {

    private final IJobSeekerService service;

    @Autowired
    public JobSeekerController(IJobSeekerService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<JobSeeker> create(@RequestBody JobSeeker jobSeeker) {
        JobSeeker created = service.create(jobSeeker);
        if (created != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/read/{userId}")
    public ResponseEntity<JobSeeker> read(@PathVariable String userId) {
        JobSeeker jobSeeker = service.read(userId);
        if (jobSeeker != null) {
            return ResponseEntity.ok(jobSeeker);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/update")
    public ResponseEntity<JobSeeker> update(@RequestBody JobSeeker jobSeeker) {
        JobSeeker updated = service.update(jobSeeker);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Boolean> delete(@PathVariable String userId) {
        boolean deleted = service.delete(userId);
        if (deleted) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<JobSeeker>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}