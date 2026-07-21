package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Service.IEducationService;
import za.ac.cput.domain.Education;

import java.util.List;

@RestController
@RequestMapping("/education")
public class EducationController {

    private IEducationService educationServiceRepo;

    @Autowired
    public EducationController(IEducationService educationServiceRepo) {
        this.educationServiceRepo = educationServiceRepo;
    }

    @PostMapping("/create")
    public Education create(@RequestBody Education education) {
        return this.educationServiceRepo.create(education);
    }

    @GetMapping("/read")
    public Education read(@RequestParam String id) {
        return this.educationServiceRepo.read(id);
    }

    @PutMapping("/update")
    public Education update(@RequestBody Education education) {
        return this.educationServiceRepo.update(education);
    }

    @DeleteMapping("/delete/{userId}")
    public boolean delete(@PathVariable("userId") String id) {
        return this.educationServiceRepo.delete(id);
    }

    @GetMapping("/getAll")
    public List<Education> getAll() {
        return this.educationServiceRepo.getAll();
    }

    @GetMapping("/findByInstitution")
    public List<Education> findByInstitution(@RequestParam String institution) {
        return this.educationServiceRepo.findByInstitution(institution);
    }

    @GetMapping("/findByDegree")
    public List<Education> findByDegree(@RequestParam String degree) {
        return this.educationServiceRepo.findByDegree(degree);
    }
}