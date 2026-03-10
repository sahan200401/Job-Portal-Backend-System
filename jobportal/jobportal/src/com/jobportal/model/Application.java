package com.jobportal.model;

import java.time.LocalDateTime;

/**
 * Represents a job application submitted by a candidate.
 *
 * Stores details like the candidate, the job applied for, cover letter,
 * application status, and timestamps for tracking.
 */
public class Application {

    private int applicationId;       // Unique ID for the application
    private int jobId;               // ID of the job being applied to
    private int candidateId;         // ID of the candidate applying
    private String coverLetter;      // Optional cover letter text
    private ApplicationStatus status; // Current status of the application
    private LocalDateTime appliedDate; // Timestamp when application was submitted
    private LocalDateTime updatedAt;   // Timestamp of last update

    /**
     * Enum representing all possible statuses of an application.
     */
    public enum ApplicationStatus {
        PENDING, REVIEWED, SHORTLISTED, REJECTED, ACCEPTED
    }

    // Default constructor
    public Application() {}

    // Constructor for creating a new application
    public Application(int jobId, int candidateId, String coverLetter, ApplicationStatus status) {
        this.jobId = jobId;
        this.candidateId = candidateId;
        this.coverLetter = coverLetter;
        this.status = status;
    }

    // Getters and setters
    public int getApplicationId() { return applicationId; }
    public void setApplicationId(int applicationId) { this.applicationId = applicationId; }

    public int getJobId() { return jobId; }
    public void setJobId(int jobId) { this.jobId = jobId; }

    public int getCandidateId() { return candidateId; }
    public void setCandidateId(int candidateId) { this.candidateId = candidateId; }

    public String getCoverLetter() { return coverLetter; }
    public void setCoverLetter(String coverLetter) { this.coverLetter = coverLetter; }

    public ApplicationStatus getStatus() { return status; }
    public void setStatus(ApplicationStatus status) { this.status = status; }

    public LocalDateTime getAppliedDate() { return appliedDate; }
    public void setAppliedDate(LocalDateTime appliedDate) { this.appliedDate = appliedDate; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public String toString() {
        return "Application{" +
                "applicationId=" + applicationId +
                ", jobId=" + jobId +
                ", candidateId=" + candidateId +
                ", coverLetter='" + coverLetter + '\'' +
                ", status=" + status +
                ", appliedDate=" + appliedDate +
                ", updatedAt=" + updatedAt +
                '}';
    }
}