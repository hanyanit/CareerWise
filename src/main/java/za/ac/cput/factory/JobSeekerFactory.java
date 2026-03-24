package za.ac.cput.factory;

/**
 * Author: Inga Mbobo, 230711723
 * Date: March 2026
 */
import za.ac.cput.domain.JobSeeker;
import za.ac.cput.util.Helper;

import java.util.UUID;


public class JobSeekerFactory {

    public static JobSeeker createJobSeeker(String email, String password, String firstName, String lastName,String headline, String summary) {

        if (Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(password)|| Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(headline)|| Helper.isNullOrEmpty(summary)) {
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
//                .resume(resume)
//                .skills(skills)
//                .education(education)
                .build();
    }
}