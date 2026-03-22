package za.ac.cput.repository;

import za.ac.cput.domain.Experience;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Inga Mbobo, 230711723
 * Date: March 2026
 */
public class ExperienceRepository implements IExperienceRepository {

    private static IExperienceRepository repository = null;
    private List<Experience> experienceList;

    private ExperienceRepository() {
        experienceList = new ArrayList<>();
    }

    public static IExperienceRepository getRepository() {
        if (repository == null) {
            repository = new ExperienceRepository();
        }
        return repository;
    }

    @Override
    public Experience create(Experience experience) {
        boolean success = experienceList.add(experience);
        if (success) {
            return experience;
        }
        return null;
    }

    @Override
    public Experience read(String experienceId) { // I will code this class using lambda expression
        return experienceList.stream()
                .filter(experience -> experience.getExperienceID().equals(experienceId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Experience update(Experience experience) {
        String id = experience.getExperienceID();
        Experience oldExperience = read(id);

        if (oldExperience == null) {
            return null;
        }

        boolean success = experienceList.remove(oldExperience);
        if (!success) {
            return null;
        }

        if (experienceList.add(experience)) {
            return experience;
        }

        return null;
    }

    @Override
    public boolean delete(String experienceId) {
        Experience experienceToDelete = read(experienceId);
        if (experienceToDelete == null) {
            return false;
        }
        return experienceList.remove(experienceToDelete);
    }

    @Override
    public List<Experience> getAll() {
        return experienceList;
    }
}