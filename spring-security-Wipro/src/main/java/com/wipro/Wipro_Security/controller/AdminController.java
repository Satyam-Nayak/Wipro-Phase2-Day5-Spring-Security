package com.wipro.Wipro_Security.controller;

import com.wipro.Wipro_Security.model.Job;
import com.wipro.Wipro_Security.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private JobService jobService;

    @GetMapping("/jobs")
    public List<Job> getJobs() {
        return jobService.getAllJobs();
    }

    @PostMapping("/jobs")
    public Job createJob(@RequestBody Job job) {
        return jobService.createJob(job);
    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable int id, @RequestBody Job updatedJob) {
        Job job = jobService.updateJob(id, updatedJob);
        return job != null ? ResponseEntity.ok(job) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/jobs/{id}")
    public void deleteJob(@PathVariable int id) {
        jobService.deleteJob(id);
    }
}
