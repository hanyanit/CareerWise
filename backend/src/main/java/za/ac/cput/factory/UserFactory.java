package za.ac.cput.factory;

import za.ac.cput.domain.Role;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

/**
 * UserFactory - Creates User instances
 * Uses Lombok's @Builder pattern
 */
public class UserFactory {

    /**
     * Create a User with required fields
     * @param userId Unique user ID
     * @param email User email
     * @param password User password
     * @return User instance
     */
    public static User createUser(String userId, String email, String password) {
        return createUser(userId, email, password, Role.JOBSEEKER);
    }

    public static User createUser(String userId, String email, String password, Role role) {
        if (Helper.isNullOrEmpty(userId) ||
                !Helper.isValidEmail(email) ||
                Helper.isNullOrEmpty(password)) {
            return null;
        }

        return User.builder()
                .userId(userId)
                .email(email)
                .password(password)
                .role(role != null ? role : Role.JOBSEEKER)
                .build();
    }

    /**
     * Create a complete User with all fields
     */
    public static User createUser(String userId, String email, String password,
                                  String firstName, String lastName, String phoneNumber,
                                  String location) {
        return createUser(userId, email, password, firstName, lastName, phoneNumber, location, Role.JOBSEEKER);
    }

    public static User createUser(String userId, String email, String password,
                                  String firstName, String lastName, String phoneNumber,
                                  String location, Role role) {
        if (Helper.isNullOrEmpty(userId) || !Helper.isValidEmail(email)) {
            return null;
        }

        return User.builder()
                .userId(userId)
                .email(email)
                .password(password)
                .firstName(firstName)
                .lastName(lastName)
                .phoneNumber(phoneNumber)
                .location(location)
                .role(role != null ? role : Role.JOBSEEKER)
                .build();
    }
}