package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Employer;
import za.ac.cput.Service.impl.EmployerServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin(origins = "*")
public class EmployerController {

    private final EmployerServiceImpl employerService;

    @Autowired
    public EmployerController(EmployerServiceImpl employerService) {
        this.employerService = employerService;
    }

    @PostMapping("/create")
    public ResponseEntity<Employer> createEmployer(@RequestBody Employer employer) {
        Employer created = employerService.create(employer);
        if (created != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Employer> readEmployer(@PathVariable String id) {
        Employer employer = employerService.read(id);
        if (employer != null) {
            return ResponseEntity.ok(employer);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Employer>> getAllEmployers() {
        return ResponseEntity.ok(employerService.findAll());
    }

    @PutMapping("/update")
    public ResponseEntity<Employer> updateEmployer(@RequestBody Employer employer) {
        Employer updated = employerService.update(employer);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteEmployer(@PathVariable String id) {
        boolean deleted = employerService.delete(id);
        if (deleted) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.notFound().build();
    }
}