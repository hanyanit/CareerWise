package za.ac.cput.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Service.IJobStatsService;
import za.ac.cput.repository.IJobRepository;

import java.time.LocalDate;

@Service
public class JobStatsServiceImpl implements IJobStatsService {
    @Autowired
    private IJobRepository jobRepository;

    @Override
    public int getJobViews(String jobId) {
        return jobRepository.getJobViews(jobId);
    }

    @Override
    public int getNewApplicationsToday(String jobId) {
        LocalDate today = LocalDate.now();
        return jobRepository.getNewApplicationsBetween(
                jobId,
                today.atStartOfDay(),
                today.plusDays(1).atStartOfDay());
    }
}
