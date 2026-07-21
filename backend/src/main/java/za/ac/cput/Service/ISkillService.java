package za.ac.cput.Service;

import za.ac.cput.domain.Skill;

import java.util.List;

public interface ISkillService extends IService<Skill, String>{
    List<Skill> getAll();
    boolean delete(String id);
}
