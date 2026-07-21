package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "job_seeker")
public class JobSeeker extends User {

    private String headline;
    private String summary;
    private String resumePath;
    private String skills;
    private String education;

    protected JobSeeker() {
        super();
    }

    private JobSeeker(Builder builder) {
        super(builder);
        this.headline = builder.headline;
        this.summary = builder.summary;
        this.resumePath = builder.resumePath;
        this.skills = builder.skills;
        this.education = builder.education;
    }

    public String getHeadline() {
        return headline;
    }

    public String getSummary() {
        return summary;
    }

    public String getResumePath() {
        return resumePath;
    }

    public String getSkills() {
        return skills;
    }

    public String getEducation() {
        return education;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobSeeker that)) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

    @Override
    public String toString() {
        return "JobSeeker{" +
                "userId='" + getUserId() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", headline='" + headline + '\'' +
                ", summary='" + summary + '\'' +
                ", resumePath='" + resumePath + '\'' +
                ", skills='" + skills + '\'' +
                ", education='" + education + '\'' +
                '}';
    }

    public static class Builder extends User.Builder<Builder> {

        private String headline;
        private String summary;
        private String resumePath;
        private String skills;
        private String education;

        public Builder setHeadline(String headline) {
            this.headline = headline;
            return this;
        }

        public Builder setSummary(String summary) {
            this.summary = summary;
            return this;
        }

        public Builder setResumePath(String resumePath) {
            this.resumePath = resumePath;
            return this;
        }

        public Builder setSkills(String skills) {
            this.skills = skills;
            return this;
        }

        public Builder setEducation(String education) {
            this.education = education;
            return this;
        }

        public Builder copy(JobSeeker jobSeeker) {
            super.copy(jobSeeker);

            this.headline = jobSeeker.getHeadline();
            this.summary = jobSeeker.getSummary();
            this.resumePath = jobSeeker.getResumePath();
            this.skills = jobSeeker.getSkills();
            this.education = jobSeeker.getEducation();

            return this;
        }

        @Override
        public JobSeeker build() {
            return new JobSeeker(this);
        }
    }
}
