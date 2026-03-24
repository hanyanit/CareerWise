package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Experience;

import static org.junit.jupiter.api.Assertions.*;

class ExperienceFactoryTest {

    @Test
    void createExperience() {
        Experience exp1 = ExperienceFactory.createExperience("expr101","None",
                "None","None","I still am a student");
        assertNotNull(exp1);
        System.out.println(exp1.toString());
    }

    @Test
    void createExperienceThatFails(){
        Experience exp2 = ExperienceFactory.createExperience("","None", //No experienceID and description
                "None","None","I still am a student");
        assertNotNull(exp2);
        System.out.println(exp2.toString());
    }
}