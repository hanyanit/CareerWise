package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Service.IJobApplicationService;
import za.ac.cput.domain.JobApplication;

@RestController
@RequestMapping("/applications/{id}/status")
public class ApplicationController {
    @Autowired
    private IJobApplicationService applicationService;

    @PutMapping
    public ResponseEntity<JobApplication> updateStatus(
            @PathVariable String id,
            @RequestBody UpdateStatusRequest request
    ) {
        return ResponseEntity.ok(applicationService.updateStatus(id, request.getStatus()));
    }

    public static class UpdateStatusRequest {
        private String status;

        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
    }
}
