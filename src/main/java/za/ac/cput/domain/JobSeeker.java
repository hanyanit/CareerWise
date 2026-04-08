package za.ac.cput.domain;

/**
 * Author: Inga Mbobo, 230711723
 * Date: March 2026
 */

import java.io.File;
import java.util.List;
import java.util.Objects;

public class JobSeeker extends User {

    private String headline;
    private String summary;
    private File resume;
    private List<Skill> skills;
    private List<Education> education;

    private JobSeeker(Builder builder) {
        super(builder);
        this.headline = builder.headline;
        this.summary = builder.summary;
        this.resume = builder.resume;
        this.skills = builder.skills;
        this.education = builder.education;
    }

    public String getHeadline() {
        return headline;
    }

    public String getSummary() {
        return summary;
    }

    public File getResume() {
        return resume;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public List<Education> getEducation() {
        return education;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        JobSeeker that = (JobSeeker) o;
        return Objects.equals(headline, that.headline) &&
                Objects.equals(summary, that.summary) &&
                Objects.equals(resume, that.resume) &&
                Objects.equals(skills, that.skills) &&
                Objects.equals(education, that.education);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                headline, summary,
                resume, skills, education
        );
    }

    @Override
    public String toString() {
        return "JobSeeker{" +
                "headline='" + headline + '\'' +
                ", summary='" + summary + '\'' +
                ", resume=" + resume +
                ", skills=" + skills +
                ", education=" + education +
                "} " + super.toString();
    }

    public static class Builder extends User.Builder {
        private String headline;
        private String summary;
        private File resume;
        private List<Skill> skills;
        private List<Education> education;

        public Builder(String userId, String email, String password) {
            super(userId, email, password);
        }

        // JobSeeker specific methods
        public Builder setHeadline(String headline) {
            this.headline = headline;
            return this;
        }

        public Builder setSummary(String summary) {
            this.summary = summary;
            return this;
        }

        public Builder setResume(File resume) {
            this.resume = resume;
            return this;
        }

        public Builder setSkills(List<Skill> skills) {
            this.skills = skills;
            return this;
        }

        public Builder setEducation(List<Education> education) {
            this.education = education;
            return this;
        }

        // Override User.Builder methods to return JobSeeker.Builder
        @Override
        public Builder firstName(String firstName) {
            super.firstName(firstName);
            return this;
        }

        @Override
        public Builder lastName(String lastName) {
            super.lastName(lastName);
            return this;
        }

        @Override
        public Builder profilePicture(String profilePicture) {
            super.profilePicture(profilePicture);
            return this;
        }

        @Override
        public Builder phoneNumber(String phoneNumber) {
            super.phoneNumber(phoneNumber);
            return this;
        }

        @Override
        public Builder location(String location) {
            super.location(location);
            return this;
        }

        public Builder copy(JobSeeker jobSeeker) {


            this.firstName(jobSeeker.getFirstName())
                    .lastName(jobSeeker.getLastName())
                    .profilePicture(jobSeeker.getProfilePicture())
                    .phoneNumber(jobSeeker.getPhoneNumber())
                    .location(jobSeeker.getLocation());


            this.headline = jobSeeker.getHeadline();
            this.summary = jobSeeker.getSummary();
            this.resume = jobSeeker.getResume();
            this.skills = jobSeeker.getSkills();
            this.education = jobSeeker.getEducation();

            return this;
        }

        public JobSeeker build() {
            return new JobSeeker(this);
        }
    }
}