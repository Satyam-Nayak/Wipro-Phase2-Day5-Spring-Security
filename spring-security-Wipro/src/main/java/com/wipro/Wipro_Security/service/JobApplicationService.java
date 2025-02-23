package com.wipro.Wipro_Security.service;

import com.wipro.Wipro_Security.model.Job;
import com.wipro.Wipro_Security.model.JobApplication;
import com.wipro.Wipro_Security.repository.JobApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobApplicationService {

    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    // 🔹 Fetch applications by email
    public List<JobApplication> getUserApplications(String email) {
        return jobApplicationRepository.findByEmail(email);
    }

    // 🔹 Apply for a job (fix)
    public JobApplication applyForJob(String name, String email, Job job) {
        JobApplication application = new JobApplication(name, email, job);
        return jobApplicationRepository.save(application);
    }

    // 🔹 Withdraw application (fix)
    public boolean withdrawApplication(int jobId, String email) {
        JobApplication application = jobApplicationRepository.findByJobIdAndEmail(jobId, email);
        if (application != null) {
            jobApplicationRepository.delete(application);
            return true;
        }
        return false;
    }
}
