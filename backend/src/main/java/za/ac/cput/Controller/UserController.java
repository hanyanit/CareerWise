package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Service.UserService;
import za.ac.cput.domain.User;
import za.ac.cput.security.JwtUtil;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/signup")
    public User signUp(@RequestBody User user) throws Exception {
        User created = this.userService.signUp(user);
        created.setToken(this.jwtUtil.generateToken(created.getEmail()));
        return created;
    }

    @PostMapping("/login")
    public User login(@RequestBody Map<String, String> loginRequest) throws Exception {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");
        User user = this.userService.login(email, password);
        user.setToken(this.jwtUtil.generateToken(user.getEmail()));
        return user;
    }

    @PostMapping("/change-password")
    public boolean changePassword(@RequestBody Map<String, String> payload) throws Exception {
        String userId = payload.get("userId");
        String oldPassword = payload.get("oldPassword");
        String newPassword = payload.get("newPassword");
        return this.userService.changePassword(userId, oldPassword, newPassword);
    }
}