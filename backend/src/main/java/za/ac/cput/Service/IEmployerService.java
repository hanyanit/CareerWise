package za.ac.cput.Service;

import za.ac.cput.domain.Employer;

import java.util.List;

public interface IEmployerService extends IService<Employer, String> { // Fix: String not Integer
    List<Employer> findAll();
    List<Employer> findByName(String name);
}