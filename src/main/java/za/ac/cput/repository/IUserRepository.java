package za.ac.cput.repository;

import za.ac.cput.domain.User;

import java.util.List;

public interface IUserRepository<T,ID> {
    User create(User user);

    User read(String userId);

    User update(User user);

    boolean delete(String userId);

    List<User> getAll();
}
