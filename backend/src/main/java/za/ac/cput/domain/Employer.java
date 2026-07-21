package za.ac.cput.domain;

import jakarta.persistence.Entity;

import java.util.Objects;

/**
 * Employer.java
 * Author: Andile Pamela Masina, 221568816
 * Date: 17 March 2026
 */
@Entity
public class Employer extends User {

    private String companyName;
    private String companyWebsite;
    private String companySize;
    private String industry;
    private String companyLogo;
    private String companyDescription;
    private String companyHeadquarters;

    protected Employer() {
    }

    private Employer(Builder builder) {
        super(builder);

        this.companyName = builder.companyName;
        this.companyWebsite = builder.companyWebsite;
        this.companySize = builder.companySize;
        this.industry = builder.industry;
        this.companyLogo = builder.companyLogo;
        this.companyDescription = builder.companyDescription;
        this.companyHeadquarters = builder.companyHeadquarters;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public String getCompanySize() {
        return companySize;
    }

    public String getIndustry() {
        return industry;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public String getCompanyHeadquarters() {
        return companyHeadquarters;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "companyName='" + companyName + '\'' +
                ", industry='" + industry + '\'' +
                ", headquarters='" + companyHeadquarters + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employer employer)) return false;
        if (!super.equals(o)) return false;

        return Objects.equals(companyName, employer.companyName) &&
                Objects.equals(companyWebsite, employer.companyWebsite) &&
                Objects.equals(companySize, employer.companySize) &&
                Objects.equals(industry, employer.industry) &&
                Objects.equals(companyLogo, employer.companyLogo) &&
                Objects.equals(companyDescription, employer.companyDescription) &&
                Objects.equals(companyHeadquarters, employer.companyHeadquarters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                companyName,
                companyWebsite,
                companySize,
                industry,
                companyLogo,
                companyDescription,
                companyHeadquarters
        );
    }

    public static class Builder extends User.Builder<Builder> {

        private String companyName;
        private String companyWebsite;
        private String companySize;
        private String industry;
        private String companyLogo;
        private String companyDescription;
        private String companyHeadquarters;

        public Builder setCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder setCompanyWebsite(String companyWebsite) {
            this.companyWebsite = companyWebsite;
            return this;
        }

        public Builder setCompanySize(String companySize) {
            this.companySize = companySize;
            return this;
        }

        public Builder setIndustry(String industry) {
            this.industry = industry;
            return this;
        }

        public Builder setCompanyLogo(String companyLogo) {
            this.companyLogo = companyLogo;
            return this;
        }

        public Builder setCompanyDescription(String companyDescription) {
            this.companyDescription = companyDescription;
            return this;
        }

        public Builder setCompanyHeadquarters(String companyHeadquarters) {
            this.companyHeadquarters = companyHeadquarters;
            return this;
        }

        public Builder copy(Employer employer) {
            super.copy(employer);

            this.companyName = employer.getCompanyName();
            this.companyWebsite = employer.getCompanyWebsite();
            this.companySize = employer.getCompanySize();
            this.industry = employer.getIndustry();
            this.companyLogo = employer.getCompanyLogo();
            this.companyDescription = employer.getCompanyDescription();
            this.companyHeadquarters = employer.getCompanyHeadquarters();

            return this;
        }

        @Override
        public Employer build() {
            return new Employer(this);
        }
    }
}
