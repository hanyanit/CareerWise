package za.ac.cput.Service;

import za.ac.cput.domain.Education;

import java.util.List;

public interface IEducationService extends IService<Education,String> {
    List<Education> getAll();
    List<Education> findByInstitution(String institution);
    List<Education> findByDegree(String degree);
}
