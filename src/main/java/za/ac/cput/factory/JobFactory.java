package za.ac.cput.factory;

import za.ac.cput.domain.Job;
import za.ac.cput.util.Helper;

import java.util.Date;
import java.util.List;

public class JobFactory {

    public static Job createJob(String jobId, String title, String description,List<String> requirements, List<String> responsibilities, String location,
                                Boolean remoteOption, String salaryRange, EmploymentType employmentType, Date deadlineDate, int view){

        if (Helper.isNullOrEmpty(jobId) || Helper.isNullOrEmpty(title)) {
            return null;
        }

        return new Job.Builder()
                .setJobId(jobId)
                .setTitle(title)
                .setDescription(description)
                .setRequirements(requirements)
                .setResponsibilities(responsibilities)
                .setLocation(location)
                .setRemoteOption(remoteOption)
                .setSalaryRange(salaryRange)
                .setEmploymentType(employmentType)
                .setDeadlineDate(deadlineDate)
                .setView(view)
                .build();
    }
}
