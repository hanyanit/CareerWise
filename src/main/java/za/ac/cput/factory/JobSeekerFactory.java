package za.ac.cput.factory;

/**
 * Author: Inga Mbobo, 230711723
 * Date: March 2026
 */

import za.ac.cput.domain.JobSeeker;
import za.ac.cput.util.Helper;

import java.io.File;
import java.util.List;
import java.util.UUID;

import za.ac.cput.domain.Skill;
import za.ac.cput.domain.Education;

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

        return new JobSeeker.Builder(userId, email, password)
                .firstName(firstName)
                .lastName(lastName)
                .setHeadline(headline)
                .setSummary(summary)
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

        return new JobSeeker.Builder(userId, email, password)
                .firstName(firstName)
                .lastName(lastName)
                .setHeadline(headline)
                .setSummary(summary)
                .build();
    }

    public static JobSeeker createFullJobSeeker(String userId, String email, String password,
                                                String firstName, String lastName,
                                                String profilePicture, String phoneNumber, String location,
                                                String headline, String summary,
                                                File resume, List<Skill> skills, List<Education> education) {

        if (Helper.isNullOrEmpty(userId) || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(password)) {
            return null;
        }

        if (!Helper.isValidEmail(email)) {
            return null;
        }

        if (Helper.isNullOrEmpty(headline) || Helper.isNullOrEmpty(summary)) {
            return null;
        }

        JobSeeker.Builder builder = new JobSeeker.Builder(userId, email, password)
                .firstName(firstName)
                .lastName(lastName)
                .setHeadline(headline)
                .setSummary(summary);

        // Add optional fields
        if (!Helper.isNullOrEmpty(profilePicture)) {
            builder.profilePicture(profilePicture);
        }

        if (!Helper.isNullOrEmpty(phoneNumber)) {
            builder.phoneNumber(phoneNumber);
        }

        if (!Helper.isNullOrEmpty(location)) {
            builder.location(location);
        }

        if (resume != null) {
            builder.setResume(resume);
        }

        if (skills != null && !skills.isEmpty()) {
            builder.setSkills(skills);
        }

        if (education != null && !education.isEmpty()) {
            builder.setEducation(education);
        }

        return builder.build();
    }
}