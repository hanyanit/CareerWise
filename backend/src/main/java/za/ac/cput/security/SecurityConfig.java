package za.ac.cput.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final UserDetailsService userDetailsService;
    private final CorsConfigurationSource corsConfigurationSource;

    @Autowired
    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter,
                          UserDetailsService userDetailsService,
                          CorsConfigurationSource corsConfigurationSource) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.userDetailsService = userDetailsService;
        this.corsConfigurationSource = corsConfigurationSource;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.configurationSource(corsConfigurationSource))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint((request, response, authException) -> {
                            response.setContentType("application/json");
                            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                            response.getWriter().write("{\"error\":\"Unauthorized\",\"message\":\"" + authException.getMessage() + "\"}");
                        })
                        .accessDeniedHandler((request, response, accessDeniedException) -> {
                            response.setContentType("application/json");
                            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                            response.getWriter().write("{\"error\":\"Forbidden\",\"message\":\"Access denied: insufficient role privileges\"}");
                        })
                )
                .authorizeHttpRequests(auth -> auth
                        // 1. Preflight and static/console endpoints
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .requestMatchers("/error", "/h2-console/**").permitAll()

                        // 2. Authentication & registration endpoints (public)
                        .requestMatchers("/api/users/login", "/api/users/signup").permitAll()
                        .requestMatchers("/api/jobseekers/create", "/api/employers/create").permitAll()

                        // 3. Public read-only endpoints (job browsing, employer profiles, tracking views)
                        .requestMatchers(HttpMethod.GET, "/api/jobs/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/jobs/*/view", "/api/jobseekers/*/view").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/employers/read/**", "/api/employers/getAll").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/jobseekers/*/resume").permitAll()

                        // 4. Employer role-restricted endpoints
                        .requestMatchers(HttpMethod.POST, "/api/jobs/create").hasAnyRole("EMPLOYER", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/jobs/update").hasAnyRole("EMPLOYER", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/jobs/delete/**").hasAnyRole("EMPLOYER", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/employers/update").hasAnyRole("EMPLOYER", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/employers/delete/**").hasAnyRole("EMPLOYER", "ADMIN")
                        .requestMatchers("/api/applications/job/**").hasAnyRole("EMPLOYER", "ADMIN")
                        .requestMatchers("/api/applications/update-status", "/applications/*/status").hasAnyRole("EMPLOYER", "ADMIN")

                        // 5. JobSeeker / Candidate role-restricted endpoints
                        .requestMatchers("/api/applications/apply").hasAnyRole("JOBSEEKER", "CANDIDATE")
                        .requestMatchers("/api/applications/jobseeker/**").hasAnyRole("JOBSEEKER", "CANDIDATE")
                        .requestMatchers("/api/saved-jobs/**").hasAnyRole("JOBSEEKER", "CANDIDATE")
                        .requestMatchers(HttpMethod.PUT, "/api/jobseekers/update", "/api/jobseekers/profile").hasAnyRole("JOBSEEKER", "CANDIDATE")
                        .requestMatchers(HttpMethod.POST, "/api/jobseekers/*/resume").hasAnyRole("JOBSEEKER", "CANDIDATE")
                        .requestMatchers(HttpMethod.DELETE, "/api/jobseekers/*/resume").hasAnyRole("JOBSEEKER", "CANDIDATE")
                        .requestMatchers("/api/skills/**").hasAnyRole("JOBSEEKER", "CANDIDATE")
                        .requestMatchers("/api/educations/**").hasAnyRole("JOBSEEKER", "CANDIDATE")
                        .requestMatchers("/api/experiences/**").hasAnyRole("JOBSEEKER", "CANDIDATE")

                        // 6. Common authenticated user endpoints
                        .requestMatchers("/api/users/change-password").authenticated()
                        .requestMatchers("/api/notifications/**").authenticated()
                        .requestMatchers(HttpMethod.GET, "/api/jobseekers/read/**").authenticated()
                        .requestMatchers(HttpMethod.GET, "/api/jobseekers/getAll").authenticated()
                        .requestMatchers("/api/applications/read/**", "/api/applications/getAll").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/api/applications/delete/**").authenticated()

                        // 7. Catch-all for any other request
                        .anyRequest().authenticated()
                )
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        // Allow H2 console frames 
        http.headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));

        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            private final BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

            @Override
            public String encode(CharSequence rawPassword) {
                if (rawPassword == null) return null;
                String raw = rawPassword.toString();
                if (raw.startsWith("$2a$") || raw.startsWith("$2b$") || raw.startsWith("$2y$")) {
                    return raw;
                }
                return bcrypt.encode(rawPassword);
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                if (rawPassword == null || encodedPassword == null) return false;
                if (rawPassword.toString().equals(encodedPassword)) {
                    return true;
                }
                if (encodedPassword.startsWith("$2a$") || encodedPassword.startsWith("$2b$") || encodedPassword.startsWith("$2y$")) {
                    return bcrypt.matches(rawPassword, encodedPassword);
                }
                return false;
            }
        };
    }
}
