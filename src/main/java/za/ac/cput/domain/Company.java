//package za.ac.cput.domain;
//
///**
// * Company.java
// * Author: Andile Pamela Masina
// * Date: 17 March 2026
// */
//public class Company {
//    private String companyId;
//    private String name;
//    private String description;
//    private String industry;
//    private String size;
//    private int foundedYear;
//    private String headquarters;
//    private String website;
//    private String logo;
//
//
//
//    private Company(Builder builder) {
//        this.companyId = builder.companyId;
//        this.name = builder.name;
//        this.description = builder.description;
//        this.industry = builder.industry;
//        this.size = builder.size;
//        this.foundedYear = builder.foundedYear;
//        this.headquarters = builder.headquarters;
//        this.website = builder.website;
//        this.logo = builder.logo;
//    }
//
//
//    public String getCompanyId() {
//        return companyId;
//    }
//    public String getName() {
//        return name;
//    }
//    public String getDescription() {
//        return description;
//    }
//    public String getIndustry() {
//        return industry;
//    }
//    public String getSize() {
//        return size;
//    }
//    public int getFoundedYear() {
//        return foundedYear;
//    }
//    public String getHeadquarters() {
//        return headquarters;
//    }
//    public String getWebsite() {
//        return website;
//    }
//    public String getLogo() {
//        return logo;
//    }
//
//    @Override
//    public String toString() {
//        return
//                "companyId='" + companyId + '\'' +
//                ", name='" + name ;
//    }
//
//    public static class Builder {
//        private String companyId;
//        private String name;
//        private String description;
//        private String industry;
//        private String size;
//        private int foundedYear;
//        private String headquarters;
//        private String website;
//        private String logo;
//
//        public Builder setCompanyId(String companyId) {
//            this.companyId = companyId;
//            return this;
//        }
//
//        public Builder setName(String name) {
//            this.name = name;
//            return this;
//        }
//
//        public Builder setDescription(String description) {
//            this.description = description;
//            return this;
//        }
//
//        public Builder setIndustry(String industry) {
//            this.industry = industry;
//            return this;
//        }
//
//        public Builder setSize(String size) {
//            this.size = size;
//            return this;
//        }
//
//        public Builder setFoundedYear(int foundedYear) {
//            this.foundedYear = foundedYear;
//            return this;
//        }
//
//        public Builder setHeadquarters(String headquarters) {
//            this.headquarters = headquarters;
//            return this;
//        }
//
//        public Builder setWebsite(String website) {
//            this.website = website;
//            return this;
//        }
//
//        public Builder setLogo(String logo) {
//            this.logo = logo;
//            return this;
//        }
//
//        public Builder copy(Company company) {
//            this.companyId = company.companyId;
//            this.name = company.name;
//            this.description = company.description;
//            this.industry = company.industry;
//            this.size = company.size;
//            this.foundedYear = company.foundedYear;
//            this.headquarters = company.headquarters;
//            this.website = company.website;
//            this.logo = company.logo;
//            return this;
//        }
//
//        public Company build() {
//            return new Company(this);
//        }
//    }
//}