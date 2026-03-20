package za.ac.cput.factory;

import za.ac.cput.domain.Experience;
import za.ac.cput.util.Helper;

import java.util.Date;

public class ExperienceFactory {
    public static Experience createExperience(String experienceID, String jobTitle, String company, String location, Date startDate, Date endDate, String description){

        if (Helper.isNullOrEmpty(experienceID) || Helper.isNullOrEmpty(jobTitle)) {
            return null;
        }

        return new Experience.Builder()
                .setExperienceID(experienceID)
                .setJobTitle(jobTitle)
                .setCompany(company)
                .setLocation(location)
                .setStartDate(startDate)
                .setEndDate(endDate)
                .setDescription(description)
                .build();
    }
}
