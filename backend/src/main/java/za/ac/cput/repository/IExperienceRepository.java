package za.ac.cput.repository;

import za.ac.cput.domain.Experience;

import java.util.List;

public interface IExperienceRepository extends IRepository<Experience, String>{
    List<Experience> getAll();
}
