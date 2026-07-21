package za.ac.cput.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepo;

@Service
public class UserService {
    @Autowired
   private  UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User signUp  ( User user)throws Exception{

        if(userRepo.existsByEmail(user.getEmail())){
            throw new Exception("email already exists");}
    return userRepo.save(user);

    }

    public User login (String email, String password) throws Exception{

        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new Exception("User not found"));

        if (!user.getPassword().equals(password)) {
            throw new Exception("Invalid password");
        }

        return user;
    }


 public User Login(String email, String Password) throws Exception{

     User user = userRepo.findByEmail(email)
             .orElseThrow(() -> new Exception("User not found"));

     if (!user.getPassword().equals(Password)) {
         throw new Exception("Invalid password");
     }

     return user;
 }

}

