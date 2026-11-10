package za.ac.cput.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepo;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomUserDetailsServiceTest {

    private UserRepo userRepo;
    private CustomUserDetailsService userDetailsService;

    @BeforeEach
    void setUp() {
        userRepo = mock(UserRepo.class);
        userDetailsService = new CustomUserDetailsService(userRepo);
    }

    @Test
    void loadUserByUsernameSuccess() {
        User user = User.builder()
                .userId("u-123")
                .email("test@careerwise.com")
                .password("encodedPassword")
                .firstName("Test")
                .lastName("User")
                .build();

        when(userRepo.findByEmail("test@careerwise.com")).thenReturn(Optional.of(user));

        UserDetails userDetails = userDetailsService.loadUserByUsername("test@careerwise.com");
        assertNotNull(userDetails);
        assertEquals("test@careerwise.com", userDetails.getUsername());
        assertEquals("encodedPassword", userDetails.getPassword());
        assertTrue(userDetails.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_USER")));
    }

    @Test
    void loadJobSeekerRoleAuthorities() {
        za.ac.cput.domain.JobSeeker jobSeeker = za.ac.cput.domain.JobSeeker.builder()
                .userId("js-1")
                .email("seeker@careerwise.com")
                .password("encoded")
                .role(za.ac.cput.domain.Role.JOBSEEKER)
                .build();

        when(userRepo.findByEmail("seeker@careerwise.com")).thenReturn(Optional.of(jobSeeker));

        UserDetails userDetails = userDetailsService.loadUserByUsername("seeker@careerwise.com");
        assertNotNull(userDetails);
        assertTrue(userDetails.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_JOBSEEKER")));
        assertTrue(userDetails.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_CANDIDATE")));
        assertTrue(userDetails.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_USER")));
    }

    @Test
    void loadEmployerRoleAuthorities() {
        za.ac.cput.domain.Employer employer = za.ac.cput.domain.Employer.builder()
                .userId("emp-1")
                .email("boss@corp.com")
                .password("encoded")
                .role(za.ac.cput.domain.Role.EMPLOYER)
                .build();

        when(userRepo.findByEmail("boss@corp.com")).thenReturn(Optional.of(employer));

        UserDetails userDetails = userDetailsService.loadUserByUsername("boss@corp.com");
        assertNotNull(userDetails);
        assertTrue(userDetails.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_EMPLOYER")));
        assertTrue(userDetails.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_USER")));
        assertFalse(userDetails.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_JOBSEEKER")));
    }

    @Test
    void loadUserByUsernameNotFoundThrowsException() {
        when(userRepo.findByEmail("missing@careerwise.com")).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () ->
                userDetailsService.loadUserByUsername("missing@careerwise.com"));
    }
}
