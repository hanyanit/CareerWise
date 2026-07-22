package za.ac.cput.factory;

import za.ac.cput.domain.Education;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class EducationFactory {
    public static Education createEducation(String educationId, String institution, String degree,
                                            String fieldOfStudy, LocalDate startDate, LocalDate endDate,
                                            String description) {
        if (Helper.isNullOrEmpty(educationId) ||
                Helper.isNullOrEmpty(institution) ||
                Helper.isNullOrEmpty(degree)) {
            return null;
        }

        return Education.builder()
                .educationId(educationId)
                .institution(institution)
                .degree(degree)
                .fieldOfStudy(fieldOfStudy)
                .startDate(startDate)
                .endDate(endDate)
                .description(description)
                .build();
    }
}