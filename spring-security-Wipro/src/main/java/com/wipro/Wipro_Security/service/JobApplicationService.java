package com.wipro.Wipro_Security.service;

import com.wipro.Wipro_Security.model.JobApplication;
import com.wipro.Wipro_Security.repository.JobApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationService {
    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    public List<JobApplication> getUserApplications(String email) {
        return jobApplicationRepository.findByEmail(email);
    }

    public JobApplication applyForJob(JobApplication application) {
        return jobApplicationRepository.save(application);
    }

    public void withdrawApplication(int id) {
        jobApplicationRepository.deleteById(id);
    }
}
