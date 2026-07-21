package za.ac.cput.repository;

import za.ac.cput.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Employer.java
 * Author:Hanyani Masinge, 222693452
 * Date: 17 March 2026
 */

@Deprecated
public class UserRepository implements IUserRepository{
    private static UserRepository repository = null;
    private Map<String, User> User;

    private UserRepository() {
        User = new HashMap<>();
    }

    public static UserRepository getRepository() {
        if (repository == null) {
            repository = new UserRepository();
        }
        return repository;
    }

    @Override
    public User create(User user) {
        User.put(user.getUserId(), user);
        return user;
    }

    @Override
    public User read(String userId) {
        return User.get(userId);
    }

    @Override
    public User update(User user) {
        if (User.containsKey(user.getUserId())) {
            User.put(user.getUserId(), user);
            return user;
        }
        return null;
    }

    @Override
    public boolean delete(String userId) {
        User removed = User.remove(userId);
        return removed != null;
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(User.values());
    }
}

