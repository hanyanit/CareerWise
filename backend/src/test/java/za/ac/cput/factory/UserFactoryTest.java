package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Role;
import za.ac.cput.domain.User;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

    @Test
    void createUser() {
        User user = UserFactory.createUser(
                "9904165076082",
                "masingehanyanit@mail.com",
                "Hanyani16",
                "Hanyani",
                "Masinge",
                "profilepicture.jpg",
                "0839659906"
        );

        assertNotNull(user);
        assertEquals(Role.JOBSEEKER, user.getRole());
    }

    @Test
    void createUserWithRole() {
        User user = UserFactory.createUser(
                "9904165076083",
                "employer@techcorp.com",
                "SecretPass1",
                "Boss",
                "Manager",
                "0831112233",
                "Johannesburg",
                Role.EMPLOYER
        );

        assertNotNull(user);
        assertEquals(Role.EMPLOYER, user.getRole());
    }

    @Test
    void createUserEmptyEmail() {
        User user = UserFactory.createUser(
                "9904165076082",
                "",
                "Hanyani16",
                "Hanyani",
                "Masinge",
                "profilepicture.jpg",
                "0839659906"
        );

        assertNull(user);
    }
}