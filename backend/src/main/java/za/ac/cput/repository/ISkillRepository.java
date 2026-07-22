package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Skill;

import java.util.List;

@Repository
public interface ISkillRepository extends JpaRepository<Skill, String> {
    List<Skill> findByCategory(String category);
}