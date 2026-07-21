package za.ac.cput.factory;

import za.ac.cput.domain.User;

/**
 * UserFactory.java
 * Factory for creating User objects with validation
 */
public class UserFactory {

    public static User createUser(
            String userId,
            String email,
            String password,
            String firstName,
            String lastName,
            String profilePicture,
            String phoneNumber,
            String location) {

        // Validation
        if (userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException("User ID is required");
        }

        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }

        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password is required");
        }

        // Build and return User
        return new User.Builder()
                .setUserId(userId)
                .setEmail(email)
                .setPassword(password)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setProfilePicture(profilePicture)
                .setPhoneNumber(phoneNumber)
                .setLocation(location)
                .build();
    }
}