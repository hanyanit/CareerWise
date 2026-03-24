package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Skill;

import static org.junit.jupiter.api.Assertions.*;

class SkillFactoryTest {

    @Test
    void createSkill() {
        Skill skill = SkillFactory.createSkill("Empathy","Soft Skill",4f);

        assertNotNull(skill);
        System.out.println(skill.toString());
    }

    @Test
    void createSkillThatFails(){
        Skill skill = SkillFactory.createSkill("","",4f);
        assertNotNull(skill);
        System.out.println(skill.toString());
    }
}