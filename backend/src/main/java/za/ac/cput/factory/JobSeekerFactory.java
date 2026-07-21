package za.ac.cput.factory;

import za.ac.cput.domain.JobSeeker;
import za.ac.cput.util.Helper;

import java.util.UUID;

public class JobSeekerFactory {

    public static JobSeeker createJobSeeker(
            String email,
            String password,
            String firstName,
            String lastName,
            String profilePicture,
            String phoneNumber,
            String location,
            String headline,
            String summary,
            String resumePath,
            String skills,
            String education) {

        if (Helper.isNullOrEmpty(email) ||
                !Helper.isValidEmail(email) ||
                Helper.isNullOrEmpty(password) ||
                Helper.isNullOrEmpty(firstName) ||
                Helper.isNullOrEmpty(lastName) ||
                Helper.isNullOrEmpty(headline) ||
                Helper.isNullOrEmpty(summary)) {
            return null;
        }

        return new JobSeeker.Builder()
                .setUserId(UUID.randomUUID().toString())
                .setEmail(email)
                .setPassword(password)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setProfilePicture(profilePicture)
                .setPhoneNumber(phoneNumber)
                .setLocation(location)
                .setHeadline(headline)
                .setSummary(summary)
                .setResumePath(resumePath)
                .setSkills(skills)
                .setEducation(education)
                .build();
    }
}
