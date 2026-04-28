package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Service.ISkillService;
import za.ac.cput.domain.Skill;

import java.util.List;

@RestController
@RequestMapping("/skill")
public class SkillController {

    private final ISkillService service;

    @Autowired
    public SkillController(ISkillService service) {
        this.service = service;
    }

    @PutMapping("/create")
    private Skill createSkill(@RequestBody Skill skill){
        return this.service.create(skill);
    }

    @GetMapping("/read/{skillId}")
    private Skill readSkill(@PathVariable String skillId){
        return this.service.read(skillId);
    }

    @PostMapping("/update")
    private Skill updateSkill(Skill skill){
        return this.service.update(skill);
    }

    @DeleteMapping("/delete/{skillId}")
    private boolean deleteSkill(@PathVariable String skillId){
        return this.service.delete(skillId);
    }

    @GetMapping("/getAll")
    private List<Skill> getAllSkills(){
        return this.service.getAll();
    }
}
