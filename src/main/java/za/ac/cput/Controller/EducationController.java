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
    public Education create(@RequestBody Education education){
        return this.educationServiceRepo.create(education);
    }

    @GetMapping("/read")
    public Education read(String id){
        return this.educationServiceRepo.read(id);
    }

    @PutMapping("/update")
public Education update(@RequestBody Education education){
        return this.educationServiceRepo.update(education);
    }

    @DeleteMapping("/delete{userId}")
    public boolean delete(String id){
        return this.educationServiceRepo.delete(id);
    }

    @GetMapping("/getAll")
    public List<Education> getAll(Education education){
        return this.educationServiceRepo.getAll();
    }

    @GetMapping("/findByInstitution{institution}")
    public List<Education> findByInstitution(String institution){
        return this.educationServiceRepo.findByInstitution(institution);
    }

    @GetMapping("/findByDegree{degree}")
    public List<Education> findByDegree(String degree){
        return this.educationServiceRepo.findByInstitution(degree);
    }

}
