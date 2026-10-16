package za.ac.cput.Service;

public interface IJobStatsService {
    int getJobViews(String jobId);
    int getNewApplicationsToday(String jobId);
}
