package factory;

import Domain.Company;
import java.util.UUID;

/**
 * Author: Andile Pamela Masina, 221568816
 * Date: 17 March 2026
 */
public class CompanyFactory {

    public static Company buildCompany(String name, String industry, String location) {

        if (name == null || name.isEmpty() || industry == null || industry.isEmpty()) {
            return null;
        }


        String companyId = UUID.randomUUID().toString();

        return new Company.Builder()
                .setCompanyId(companyId)
                .setName(name)
                .setIndustry(industry)
                .setHeadquarters(location)
                .build();
    }
}