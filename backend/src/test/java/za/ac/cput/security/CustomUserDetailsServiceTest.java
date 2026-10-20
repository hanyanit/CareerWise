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
    void loadUserByUsernameNotFoundThrowsException() {
        when(userRepo.findByEmail("missing@careerwise.com")).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () ->
                userDetailsService.loadUserByUsername("missing@careerwise.com"));
    }
}
