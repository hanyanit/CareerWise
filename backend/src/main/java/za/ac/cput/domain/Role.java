package za.ac.cput.domain;

/**
 * Role enumeration defining system user access roles.
 */
public enum Role {
    JOBSEEKER,
    EMPLOYER,
    ADMIN;

    public String getAuthority() {
        return "ROLE_" + this.name();
    }

    /**
     * Resolves a role from a string safely, supporting aliases like CANDIDATE and JOB_SEEKER.
     *
     * @param value input string representing a role
     * @return Role enum or null if unrecognized
     */
    public static Role fromString(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        String normalized = value.trim().toUpperCase();
        if (normalized.equals("CANDIDATE") || normalized.equals("JOB_SEEKER")
                || normalized.equals("ROLE_JOBSEEKER") || normalized.equals("ROLE_CANDIDATE")) {
            return JOBSEEKER;
        }
        if (normalized.equals("EMPLOYER") || normalized.equals("ROLE_EMPLOYER")) {
            return EMPLOYER;
        }
        if (normalized.equals("ADMIN") || normalized.equals("ROLE_ADMIN")) {
            return ADMIN;
        }
        try {
            return Role.valueOf(normalized);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
