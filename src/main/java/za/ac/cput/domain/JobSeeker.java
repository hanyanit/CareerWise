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

//    public JobSeeker(Builder builder) {
//        super(builder);
//    }

    private JobSeeker(JobSeekerBuilder builder) {
        super(builder.userBuilder);
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

    public static class JobSeekerBuilder {

        private final User.Builder userBuilder;

        private String headline;
        private String summary;
        private File resume;
        private List<Skill> skills;
        private List<Education> education;

        public JobSeekerBuilder(String userId, String email, String password) {
            this.userBuilder = new User.Builder(userId, email, password);
        }

        public JobSeekerBuilder firstName(String firstName) {
            this.userBuilder.firstName(firstName);
            return this;
        }

        public JobSeekerBuilder lastName(String lastName) {
            this.userBuilder.lastName(lastName);
            return this;
        }

        public JobSeekerBuilder profilePicture(String profilePicture) {
            this.userBuilder.profilePicture(profilePicture);
            return this;
        }

        public JobSeekerBuilder phoneNumber(String phoneNumber) {
            this.userBuilder.phoneNumber(phoneNumber);
            return this;
        }

        public JobSeekerBuilder location(String location) {
            this.userBuilder.location(location);
            return this;
        }

        public JobSeekerBuilder headline(String headline) {
            this.headline = headline;
            return this;
        }

        public JobSeekerBuilder summary(String summary) {
            this.summary = summary;
            return this;
        }

        public JobSeekerBuilder resume(File resume) {
            this.resume = resume;
            return this;
        }

        public JobSeekerBuilder skills(List<Skill> skills) {
            this.skills = skills;
            return this;
        }

        public JobSeekerBuilder education(List<Education> education) {
            this.education = education;
            return this;
        }

        public JobSeeker.JobSeekerBuilder copy(JobSeeker jobSeeker) {
//            this.userBuilder =userBuilder;
            this.headline = jobSeeker.headline;
            this.summary = jobSeeker.summary;
            this.resume = jobSeeker.resume;
            this.skills = jobSeeker.skills;
            this.education = jobSeeker.education;
            return this;
        }

        public JobSeeker build() {
            userBuilder.build();
            return new JobSeeker(this);
        }
    }
}