package com.jobportal.model;

import java.time.LocalDateTime;

public class Job {
    private int jobId;
    private int employerId;
    private String title;
    private String description;
    private String requirements;
    private String salaryRange;
    private String location;
    private JobType jobType;
    private JobStatus status;
    private LocalDateTime postedDate;
    private LocalDateTime deadline;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public enum JobType{
        FULL_TIME, PART_TIME, CONTRACT, INTERNSHIP
    }

    public enum JobStatus{
        ACTIVE, CLOSED, DRAFT
    }
    public Job(){}

    public Job(int employerId, String title, String description, String requirements, String salaryRange, String location, JobType jobType, JobStatus status) {
        this.employerId = employerId;
        this.title = title;
        this.description = description;
        this.requirements = requirements;
        this.salaryRange = salaryRange;
        this.location = location;
        this.jobType = jobType;
        this.status = status;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getEmployerId() {
        return employerId;
    }

    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public JobStatus getStatus() {
        return status;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }

    public LocalDateTime getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(LocalDateTime postedDate) {
        this.postedDate = postedDate;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

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
