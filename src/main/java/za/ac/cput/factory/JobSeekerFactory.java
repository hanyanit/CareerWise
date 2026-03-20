package za.ac.cput.factory;

/**
 * Author: Inga Mbobo, 230711723
 * Date: March 2026
 */
import za.ac.cput.domain.JobSeeker;
import za.ac.cput.domain.Skill;
import za.ac.cput.domain.Education;
import za.ac.cput.util.Helper;

import java.io.File;
import java.util.List;
import java.util.UUID;


public class JobSeekerFactory {

    public static JobSeeker createJobSeeker(String email, String password,String firstName, String lastName,String headline, String summary,File resume, List<Skill> skills,List<Education> education) {

        if (Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(password)) {
            return null;
        }

        if(!Helper.isValidEmail(email)){
            return null;
        }

        String userId = UUID.randomUUID().toString();

        return new JobSeeker.JobSeekerBuilder(userId, email, password)
                .firstName(firstName)
                .lastName(lastName)
                .headline(headline)
                .summary(summary)
                .resume(resume)
                .skills(skills)
                .education(education)
                .build();
    }
}