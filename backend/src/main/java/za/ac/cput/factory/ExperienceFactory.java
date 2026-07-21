package za.ac.cput.factory;

import za.ac.cput.domain.Experience;
import za.ac.cput.util.Helper;

public class ExperienceFactory {

    public static Experience createExperience(
            String experienceID,
            String jobTitle,
            String company,
            String location,
            String description) {


        if (Helper.isNullOrEmpty(experienceID) ||
                Helper.isNullOrEmpty(jobTitle) ||
                Helper.isNullOrEmpty(company) ||
                Helper.isNullOrEmpty(location) ||
                Helper.isNullOrEmpty(description)) {

            return null;
        }


        return new Experience.Builder()
                .setExperienceID(experienceID)
                .setJobTitle(jobTitle)
                .setCompany(company)
                .setLocation(location)
                .setDescription(description)
                .build();
    }
}
