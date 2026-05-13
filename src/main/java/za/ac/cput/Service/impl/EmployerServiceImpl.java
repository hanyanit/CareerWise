package za.ac.cput.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Service.IEmployerService;
import za.ac.cput.domain.Employer;
import za.ac.cput.repository.IEmployerRepository;

import java.util.List;

@Service
public class EmployerServiceImpl implements IEmployerService {



    public final IEmployerRepository employerRepository;

    @Autowired
    public EmployerServiceImpl(IEmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }


    @Override
    public Employer create(Employer employer) {
        return this.employerRepository.save(employer);
    }

    @Override
    public Employer read(Integer integer) {
        return this.employerRepository.findById(integer).orElse(null);
    }

    @Override
    public Employer update(Employer employer) {
        return this.employerRepository.save(employer);
    }

    @Override
    public boolean delete(Integer integer) {
        this.employerRepository.deleteById(integer);
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
