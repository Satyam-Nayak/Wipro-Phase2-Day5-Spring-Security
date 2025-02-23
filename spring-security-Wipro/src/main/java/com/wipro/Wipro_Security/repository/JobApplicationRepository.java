package com.wipro.Wipro_Security.repository;

import com.wipro.Wipro_Security.model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Integer> {
    List<JobApplication> findByEmail(String email);
    JobApplication findByJobIdAndEmail(int jobId, String email);
}
