package com.wipro.Wipro_Security.controller;

import com.wipro.Wipro_Security.model.Job;
import com.wipro.Wipro_Security.model.JobApplication;
import com.wipro.Wipro_Security.repository.JobRepository;
import com.wipro.Wipro_Security.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private JobApplicationService jobApplicationService;

    // 🔹 Fetch all jobs
    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> getAllJobs() {
        return ResponseEntity.ok(jobRepository.findAll());
    }

    // 🔹 Fetch user applications by email
    @GetMapping("/applications/{email}")
    public ResponseEntity<List<JobApplication>> getUserApplications(@PathVariable String email) {
        return ResponseEntity.ok(jobApplicationService.getUserApplications(email));
    }

    // 🔹 Apply for a job (fixing the issue)
    @PostMapping("/apply")
    public ResponseEntity<String> applyForJob(@RequestBody JobApplication application) {
        Optional<Job> jobOptional = jobRepository.findById(application.getJob().getId());

        if (jobOptional.isPresent()) {
            JobApplication savedApplication = jobApplicationService.applyForJob(application.getName(), application.getEmail(), jobOptional.get());
            return ResponseEntity.ok("Application submitted successfully!");
        } else {
            return ResponseEntity.badRequest().body("Invalid Job ID!");
        }
    }

    // 🔹 Withdraw application
    @DeleteMapping("/withdraw/{jobId}/{email}")
    public ResponseEntity<String> withdrawApplication(@PathVariable int jobId, @PathVariable String email) {
        boolean removed = jobApplicationService.withdrawApplication(jobId, email);
        return removed ? ResponseEntity.ok("Application withdrawn.") : ResponseEntity.badRequest().body("No application found!");
    }
}
