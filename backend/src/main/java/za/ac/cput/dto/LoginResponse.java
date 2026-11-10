package za.ac.cput.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.ac.cput.domain.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponse {
    private String userId;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String location;
    private Role role;
    private String token;
    private String message;
}
