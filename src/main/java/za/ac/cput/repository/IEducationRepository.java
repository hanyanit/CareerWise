package za.ac.cput.repository;

import za.ac.cput.domain.Education;
import java.util.List;

/**
 * Author: Phumlani Mdlalo, 241093813
 * Date: March 2026
 */

public interface IEducationRepository extends IRepository<Education, String> {
    List<Education> getAll();
    List<Education> findByInstitution(String institution);
    List<Education> findByDegree(String degree);
}