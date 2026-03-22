package za.ac.cput.repository;

import za.ac.cput.domain.Education;
import java.util.List;

public interface IEducationRepository extends IRepository<Education, String> {
    List<Education> getAll();
    List<Education> findByInstitution(String institution);
    List<Education> findByDegree(String degree);
}