package za.ac.cput.repository.impl;

import za.ac.cput.domain.Skill;
import za.ac.cput.repository.ISkillRepository;

import java.util.ArrayList;
import java.util.List;
/**
 * Author: Inga Mbobo, 230711723
 * Date: March 2026
 */
public class SkillRepositoryImpl implements ISkillRepository {

    private static ISkillRepository repository = null;
    private List<Skill> skillsList;

    private SkillRepositoryImpl() {
        skillsList = new ArrayList<>();
    }

    public static ISkillRepository getRepository() {
        if (repository == null) {
            repository = new SkillRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Skill create(Skill skill) {
        boolean success = skillsList.add(skill);
        if (success) {
            return skill;
        }
        return null;
    }

    @Override
    public Skill read(String skillId) {
        return skillsList.stream()
                .filter(skill -> skill.getSkillId().equals(skillId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Skill update(Skill skill) {
        String id = skill.getSkillId();
        Skill oldSkill = read(id);

        if (oldSkill == null) {
            return null;
        }

        boolean success = skillsList.remove(oldSkill);
        if (!success) {
            return null;
        }

        if (skillsList.add(skill)) {
            return skill;
        }

        return null;
    }

    @Override
    public boolean delete(String skillId) {
        Skill skillToDelete = read(skillId);
        if (skillToDelete == null) {
            return false;
        }
        return skillsList.remove(skillToDelete);
    }

    @Override
    public List<Skill> getAll() {
        return skillsList;
    }
}