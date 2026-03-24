package za.ac.cput.factory;

import za.ac.cput.domain.Education;
import za.ac.cput.util.Helper;

import java.time.LocalDate;
import java.util.Date;

public class EducationFactory {
    public static Education createEducation(String educationId, String institution, String degree, String fieldOfStudy,
                                            LocalDate startDate, LocalDate endDate, String description){
        if (Helper.isNullOrEmpty(educationId)){
            return null;
        }

        return new Education.Builder()
                .setEducationId(educationId)
                .setInstitution(institution)
                .setDegree(degree)
                .setFieldOfStudy(fieldOfStudy)
                .setStartDate(startDate)
                .setEndDate(endDate)
                .setDescription(description)
                .build();

    }
}
