package Domain;

/**
 * Employer.java
 * Author: Andile Pamela Masina, 221568816
 * Date: 17 March 2026
 */

public class Employer {
    private String companyName;
    private String companyWebsite;
    private String companySize;
    private String industry;
    private String companyLogo;
    private String companyDescription;


    private Employer(Builder builder) {
        this.companyName = builder.companyName;
        this.companyWebsite = builder.companyWebsite;
        this.companySize = builder.companySize;
        this.industry = builder.industry;
        this.companyLogo = builder.companyLogo;
        this.companyDescription = builder.companyDescription;
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

    @Override
    public String toString() {
        return "companyName='" + companyName + '\'' +
                ", industry='" + industry ;
    }


    public static class Builder {
        private String companyName;
        private String companyWebsite;
        private String companySize;
        private String industry;
        private String companyLogo;
        private String companyDescription;

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

        public Builder copy(Employer employer) {
            this.companyName = employer.companyName;
            this.companyWebsite = employer.companyWebsite;
            this.companySize = employer.companySize;
            this.industry = employer.industry;
            this.companyLogo = employer.companyLogo;
            this.companyDescription = employer.companyDescription;
            return this;
        }

        public Employer build() {
            return new Employer(this);
        }
    }
}