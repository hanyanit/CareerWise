package za.ac.cput.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Service.ISkillService;
import za.ac.cput.domain.Skill;
import za.ac.cput.repository.ISkillRepository;

import java.util.List;

@Service
public class SkillServiceImp implements ISkillService {

    private final ISkillRepository skillRepository;

    @Autowired
    public SkillServiceImp(ISkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public Skill create(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public Skill read(String skillId) {
        return skillRepository.findById(skillId).orElse(null);
    }

    @Override
    public Skill update(Skill skill) {
        if (skill.getSkillId() != null && skillRepository.existsById(skill.getSkillId())) {
            return skillRepository.save(skill);
        }
        return null;
    }

    @Override
    public boolean delete(String skillId) {
        if (skillRepository.existsById(skillId)) {
            skillRepository.deleteById(skillId);
            return true;
        }
        return false;
    }

    @Override
    public List<Skill> getAll() {
        return skillRepository.findAll();
    }
}