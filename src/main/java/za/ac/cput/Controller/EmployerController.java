package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Employer;
import za.ac.cput.Service.impl.EmployerServiceImpl;
import java.util.List;

@RestController
@RequestMapping("/employer")
public class EmployerController {


    private EmployerServiceImpl employerService;

    @Autowired
    public EmployerController(EmployerServiceImpl employerService) {
        this.employerService = employerService;
    }

    @PostMapping("/create")
    public Employer createEmployer(@RequestBody Employer employer){
        return employerService.create(employer);
    }

   @GetMapping("/read/{companyName}")
    public Employer readEmployer(@PathVariable String  companyName) {
        return employerService.read(companyName);
    }

    @GetMapping("/getAll")
    public List<Employer> readEmployer(){
        return employerService.findAll();
    }

    @PutMapping("/update")
    public Employer updateEmployer(@RequestBody Employer employer){
        return employerService.update(employer);
    }

    @DeleteMapping("/delete/{companyName}")
    public boolean deleteEmployer(@PathVariable String companyName) {
        return employerService.delete(companyName);
    }


}
