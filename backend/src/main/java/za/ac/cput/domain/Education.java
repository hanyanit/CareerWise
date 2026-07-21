package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Author: Phumlani Mdlalo, 241093813
 * Date: March 2026
 */


@Entity
@Table(name = "Education")
public class Education {

    @Id
    @GeneratedValue
    private int id;

    private String educationId;
    private String institution;
    private String degree;
    private String fieldOfStudy;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;

    private Education(Builder builder) {
        this.educationId = builder.educationId;
        this.institution = builder.institution;
        this.degree = builder.degree;
        this.fieldOfStudy = builder.fieldOfStudy;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.description = builder.description;
    }

    protected Education(){

    }
    public String getEducationId() {return educationId; }
    public String getInstitution() { return institution; }
    public String getDegree() { return degree; }
    public String getFieldOfStudy() { return fieldOfStudy; }
    public LocalDate   getStartDate() { return startDate; }
    public LocalDate   getEndDate() { return endDate; }
    public String getDescription() { return description; }

    // ── equals / hashCode / toString ─────────────────────────────────────────

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Education education = (Education) o;
        return Objects.equals(educationId, education.educationId) && Objects.equals(institution, education.institution) && Objects.equals(degree, education.degree) && Objects.equals(fieldOfStudy, education.fieldOfStudy) && Objects.equals(startDate, education.startDate) && Objects.equals(endDate, education.endDate) && Objects.equals(description, education.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(educationId, institution, degree, fieldOfStudy, startDate, endDate, description);
    }

    @Override
    public String toString() {
        return "Education{"
                + "educationId='"  + educationId  + '\''
                + ", institution='" + institution  + '\''
                + ", degree='"      + degree        + '\''
                + ", fieldOfStudy='" + fieldOfStudy + '\''
                + ", startDate="    + startDate
                + ", endDate="      + endDate
                + ", description='" + description  + '\''
                + '}';
    }

    public static class Builder {

        private String educationId;
        private String institution;
        private String degree;
        private String fieldOfStudy;
        private LocalDate startDate;
        private LocalDate endDate;
        private String description;

        public Builder setEducationId(String educationId) {
            this.educationId = educationId;
            return this;
        }
        public Builder setInstitution(String institution) {
            this.institution  = institution;
            return this;
        }
        public Builder setDegree(String degree) {
            this.degree = degree;
            return this;
        }
        public Builder setFieldOfStudy(String fieldOfStudy) {
            this.fieldOfStudy = fieldOfStudy;
            return this;
        }
        public Builder setStartDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }
        public Builder setEndDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }
        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder copy(Education education) {
            this.educationId  = education.educationId;
            this.institution  = education.institution;
            this.degree       = education.degree;
            this.fieldOfStudy = education.fieldOfStudy;
            this.startDate    = education.startDate;
            this.endDate      = education.endDate;
            this.description  = education.description;
            return this;
        }

        public Education build() {
            return new Education(this);
        }
    }
}