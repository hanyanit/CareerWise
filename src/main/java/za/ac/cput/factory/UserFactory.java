package za.ac.cput.factory;

import za.ac.cput.domain.User;

public class UserFactory {

    public static User createUser(String userId, String email, String password,
                                  String firstName, String lastName,
                                  String profilePicture, String phoneNumber,
                                  String location) {


        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("User ID is required");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password is required");
        }


        return new User.Builder(userId, email, password)
                .firstName(firstName)
                .lastName(lastName)
                .profilePicture(profilePicture)
                .phoneNumber(phoneNumber)
                .location(location)
                .build();
    }
}
