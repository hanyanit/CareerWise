package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import za.ac.cput.DTO.LoginRequest;
import za.ac.cput.DTO.LoginResponse;
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
    public LoginResponse signUp(@RequestBody User user) throws Exception {
        User created = this.userService.signUp(user);
        String token = this.jwtUtil.generateToken(created.getEmail());
        return LoginResponse.builder()
                .userId(created.getUserId())
                .email(created.getEmail())
                .firstName(created.getFirstName())
                .lastName(created.getLastName())
                .phoneNumber(created.getPhoneNumber())
                .location(created.getLocation())
                .token(token)
                .message("User registered successfully")
                .build();
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) throws Exception {
        User user = this.userService.login(loginRequest.getEmail(), loginRequest.getPassword());
        String token = this.jwtUtil.generateToken(user.getEmail());
        return LoginResponse.builder()
                .userId(user.getUserId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phoneNumber(user.getPhoneNumber())
                .location(user.getLocation())
                .token(token)
                .message("Login successful")
                .build();
    }

    @PostMapping("/change-password")
    public boolean changePassword(@RequestBody Map<String, String> payload) throws Exception {
        String userId = payload.get("userId");
        String oldPassword = payload.get("oldPassword");
        String newPassword = payload.get("newPassword");
        return this.userService.changePassword(userId, oldPassword, newPassword);
    }
}