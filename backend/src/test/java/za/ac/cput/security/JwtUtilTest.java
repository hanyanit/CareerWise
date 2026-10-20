package za.ac.cput.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JwtUtilTest {

    private JwtUtil jwtUtil;

    @BeforeEach
    void setUp() {
        jwtUtil = new JwtUtil();
        ReflectionTestUtils.setField(
                jwtUtil,
                "secret",
                "CareerWiseSecretKeyForJwtAuthenticationTokenSigningMustBeLongEnough2026!"
        );
        ReflectionTestUtils.setField(jwtUtil, "expirationTime", 3600000L); // 1 hour
    }

    @Test
    void generateAndExtractUsername() {
        String email = "testuser@careerwise.com";
        String token = jwtUtil.generateToken(email);

        assertNotNull(token);
        assertFalse(token.isBlank());

        String extractedUsername = jwtUtil.extractUsername(token);
        assertEquals(email, extractedUsername);
    }

    @Test
    void validateTokenWithCorrectUsername() {
        String email = "candidate@careerwise.com";
        String token = jwtUtil.generateToken(email);

        assertTrue(jwtUtil.validateToken(token, email));
        assertFalse(jwtUtil.validateToken(token, "otheruser@careerwise.com"));
    }

    @Test
    void generateTokenWithCustomClaims() {
        String email = "employer@careerwise.com";
        Map<String, Object> claims = Map.of("role", "EMPLOYER", "company", "TechCorp");

        String token = jwtUtil.generateToken(email, claims);
        assertNotNull(token);

        assertEquals(email, jwtUtil.extractUsername(token));
        assertEquals("EMPLOYER", jwtUtil.extractClaim(token, c -> c.get("role")));
        assertEquals("TechCorp", jwtUtil.extractClaim(token, c -> c.get("company")));
    }

    @Test
    void tokenExpiredReturnsTrueWhenExpired() {
        JwtUtil shortLivedJwt = new JwtUtil();
        ReflectionTestUtils.setField(
                shortLivedJwt,
                "secret",
                "CareerWiseSecretKeyForJwtAuthenticationTokenSigningMustBeLongEnough2026!"
        );
        ReflectionTestUtils.setField(shortLivedJwt, "expirationTime", -1000L); // already expired

        String token = shortLivedJwt.generateToken("expired@careerwise.com");
        assertTrue(shortLivedJwt.isTokenExpired(token));
        assertFalse(shortLivedJwt.validateToken(token, "expired@careerwise.com"));
    }
}
