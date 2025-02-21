package com.wipro.Wipro_Security.controller;

import com.wipro.Wipro_Security.model.Job;
import com.wipro.Wipro_Security.model.JobApplication;
import com.wipro.Wipro_Security.repository.JobRepository;
import com.wipro.Wipro_Security.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private JobRepository jobRepository; // 🔹 Fix: Added jobRepository

    @Autowired
    private JobApplicationService jobApplicationService;

    // 🔹 Fetch all available jobs
    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> getAllJobs() {
        List<Job> jobs = jobRepository.findAll();
        return ResponseEntity.ok(jobs);
    }

    // 🔹 Fetch job applications for a specific user (by email)
    @GetMapping("/applications/{email}")
    public ResponseEntity<List<JobApplication>> getUserApplications(@PathVariable String email) {
        List<JobApplication> applications = jobApplicationService.getUserApplications(email);
        return ResponseEntity.ok(applications);
    }

    // 🔹 Apply for a job
    @PostMapping("/apply")
    public ResponseEntity<JobApplication> applyForJob(@RequestBody JobApplication application) {
        JobApplication savedApplication = jobApplicationService.applyForJob(application);
        return ResponseEntity.ok(savedApplication);
    }

    // 🔹 Withdraw a job application
    @DeleteMapping("/withdraw/{id}")
    public ResponseEntity<String> withdrawApplication(@PathVariable int id) {
        jobApplicationService.withdrawApplication(id);
        return ResponseEntity.ok("Application withdrawn successfully.");
    }
}
