package za.ac.cput.repository;

import za.ac.cput.domain.User;

import java.util.List;
/**
 * Employer.java
 * Author: Hanyani Masinge, 222693452
 */

@Deprecated
public interface IUserRepository<T,ID> {
    User create(User user);

    User read(String userId);

    User update(User user);

    boolean delete(String userId);

    List<User> getAll();
}
