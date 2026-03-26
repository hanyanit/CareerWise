package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    private UserRepository repository;
    private User user;

    @BeforeEach
    void setUp() {
        repository = UserRepository.getRepository();

        user = new User.Builder("9204165076082", "jabu@mail.com", "Jabulani25")
                .firstName("Jabulani")
                .lastName("Twala")
                .location("Pretoria")
                .build();

        repository.create(user);
    }

    @Test
    void create() {
        User newUser = new User.Builder("9603226709083", "Mike22@mail.com", "5678")
                .firstName("Mike")
                .lastName("Van Nieker")
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
        User updatedUser = new User.Builder("9204165076082", "test@mail.com", "1234")
                .firstName("UpdatedName")
                .lastName("Twala")
                .location("Pretoria")
                .build();

        User result = repository.update(updatedUser);

        assertNotNull(result);
        assertEquals("UpdatedName", repository.read("9204165076082").getFirstName());
    }

    @Test
    void delete() {
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