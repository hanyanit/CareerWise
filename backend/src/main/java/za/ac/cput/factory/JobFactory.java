package za.ac.cput.factory;

import za.ac.cput.domain.Job;
import za.ac.cput.domain.JobStatus;
import za.ac.cput.util.Helper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JobFactory {

    public static Job createJob(String title, String description,
                                List<String> requirements, List<String> responsibilities,
                                String location, Boolean remoteOption, String salaryRange,
                                String employmentType, LocalDate deadlineDate) {

        if (Helper.isNullOrEmpty(title)) {
            return null;
        }

        return Job.builder()
                .title(title)
                .description(description)
                .requirements(requirements != null ? requirements : new ArrayList<>())
                .responsibilities(responsibilities != null ? responsibilities : new ArrayList<>())
                .location(location)
                .remoteOption(remoteOption != null ? remoteOption : false)
                .salaryRange(salaryRange)
                .employmentType(employmentType)
                .deadlineDate(deadlineDate)
                .status(JobStatus.OPEN)
                .build();
    }
}