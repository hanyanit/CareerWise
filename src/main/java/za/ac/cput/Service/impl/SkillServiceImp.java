package za.ac.cput.Service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.Service.ISkillService;
import za.ac.cput.domain.Skill;
import za.ac.cput.repository.SkillRepository;

import java.util.List;

@Service
public class SkillServiceImp implements ISkillService {


    private final SkillRepository skillRepository;

    public SkillServiceImp(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public Skill create(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public Skill read(String s) {
        return skillRepository.getById(s);
    }

    @Override
    public Skill update(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public boolean delete(String s) {
        skillRepository.deleteById(s);
        return true;
    }

    @Override
    public List<Skill> getAll() {
        return skillRepository.findAll();
    }
}
