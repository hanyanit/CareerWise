package za.ac.cput.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Service.IEducationService;
import za.ac.cput.domain.Education;
import za.ac.cput.repository.IEducationRepository;

import java.util.List;

@Service
public class EducationServiceImpl implements IEducationService {

    private final IEducationRepository repository;

    @Autowired
    public EducationServiceImpl(IEducationRepository repository) {
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
        // Check if education exists before updating
        if (education.getEducationId() != null &&
                repository.existsById(education.getEducationId())) {
            return repository.save(education);
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Education> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Education> findByInstitution(String institution) {
        return repository.findByInstitutionContainingIgnoreCase(institution);
    }

    @Override
    public List<Education> findByDegree(String degree) {
        return repository.findByDegreeContainingIgnoreCase(degree);
    }
}