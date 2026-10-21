package za.ac.cput.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepo;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public User signUp(User user) throws Exception {
        if (userRepo.existsByEmail(user.getEmail())) {
            throw new Exception("email already exists");
        }
        if (user.getPassword() != null && !user.getPassword().isBlank()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return userRepo.save(user);
    }

    public User login(String email, String password) throws Exception {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new Exception("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new Exception("Invalid password");
        }

        return user;
    }

    public boolean changePassword(String userId, String oldPassword, String newPassword) throws Exception {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new Exception("User not found"));

        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            throw new Exception("Current password does not match");
        }

        user.setPassword(passwordEncoder.encode(newPassword));
        userRepo.save(user);
        return true;
    }
}
