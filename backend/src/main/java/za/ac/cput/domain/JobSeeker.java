package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 * JobSeeker.java - JobSeeker Entity (extends User)
 * Has OneToMany relationships with Skill, Experience, and Education
 * Cascade delete enabled for all collections
 */
@Entity
@Table(name = "job_seekers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder  // Changed from @Builder to @SuperBuilder
@EqualsAndHashCode(callSuper = true, exclude = {"skills", "experiences", "educations"})
@ToString(callSuper = true, exclude = {"skills", "experiences", "educations"})
public class JobSeeker extends User {

    private String headline;
    private String summary;
    private String resumePath;

    /**
     * One JobSeeker : Many Skills
     * Cascade: Delete all skills if job seeker is deleted
     * orphanRemoval: Delete skill if removed from list
     */
    @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    private List<Skill> skills = new ArrayList<>();

    /**
     * One JobSeeker : Many Experiences
     * Cascade: Delete all experiences if job seeker is deleted
     * orphanRemoval: Delete experience if removed from list
     */
    @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    private List<Experience> experiences = new ArrayList<>();

    /**
     * One JobSeeker : Many Educations
     * Cascade: Delete all educations if job seeker is deleted
     * orphanRemoval: Delete education if removed from list
     */
    @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    private List<Education> educations = new ArrayList<>();
}