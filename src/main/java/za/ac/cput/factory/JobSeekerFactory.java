package za.ac.cput.factory;

import za.ac.cput.domain.JobSeeker;
import za.ac.cput.util.Helper;
import za.ac.cput.domain.Skill;
import za.ac.cput.domain.Education;

import java.util.List;
import java.util.UUID;

public class JobSeekerFactory {

    public static JobSeeker createJobSeeker(String userId, String email, String password,
                                            String firstName, String lastName,
                                            String headline, String summary) {

        if (Helper.isNullOrEmpty(userId) || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(password)) {
            return null;
        }

        if (!Helper.isValidEmail(email)) {
            return null;
        }

        if (Helper.isNullOrEmpty(headline) || Helper.isNullOrEmpty(summary)) {
            return null;
        }

        return new JobSeeker.JobSeekerBuilder(userId, email, password)
                .firstName(firstName)
                .lastName(lastName)
                .headline(headline)
                .summary(summary)
                .build();
    }

    public static JobSeeker createJobSeeker(String email, String password,
                                            String firstName, String lastName,
                                            String headline, String summary) {

        if (Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(password)) {
            return null;
        }

        if (!Helper.isValidEmail(email)) {
            return null;
        }

        if (Helper.isNullOrEmpty(headline) || Helper.isNullOrEmpty(summary)) {
            return null;
        }

        String userId = UUID.randomUUID().toString();

        return new JobSeeker.JobSeekerBuilder(userId, email, password)
                .firstName(firstName)
                .lastName(lastName)
                .headline(headline)
                .summary(summary)
                .build();
    }

    public static JobSeeker createFullJobSeeker(String userId, String email, String password,
                                                String firstName, String lastName,
                                                String profilePicture, String phoneNumber, String location,
                                                String headline, String summary,
                                                String resumePath, List<Skill> skills, List<Education> education) {

        if (Helper.isNullOrEmpty(userId) || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(password) ||
                !Helper.isValidEmail(email) || Helper.isNullOrEmpty(headline) || Helper.isNullOrEmpty(summary)) {
            return null;
        }



        JobSeeker.JobSeekerBuilder builder =
                new JobSeeker.JobSeekerBuilder(userId, email, password)
                        .firstName(firstName)
                        .lastName(lastName)
                        .headline(headline)
                        .summary(summary);


//        if (!Helper.isNullOrEmpty(profilePicture)) {
//            builder.profilePicture(profilePicture);
//        }
//
//        if (!Helper.isNullOrEmpty(phoneNumber)) {
//            builder.phoneNumber(phoneNumber);
//        }
//
//        if (!Helper.isNullOrEmpty(location)) {
//            builder.location(location);
//        }
//
//        if (!Helper.isNullOrEmpty(resumePath)) {
//            builder.resumePath(resumePath);
//        }
//
//        if (skills != null && !skills.isEmpty()) {
//            builder.skills(skills);
//        }
//
//        if (education != null && !education.isEmpty()) {
//            builder.education(education);
//        }


        return builder.build();
    }
}