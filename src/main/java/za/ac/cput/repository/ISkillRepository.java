package za.ac.cput.repository;

import za.ac.cput.domain.Skill;

import java.util.List;
/**
 * Author: Inga Mbobo, 230711723
 * Date: March 2026
 */
public interface ISkillRepository extends IRepository<Skill, String>{
    List<Skill> getAll();
}
