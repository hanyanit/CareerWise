package za.ac.cput.domain;

import java.util.Date;
import java.util.Objects;

public class Education {
    private String educationId;
    private String institution;
    private String degree;
    private String fieldOfStudy;
    private Date startDate;
    private Date endDate;
    private boolean isCurrent;
    private String description;

    public Education() {
    }

    private Education(Builder builder) {
        this.educationId = builder.educationId;
        this.institution = builder.institution;
        this.degree = builder.degree;
        this.fieldOfStudy = builder.fieldOfStudy;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.isCurrent = builder.isCurrent;
        this.description = builder.description;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Education education = (Education) o;
        return isCurrent == education.isCurrent && Objects.equals(educationId, education.educationId) && Objects.equals(institution, education.institution) && Objects.equals(degree, education.degree) && Objects.equals(fieldOfStudy, education.fieldOfStudy) && Objects.equals(startDate, education.startDate) && Objects.equals(endDate, education.endDate) && Objects.equals(description, education.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(educationId, institution, degree, fieldOfStudy, startDate, endDate, isCurrent, description);
    }

    @Override
    public String toString() {
        return "Education{" +
                "educationId='" + educationId + '\'' +
                ", institution='" + institution + '\'' +
                ", degree='" + degree + '\'' +
                ", fieldOfStudy='" + fieldOfStudy + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", isCurrent=" + isCurrent +
                ", description='" + description + '\'' +
                '}';
    }


    private static  class Builder {
        private String educationId;
        private String institution;
        private String degree;
        private String fieldOfStudy;
        private Date startDate;
        private Date endDate;
        private boolean isCurrent;
        private String description;



        public Builder setEducationId(String educationId) {
            this.educationId = educationId;
            return this;
        }

        public Builder setInstitution(String institution) {
            this.institution = institution;
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

        public Builder setStartDate(Date startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder setEndDate(Date endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder setCurrent(boolean current) {
            isCurrent = current;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder copy(Education education) {
            this.educationId = educationId;
            this.institution = institution;
            this.degree = degree;
            this.fieldOfStudy = fieldOfStudy;
            this.startDate = startDate;
            this.endDate = endDate;
            this.isCurrent = isCurrent;
            this.description = description;
            return this;
        }

        public  Education build() {
            return new Education(this);
        }
    }
}
