package za.ac.cput.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Employer;
import za.ac.cput.domain.JobSeeker;
import za.ac.cput.domain.Role;
import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    @Autowired
    public CustomUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        Role resolvedRole = user.getRole();
        if (resolvedRole == null) {
            if (user instanceof Employer) {
                resolvedRole = Role.EMPLOYER;
            } else if (user instanceof JobSeeker) {
                resolvedRole = Role.JOBSEEKER;
            } else {
                resolvedRole = Role.JOBSEEKER;
            }
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        authorities.add(new SimpleGrantedAuthority(resolvedRole.getAuthority()));
        authorities.add(new SimpleGrantedAuthority(resolvedRole.name()));

        if (resolvedRole == Role.JOBSEEKER) {
            authorities.add(new SimpleGrantedAuthority("ROLE_CANDIDATE"));
            authorities.add(new SimpleGrantedAuthority("CANDIDATE"));
        }

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword() != null ? user.getPassword() : "",
                authorities
        );
    }
}
