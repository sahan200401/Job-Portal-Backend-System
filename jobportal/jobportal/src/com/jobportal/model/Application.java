package com.jobportal.model;

import java.time.LocalDateTime;

public class Application {
    private int applicationId;
    private int jobId;
    private int candidateId;
    private String coverLetter;
    private ApplicationStatus status;
    private LocalDateTime appliedDate;
    private LocalDateTime updatedAt;


    public enum ApplicationStatus{
        PENDING, REVIEWED, SHORTLISTED, REJECTED, ACCEPTED
    }

    public Application(){}

    public Application(int jobId, int candidateId, String coverLetter, ApplicationStatus status) {
        this.jobId = jobId;
        this.candidateId = candidateId;
        this.coverLetter = coverLetter;
        this.status = status;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public String getCoverLetter() {
        return coverLetter;
    }

    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public LocalDateTime getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(LocalDateTime appliedDate) {
        this.appliedDate = appliedDate;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

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
