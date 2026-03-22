package za.ac.cput.repository;

import za.ac.cput.domain.Skill;

import java.util.ArrayList;
import java.util.List;
/**
 * Author: Inga Mbobo, 230711723
 * Date: March 2026
 */
public class SkillRepository implements ISkillRepository{

    private static ISkillRepository repository = null;
    private List<Skill> skillsList;

    //singleton design pattern
    private SkillRepository(){
        skillsList = new ArrayList<>();
    }

    private static ISkillRepository getRepository(){
        if(repository == null){
            repository = new SkillRepository();
        }
        return repository;
    }

    @Override
    public Skill create(Skill skill) {
        return null;
    }

    @Override
    public Skill read(String s) {
        return null;
    }

    @Override
    public Skill update(Skill skill) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public List<Skill> getAll() {
        return List.of();
    }
}
