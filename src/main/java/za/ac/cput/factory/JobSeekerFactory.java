package za.ac.cput.factory;

import za.ac.cput.domain.JobSeeker;
import za.ac.cput.util.Helper;
import java.util.UUID;

public class JobSeekerFactory {

    // 1. Basic Factory Method with an explicit User ID
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

    // 2. Basic Factory Method that auto-generates a UUID string
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

    // 3. FULL Factory Method mapping all user profile fields correctly
    public static JobSeeker createFullJobSeeker(String userId, String email, String password,
                                                String firstName, String lastName,
                                                String profilePicture, String phoneNumber, String location,
                                                String headline, String summary,
                                                String resumePath) {

        // Validate mandatory core fields
        if (Helper.isNullOrEmpty(userId) || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(password)) {
            return null;
        }

        if (!Helper.isValidEmail(email)) {
            return null;
        }

        if (Helper.isNullOrEmpty(headline) || Helper.isNullOrEmpty(summary)) {
            return null;
        }

        // Initialize the builder with primary registration identifiers
        JobSeeker.JobSeekerBuilder builder = new JobSeeker.JobSeekerBuilder(userId, email, password)
                .firstName(firstName)
                .lastName(lastName)
                .headline(headline)
                .summary(summary);

        // Map extended optional profile fields safely to the builder instance
        if (!Helper.isNullOrEmpty(profilePicture)) {
            builder.profilePicture(profilePicture);
        }

        if (!Helper.isNullOrEmpty(phoneNumber)) {
            builder.phoneNumber(phoneNumber);
        }

        if (!Helper.isNullOrEmpty(location)) {
            builder.location(location);
        }

        if (!Helper.isNullOrEmpty(resumePath)) {
            builder.resumePath(resumePath);
        }

        return builder.build();
    }
}
