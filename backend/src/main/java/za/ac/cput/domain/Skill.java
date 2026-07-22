package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

/**
 * Skill.java - Skill Entity
 * ManyToOne relationship with JobSeeker
 */
@Entity
@Table(name = "skills")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = "jobSeeker")
@ToString(exclude = "jobSeeker")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String skillId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    private int yearsOfExperience = 0;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    /**
     * Many Skills : One JobSeeker
     * Foreign key: job_seeker_id
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_seeker_id", nullable = true)
    private JobSeeker jobSeeker;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}