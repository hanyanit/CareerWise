package za.ac.cput.Service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import za.ac.cput.Service.IEducationService;
import za.ac.cput.domain.Education;
import za.ac.cput.repository.IEducationRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EducationServiceImpl implements IEducationService {

    private final IEducationRepository repository;
    private List<Education> educationList;

    public EducationServiceImpl(@Qualifier("IEducationRepository") IEducationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Education create(Education education) {
        return repository.save(education);
    }

    @Override
    public Education read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Education update(Education education) {
        return repository.save(education);
    }

    @Override
    public Education delete(String id) {
       return repository.deleteById(id);
    }

    @Override
    public List<Education> getAll() {
        return repository.findAll();
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
