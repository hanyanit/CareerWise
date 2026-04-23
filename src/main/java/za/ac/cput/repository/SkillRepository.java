package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Skill;

import java.util.List;
/**
 * Author: Inga Mbobo, 230711723
 * Date: March 2026
 */
@Repository
public interface SkillRepository extends JpaRepository<Skill, String> { //IRepository
    List<Skill> getAll();
}
