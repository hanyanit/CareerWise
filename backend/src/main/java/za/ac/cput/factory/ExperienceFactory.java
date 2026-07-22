package za.ac.cput.factory;

import za.ac.cput.domain.Experience;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class ExperienceFactory {

    public static Experience createExperience(String experienceId, String jobTitle, String company,
                                              String location, LocalDate startDate, LocalDate endDate,
                                              String description) {

        if (Helper.isNullOrEmpty(experienceId) ||
                Helper.isNullOrEmpty(jobTitle) ||
                Helper.isNullOrEmpty(company)) {
            return null;
        }

        return Experience.builder()
                .experienceId(experienceId)
                .jobTitle(jobTitle)
                .company(company)
                .location(location)
                .startDate(startDate)
                .endDate(endDate)
                .description(description)
                .build();
    }
}