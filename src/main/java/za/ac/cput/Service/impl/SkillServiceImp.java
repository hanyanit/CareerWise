package za.ac.cput.Service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.Service.ISkillService;
import za.ac.cput.domain.Skill;
import za.ac.cput.repository.ISkillRepository;

import java.util.List;

@Service
public class SkillServiceImp implements ISkillService {


    private final ISkillRepository ISkillRepository;

    public SkillServiceImp(ISkillRepository ISkillRepository) {
        this.ISkillRepository = ISkillRepository;
    }

    @Override
    public Skill create(Skill skill) {
        return this.ISkillRepository.save(skill);
    }

    @Override
    public Skill read(String skillId) {
        return this.ISkillRepository.getById(skillId);
    }

    @Override
    public Skill update(Skill skill) {
        return this.ISkillRepository.save(skill);
    }

    @Override
    public boolean delete(String skillId) {
        this.ISkillRepository.deleteById(skillId);
        return true;
    }

    @Override
    public List<Skill> getAll() {
        return ISkillRepository.findAll();
    }
}
