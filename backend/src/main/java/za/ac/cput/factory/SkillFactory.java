package za.ac.cput.factory;

import za.ac.cput.domain.Skill;
import za.ac.cput.util.Helper;

import java.util.UUID;

public class SkillFactory {

    public static Skill createSkill(String name, String category, int yearsOfExperience) {

        if (Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(category)) {
            return null;
        }

        if (yearsOfExperience < 0) {
            return null;
        }

        String skillId = UUID.randomUUID().toString();

        return Skill.builder()
                .skillId(skillId)
                .name(name)
                .category(category)
                .yearsOfExperience(yearsOfExperience)
                .build();
    }
}