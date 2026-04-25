package za.ac.cput.Service.impl;

import za.ac.cput.Service.IEmployerService;
import za.ac.cput.domain.Employer;
import za.ac.cput.repository.IEmployerRepository;

import java.util.List;

public class EmployerServiceImpl implements IEmployerService {

    public static IEmployerRepository employerRepository;

    public EmployerServiceImpl(IEmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }


    @Override
    public Employer create(Employer employer) {
        return this.employerRepository.save(employer);
    }

    @Override
    public Employer read(String s) {
        return this.employerRepository.getById(s);
    }

    @Override
    public Employer update(Employer employer) {
        return this.employerRepository.save(employer);
    }

    @Override
    public boolean delete(String s) {
       this.employerRepository.deleteById(s);
        return true;
    }

    @Override
    public List<Employer> findAll() {
        return this.employerRepository.findAll();
    }

    @Override
    public List<Employer> findByName(String name) {
        return List.of();
    }
}
