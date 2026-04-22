package za.ac.cput.Service;

import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepo;

@Service
public class UserService {

    UserRepo userRepo;

    public User signUp(User user){

        return userRepo.save(user);

    }


 public User Login(String email, String Password) {

        User user= (User) userRepo.findByEmail(email);

        if(user.getPassword().equals(Password)){
            return null;
        }

        return user;
 }

}

