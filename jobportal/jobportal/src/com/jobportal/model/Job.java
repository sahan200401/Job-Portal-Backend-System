package com.jobportal.model;

import java.time.LocalDateTime;

/**
 * Represents a job posting in the Job Portal system.
 * Stores details such as title, description, requirements, salary,
 * type, status, and important timestamps.
 */
public class Job {

    private int jobId;               // Unique ID for the job
    private int employerId;          // ID of the employer who posted the job
    private String title;            // Job title
    private String description;      // Full job description
    private String requirements;     // Candidate requirements
    private String salaryRange;      // Salary range for the job
    private String location;         // Job location
    private JobType jobType;         // Type of job (Full-time, Part-time, etc.)
    private JobStatus status;        // Current status (Active, Closed, Draft)
    private LocalDateTime postedDate; // Date when job was posted
    private LocalDateTime deadline;   // Application deadline
    private LocalDateTime createdAt;  // Profile creation timestamp
    private LocalDateTime updatedAt;  // Last update timestamp

    /**
     * Enum representing the type of a job.
     */
    public enum JobType {
        FULL_TIME, PART_TIME, CONTRACT, INTERNSHIP
    }

    /**
     * Enum representing the current status of a job.
     */
    public enum JobStatus {
        ACTIVE, CLOSED, DRAFT
    }

    // Default constructor
    public Job() {}

    // Constructor for creating a new job posting
    public Job(int employerId, String title, String description, String requirements,
               String salaryRange, String location, JobType jobType, JobStatus status) {
        this.employerId = employerId;
        this.title = title;
        this.description = description;
        this.requirements = requirements;
        this.salaryRange = salaryRange;
        this.location = location;
        this.jobType = jobType;
        this.status = status;
    }

    // Getters and setters
    public int getJobId() { return jobId; }
    public void setJobId(int jobId) { this.jobId = jobId; }

    public int getEmployerId() { return employerId; }
    public void setEmployerId(int employerId) { this.employerId = employerId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getRequirements() { return requirements; }
    public void setRequirements(String requirements) { this.requirements = requirements; }

    public String getSalaryRange() { return salaryRange; }
    public void setSalaryRange(String salaryRange) { this.salaryRange = salaryRange; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public JobType getJobType() { return jobType; }
    public void setJobType(JobType jobType) { this.jobType = jobType; }

    public JobStatus getStatus() { return status; }
    public void setStatus(JobStatus status) { this.status = status; }

    public LocalDateTime getPostedDate() { return postedDate; }
    public void setPostedDate(LocalDateTime postedDate) { this.postedDate = postedDate; }

    public LocalDateTime getDeadline() { return deadline; }
    public void setDeadline(LocalDateTime deadline) { this.deadline = deadline; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", employerId=" + employerId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", requirements='" + requirements + '\'' +
                ", salaryRange='" + salaryRange + '\'' +
                ", location='" + location + '\'' +
                ", jobType=" + jobType +
                ", status=" + status +
                ", postedDate=" + postedDate +
                ", deadline=" + deadline +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}