package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User,String> {

    List<User> findByEmail(String email);
    List<User> findByUserId(String userId);

    //boolean <User>  deleteByName(String userName);
}



