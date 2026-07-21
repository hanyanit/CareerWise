package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.User;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

    @Test
    void createUser_Success() {

        User user = UserFactory.createUser(
                "9904165076082",
                "masingehanyanit@mail.com",
                "Hanyani16",
                "Hanyani",
                "Masinge",
                "profilepicture.jpg",
                "0839659906",
                "Cape Town"
        );

        assertNotNull(user);
        assertEquals("9904165076082", user.getUserId());
        assertEquals("masingehanyanit@mail.com", user.getEmail());
        assertEquals("Hanyani", user.getFirstName());
        assertEquals("Cape Town", user.getLocation());
    }

    @Test
    void createUser_Fail_UserIdNull() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            UserFactory.createUser(
                    null,
                    "masingehanyanit@mail.com",
                    "Hanyani16",
                    "Hanyani",
                    "Masinge",
                    null,
                    null,
                    null
            );
        });

        assertEquals("User ID is required", exception.getMessage());
    }

    @Test
    void createUser_Fail_EmailEmpty() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            UserFactory.createUser(
                    "9904165076082",
                    "",
                    "Hanyani16",
                    "Hanyani",
                    "Masinge",
                    null,
                    null,
                    null
            );
        });

        assertEquals("Email is required", exception.getMessage());
    }

    @Test
    void createUser_Fail_PasswordNull() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            UserFactory.createUser(
                    "9904165076082",
                    "masingehanyanit@mail.com",
                    null,
                    "Hanyani",
                    "Masinge",
                    null,
                    null,
                    null
            );
        });

        assertEquals("Password is required", exception.getMessage());
    }

}