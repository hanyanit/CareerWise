package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.Service.IJobService;
import za.ac.cput.Service.IJobStatsService;
import za.ac.cput.domain.Job;

@RestController
@RequestMapping("/api/jobs/{id}/stats")
public class JobStatsController {

    @Autowired
    private IJobStatsService statsService;

    @Autowired
    private IJobService jobService;

    @GetMapping
    public ResponseEntity<?> getStats(@PathVariable String id) {
        Job job = jobService.read(id);
        if (job == null) return ResponseEntity.notFound().build();

        int views = statsService.getJobViews(id);
        int newApplications = statsService.getNewApplicationsToday(id);

        return ResponseEntity.ok(
                new JobStatsDTO(
                        views,
                        newApplications
                )
        );
    }
}

class JobStatsDTO {
    private final int views;
    private final int newApplicationsToday;

    public JobStatsDTO(int views, int newApplicationsToday) {
        this.views = views;
        this.newApplicationsToday = newApplicationsToday;
    }

    // Getters
    public int getViews() { return views; }
    public int getNewApplicationsToday() { return newApplicationsToday; }
}
