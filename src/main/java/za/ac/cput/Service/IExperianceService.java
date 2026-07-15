package za.ac.cput.Service;

import za.ac.cput.domain.Experience;

import java.util.List;

public interface IExperianceService extends IService<Experience, String>{
    List<Experience> findAll();
}
