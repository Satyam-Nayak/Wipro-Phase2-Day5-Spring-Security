package com.wipro.Wipro_Security.model;

import jakarta.persistence.*;

@Entity
@Table(name = "job_applications")
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    // Constructors
    public JobApplication() {}

    public JobApplication(String name, String email, Job job) {
        this.name = name;
        this.email = email;
        this.job = job;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Job getJob() { return job; }
    public void setJob(Job job) { this.job = job; }
}
