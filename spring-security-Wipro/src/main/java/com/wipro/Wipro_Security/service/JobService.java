package com.wipro.Wipro_Security.service;

import com.wipro.Wipro_Security.model.Job;
import com.wipro.Wipro_Security.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public Job updateJob(int id, Job updatedJob) {
        Optional<Job> existingJob = jobRepository.findById(id);
        if (existingJob.isPresent()) {
            Job job = existingJob.get();
            job.setJobTitle(updatedJob.getJobTitle());
            job.setSalary(updatedJob.getSalary());
            job.setLocation(updatedJob.getLocation());
            return jobRepository.save(job);
        }
        return null;
    }

    public void deleteJob(int id) {
        jobRepository.deleteById(id);
    }
}
