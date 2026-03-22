package za.ac.cput.repository;

import za.ac.cput.domain.Experience;

import java.util.ArrayList;
import java.util.List;

public class ExperienceRepository implements IExperienceRepository {

    private static IExperienceRepository repository = null;
    private List<Experience> experienceList;

    private ExperienceRepository() {
        experienceList = new ArrayList<>();
    }

    public static IExperienceRepository getRepository(){
        if(repository == null){
            repository = new ExperienceRepository();
        }
        return repository;
    }

    @Override
    public Experience create(Experience experience) {
        return null;
    }

    @Override
    public Experience read(String s) {
        return null;
    }

    @Override
    public Experience update(Experience experience) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public List<Experience> getAll() {
        return List.of();
    }

}
