package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Service.IEducationService;
import za.ac.cput.domain.Education;

import java.util.List;

@RestController
@RequestMapping("/api/educations")
@CrossOrigin(origins = "*")
public class EducationController {

    private final IEducationService educationService;

    @Autowired
    public EducationController(IEducationService educationService) {
        this.educationService = educationService;
    }

    @PostMapping("/create")
    public ResponseEntity<Education> create(@RequestBody Education education) {
        Education created = educationService.create(education);
        if (created != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Education> read(@PathVariable String id) {
        Education education = educationService.read(id);
        if (education != null) {
            return ResponseEntity.ok(education);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Education> update(@RequestBody Education education) {
        Education updated = educationService.update(education);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        boolean deleted = educationService.delete(id);
        if (deleted) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Education>> getAll() {
        return ResponseEntity.ok(educationService.getAll());
    }

    @GetMapping("/findByInstitution")
    public ResponseEntity<List<Education>> findByInstitution(@RequestParam String institution) {
        return ResponseEntity.ok(educationService.findByInstitution(institution));
    }

    @GetMapping("/findByDegree")
    public ResponseEntity<List<Education>> findByDegree(@RequestParam String degree) {
        return ResponseEntity.ok(educationService.findByDegree(degree));
    }
}