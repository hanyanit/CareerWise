package za.ac.cput.repository;

import za.ac.cput.domain.Education;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Phumlani Mdlalo, 241093813
 * Date: March 2026
 */

public class EducationRepository implements IEducationRepository {

    private static IEducationRepository repository = null;
    private List<Education> educationList;

    private EducationRepository() {
        educationList = new ArrayList<>();
    }

    public static IEducationRepository getRepository() {
        if (repository == null) {
            repository = new EducationRepository();
        }
        return repository;
    }

    @Override
    public Education create(Education education) {
        boolean success = educationList.add(education);
        if (success) return education;
        return null;
    }

    @Override
    public Education read(String educationId) {
        for (Education education : educationList) {
            if (education.getEducationId().equals(educationId)) {
                return education;
            }
        }
        return null;
    }

    @Override
    public Education update(Education education) {
        String id = education.getEducationId();
        Education old = read(id);
        if (old == null) return null;

        boolean success = educationList.remove(old);
        if (!success) return null;

        if (educationList.add(education)) return education;
        return null;
    }

    @Override
    public boolean delete(String educationId) {
        Education toDelete = read(educationId);
        if (toDelete == null) return false;
        return educationList.remove(toDelete);
    }

    @Override
    public List<Education> getAll() {
        return new ArrayList<>(educationList);
    }

    @Override
    public List<Education> findByInstitution(String institution) {
        List<Education> result = new ArrayList<>();
        for (Education education : educationList) {
            if (education.getInstitution().equalsIgnoreCase(institution)) {
                result.add(education);
            }
        }
        return result;
    }

    @Override
    public List<Education> findByDegree(String degree) {
        List<Education> result = new ArrayList<>();
        for (Education education : educationList) {
            if (education.getDegree().equalsIgnoreCase(degree)) {
                result.add(education);
            }
        }
        return result;
    }
}