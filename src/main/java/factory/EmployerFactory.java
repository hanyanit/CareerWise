package factory;

import Domain.Employer;
import java.util.UUID;

/**
 * Author: Andile Pamela Masina, 221568816
 * Date: 17 March 2026
 */
public class EmployerFactory {

    public static Employer buildEmployer(String companyName, String industry, String companySize) {
        if (companyName == null || companyName.isEmpty() || industry == null || industry.isEmpty()) {
            return null;
        }

        return new Employer.Builder()
                .setCompanyName(companyName)
                .setIndustry(industry)
                .setCompanySize(companySize)
                .build();
    }
}