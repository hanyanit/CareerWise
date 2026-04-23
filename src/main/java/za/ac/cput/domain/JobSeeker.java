package za.ac.cput.domain;

import java.util.List;
import java.util.Objects;

public class JobSeeker extends User {

    private String headline;
    private String summary;
    private String resumePath;
    private List<Skill> skills;
    private List<Education> education;

    protected JobSeeker() {
        super();
    }

    private JobSeeker(JobSeekerBuilder builder) {
        super(builder.userBuilder);
        this.headline = builder.headline;
        this.summary = builder.summary;
        this.resumePath = builder.resumePath;
        this.skills = builder.skills;
        this.education = builder.education;
    }


    public String getHeadline() { return headline; }
    public String getSummary() { return summary; }
    public String getResumePath() { return resumePath; }
    public List<Skill> getSkills() { return skills; }
    public List<Education> getEducation() { return education; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobSeeker)) return false;
        if (!super.equals(o)) return false;
        JobSeeker that = (JobSeeker) o;
        return Objects.equals(getUserId(), that.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId());
    }
    
    @Override
    public String toString() {
        return "JobSeeker{" +
                "userId='" + getUserId() + '\'' +
                ", name='" + getFirstName() + " " + getLastName() + '\'' +
                ", headline='" + headline + '\'' +
                ", summary='" + summary + '\'' +
                ", resumePath='" + resumePath + '\'' +
                "} " + super.toString();
    }

    // Builder design pattern
    public static class JobSeekerBuilder {

        private final User.Builder userBuilder;

        private String headline;
        private String summary;
        private String resumePath;
        private List<Skill> skills;
        private List<Education> education;

        public JobSeekerBuilder(String userId, String email, String password) {
            this.userBuilder = new User.Builder(userId, email, password);
        }

        // User fields
        public JobSeekerBuilder firstName(String firstName) {
            userBuilder.setFirstName(firstName);
            return this;
        }

        public JobSeekerBuilder lastName(String lastName) {
            userBuilder.setLastName(lastName);
            return this;
        }

        public JobSeekerBuilder profilePicture(String profilePicture) {
            userBuilder.setProfilePicture(profilePicture);
            return this;
        }

        public JobSeekerBuilder phoneNumber(String phoneNumber) {
            userBuilder.setPhoneNumber(phoneNumber);
            return this;
        }

        public JobSeekerBuilder location(String location) {
            userBuilder.setLocation(location);
            return this;
        }

        // JobSeeker fields
        public JobSeekerBuilder headline(String headline) {
            this.headline = headline;
            return this;
        }

        public JobSeekerBuilder summary(String summary) {
            this.summary = summary;
            return this;
        }

        public JobSeekerBuilder resumePath(String resumePath) {
            this.resumePath = resumePath;
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

        public JobSeeker build() {
            return new JobSeeker(this);
        }
    }
}