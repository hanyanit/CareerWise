package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Service.ISkillService;
import za.ac.cput.domain.Skill;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin(origins = "*")
public class SkillController {
    private final ISkillService service;

    @Autowired
    public SkillController(ISkillService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Skill> create(@RequestBody Skill skill) {
        Skill created = service.create(skill);
        if (created != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/read/{skillId}")
    public ResponseEntity<Skill> read(@PathVariable String skillId) {
        Skill skill = service.read(skillId);
        if (skill != null) {
            return ResponseEntity.ok(skill);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Skill> update(@RequestBody Skill skill) {
        Skill updated = service.update(skill);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{skillId}")
    public ResponseEntity<Boolean> delete(@PathVariable String skillId) {
        boolean deleted = service.delete(skillId);
        if (deleted) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Skill>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}