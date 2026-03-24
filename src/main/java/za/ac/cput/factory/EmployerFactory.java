package za.ac.cput.factory;

import za.ac.cput.domain.Employer;
import za.ac.cput.util.Helper;

/**
 * EmployerFactory.java
 * Author: Andile Pamela Masina, 221568816
 * Date: 24 March 2026
 */
public class EmployerFactory {

    public static Employer buildEmployer(String companyName, String industry, String companySize, String companyHeadquarters) {

        if (Helper.isNullOrEmpty(companyName) || Helper.isNullOrEmpty(industry)) {
            return null;
        }

        return new Employer.Builder()
                .setCompanyName(companyName)
                .setIndustry(industry)
                .setCompanySize(companySize)
                .setCompanyHeadquarters(companyHeadquarters)
                .build();
    }
}