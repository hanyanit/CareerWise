package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * UserRepositoryTest.java
 * Author: Hanyani Masinge, 222693452
 */
class UserRepositoryTest {

    private UserRepository repository;
    private User user;

    @BeforeEach
    void setUp() {
        repository = UserRepository.getRepository();

        user = new User.Builder()
                .setUserId("9204165076082")
                .setFirstName("Jabulani")
                .setLastName("Twala")
                .setLocation("Pretoria")
                .build();

        repository.create(user);
    }

    @Test
    void create() {
        User newUser = new User.Builder()
                .setUserId("9603226709083")
                .setFirstName("Mike")
                .setLastName("Van Nieker")
                .build();

        User created = repository.create(newUser);

        assertNotNull(created);
        assertEquals("9603226709083", created.getUserId());
    }

    @Test
    void read() {
        User readUser = repository.read("9204165076082");

        assertNotNull(readUser);
        assertEquals("Jabulani", readUser.getFirstName());
    }

    @Test
    void update() {
        User updatedUser = new User.Builder()
                .setUserId("9204165076082")
                .setFirstName("UpdatedName")
                .setLastName("Twala")
                .setLocation("Pretoria")
                .build();

        User result = repository.update(updatedUser);

        assertNotNull(result);
        assertEquals("UpdatedName", repository.read("9204165076082").getFirstName());
    }

    @Test
    void delete() {
        User tempUser = new User.Builder()
                .setUserId("9603226709083")
                .setFirstName("Temp")
                .setLastName("User")
                .build();

        repository.create(tempUser);

        boolean deleted = repository.delete("9603226709083");

        assertTrue(deleted);
        assertNull(repository.read("9603226709083"));
    }

    @Test
    void getAll() {
        List<User> users = repository.getAll();

        assertNotNull(users);
        assertFalse(users.isEmpty());
    }

}