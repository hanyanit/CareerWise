package za.ac.cput.domain;

import java.util.Date;
import java.util.Objects;

public class Experience {
    private String experienceID;
    private String jobTitle;
    private String company;
    private String location;
    private Date startDate;
    private Date endDate;
    private String description;

    public Experience(Builder builder) {
        this.experienceID = builder.experienceID;
        this.jobTitle = builder.jobTitle;
        this.company = builder.company;
        this.location = builder.location;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.description = builder.description;
    }

    public String getExperienceID() {
        return experienceID;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Experience that = (Experience) o;
        return Objects.equals(experienceID, that.experienceID) && Objects.equals(jobTitle, that.jobTitle) && Objects.equals(company, that.company) && Objects.equals(location, that.location) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(experienceID, jobTitle, company, location, startDate, endDate, description);
    }

    @Override
    public String toString() {
        return "Experience{" +
                "experienceID='" + experienceID + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", company='" + company + '\'' +
                ", location='" + location + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                '}';
    }

    public static class Builder{
        private String experienceID;
        private String jobTitle;
        private String company;
        private String location;
        private Date startDate;
        private Date endDate;
        private String description;

        public Builder setExperienceID(String experienceID) {
            this.experienceID = experienceID;
            return this;
        }

        public Builder setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
            return this;
        }

        public Builder setCompany(String company) {
            this.company = company;
            return this;
        }

        public Builder setLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder setStartDate(Date startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder setEndDate(Date endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder copy(Experience experience){
            this.experienceID = experience.experienceID;
            this.jobTitle = experience.jobTitle;
            this.company = experience.company;
            this.location = experience.location;
            this.startDate = experience.startDate;
            this.endDate = experience.endDate;
            this.description = experience.description;
            return this;
        }

        public Experience build(){
            return new Experience(this);
        }
    }
}
