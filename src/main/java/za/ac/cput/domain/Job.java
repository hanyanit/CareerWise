package za.ac.cput.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Job {

    private final String       jobId;
    private final String       title;
    private final String       description;
    private final List<String> requirements;
    private final List<String> responsibilities;
    private final String       location;
    private final Boolean      remoteOption;
    private final String       salaryRange;
    private final String       employmentType;
    private final LocalDate         deadlineDate;
    private final String       status;

    private Job(Builder builder) {
        this.jobId = builder.jobId;
        this.title = builder.title;
        this.description = builder.description;
        this.requirements = builder.requirements;
        this.responsibilities = builder.responsibilities;
        this.location = builder.location;
        this.remoteOption = builder.remoteOption;
        this.salaryRange = builder.salaryRange;
        this.employmentType = builder.employmentType;
        this.deadlineDate = builder.deadlineDate;
        this.status = builder.status;
    }

    public String getJobId() { return jobId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public List<String> getRequirements() { return requirements; }
    public List<String> getResponsibilities() { return responsibilities; }
    public String getLocation() { return location; }
    public Boolean getRemoteOption() { return remoteOption; }
    public String getSalaryRange() { return salaryRange; }
    public String getEmploymentType() { return employmentType; }
    public LocalDate getDeadlineDate() { return deadlineDate; }
    public String getStatus() { return status; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return Objects.equals(jobId, job.jobId) && Objects.equals(title, job.title) && Objects.equals(description, job.description) && Objects.equals(requirements, job.requirements) && Objects.equals(responsibilities, job.responsibilities) && Objects.equals(location, job.location) && Objects.equals(remoteOption, job.remoteOption) && Objects.equals(salaryRange, job.salaryRange) && Objects.equals(employmentType, job.employmentType) && Objects.equals(deadlineDate, job.deadlineDate) && Objects.equals(status, job.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, title, description, requirements, responsibilities, location, remoteOption, salaryRange, employmentType, deadlineDate, status);
    }

    @Override
    public String toString() {
        return "Job{"
                + "jobId='"           + jobId            + '\''
                + ", title='"         + title             + '\''
                + ", description='"   + description       + '\''
                + ", requirements="   + requirements
                + ", responsibilities=" + responsibilities
                + ", location='"      + location          + '\''
                + ", remoteOption="   + remoteOption
                + ", salaryRange='"   + salaryRange       + '\''
                + ", employmentType='" + employmentType   + '\''
                + ", deadlineDate="   + deadlineDate
                + ", status='"        + status            + '\''
                + '}';
    }

    public static class Builder {

        private String jobId;
        private String title;
        private String description;
        private List<String> requirements;
        private List<String> responsibilities;
        private String location;
        private Boolean remoteOption;
        private String salaryRange;
        private String employmentType;
        private LocalDate deadlineDate;
        private String status;

        public Builder setJobId(String jobId){
            this.jobId = jobId;
            return this;
        }

        public Builder setTitle(String title){
            this.title = title;
            return this;
        }
        public Builder setDescription(String description){
            this.description = description;
            return this;
        }
        public Builder setRequirements(List<String> requirements){
            this.requirements = requirements;
            return this;
        }
        public Builder setResponsibilities(List<String> responsibilities){
            this.responsibilities = responsibilities;
            return this;
        }
        public Builder setLocation(String location){
            this.location = location;
            return this;
        }
        public Builder setRemoteOption(Boolean remoteOption){
            this.remoteOption = remoteOption;
            return this;
        }
        public Builder setSalaryRange(String salaryRange){
            this.salaryRange = salaryRange;
            return this;
        }
        public Builder setEmploymentType(String employmentType){
            this.employmentType = employmentType;
            return this;
        }
        public Builder setDeadlineDate(LocalDate deadlineDate){
            this.deadlineDate = deadlineDate;
            return this;
        }
        public Builder setStatus(String status){
            this.status = status;
            return this;
        }

        public Builder copy(Job job) {
            this.jobId = job.jobId;
            this.title = job.title;
            this.description = job.description;
            this.requirements = job.requirements;
            this.responsibilities = job.responsibilities;
            this.location = job.location;
            this.remoteOption = job.remoteOption;
            this.salaryRange = job.salaryRange;
            this.employmentType = job.employmentType;
            this.deadlineDate = job.deadlineDate;
            this.status = job.status;
            return this;
        }

        public Job build() {
            return new Job(this);
        }
    }
}