package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import za.ac.cput.Service.UserService;
import za.ac.cput.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    public User createUser(@RequestBody User user) throws Exception {
        return userService.signUp(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody String email, String password) throws Exception {
        return userService.login(email,password);
    }




}
