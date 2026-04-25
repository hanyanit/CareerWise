package za.ac.cput.Service;

import za.ac.cput.domain.Employer;

import java.util.List;

public interface IEmployerService extends IService<Employer, String> {
    List<Employer> findAll();
    List<Employer> findByName(String name);
}
