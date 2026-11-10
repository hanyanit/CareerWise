package za.ac.cput.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

    @Test
    void testGetAuthority() {
        assertEquals("ROLE_JOBSEEKER", Role.JOBSEEKER.getAuthority());
        assertEquals("ROLE_EMPLOYER", Role.EMPLOYER.getAuthority());
        assertEquals("ROLE_ADMIN", Role.ADMIN.getAuthority());
    }

    @Test
    void testFromStringExact() {
        assertEquals(Role.JOBSEEKER, Role.fromString("JOBSEEKER"));
        assertEquals(Role.EMPLOYER, Role.fromString("EMPLOYER"));
        assertEquals(Role.ADMIN, Role.fromString("ADMIN"));
    }

    @Test
    void testFromStringAliases() {
        assertEquals(Role.JOBSEEKER, Role.fromString("candidate"));
        assertEquals(Role.JOBSEEKER, Role.fromString("CANDIDATE"));
        assertEquals(Role.JOBSEEKER, Role.fromString("job_seeker"));
        assertEquals(Role.JOBSEEKER, Role.fromString("ROLE_JOBSEEKER"));
        assertEquals(Role.JOBSEEKER, Role.fromString("ROLE_CANDIDATE"));

        assertEquals(Role.EMPLOYER, Role.fromString("role_employer"));
        assertEquals(Role.ADMIN, Role.fromString("role_admin"));
    }

    @Test
    void testFromStringInvalid() {
        assertNull(Role.fromString(null));
        assertNull(Role.fromString(""));
        assertNull(Role.fromString("   "));
        assertNull(Role.fromString("UNKNOWN_ROLE"));
    }
}
