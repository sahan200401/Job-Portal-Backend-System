package com.jobportal.model;

import com.jobportal.model.Application;
import com.jobportal.model.Application.ApplicationStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * ApplicationTracker is responsible for tracking all job applications.
 * It allows adding new applications, updating their status, and retrieving
 * applications based on candidate or job.
 */
public class ApplicationTracker {

    private List<Application> applications;

    // Constructor
    public ApplicationTracker() {
        applications = new ArrayList<>();
    }

    /**
     * Add a new application to the tracker.
     */
    public void addApplication(Application application) {
        application.setAppliedDate(LocalDateTime.now());
        application.setUpdatedAt(LocalDateTime.now());
        // Auto-generate application ID
        application.setApplicationId(applications.size() + 1);
        applications.add(application);
        System.out.println("Application submitted: " + application);
    }

    /**
     * Update the status of an application by applicationId.
     */
    public void updateApplicationStatus(int applicationId, ApplicationStatus status) {
        for (Application app : applications) {
            if (app.getApplicationId() == applicationId) {
                app.setStatus(status);
                app.setUpdatedAt(LocalDateTime.now());
                System.out.println("Updated Application ID " + applicationId + " to status: " + status);
                return;
            }
        }
        System.out.println("Application ID " + applicationId + " not found.");
    }

    /**
     * Get all applications for a specific candidate by candidateId.
     */
    public List<Application> getApplicationsByCandidate(int candidateId) {
        List<Application> result = new ArrayList<>();
        for (Application app : applications) {
            if (app.getCandidateId() == candidateId) {
                result.add(app);
            }
        }
        return result;
    }

    /**
     * Get all applications for a specific job by jobId.
     */
    public List<Application> getApplicationsByJob(int jobId) {
        List<Application> result = new ArrayList<>();
        for (Application app : applications) {
            if (app.getJobId() == jobId) {
                result.add(app);
            }
        }
        return result;
    }

    /**
     * Display all applications.
     */
    public void showAllApplications() {
        if (applications.isEmpty()) {
            System.out.println("No applications yet.");
            return;
        }
        for (Application app : applications) {
            System.out.println(app);
        }
    }
}