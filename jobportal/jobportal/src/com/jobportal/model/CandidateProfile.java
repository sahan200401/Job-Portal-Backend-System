package com.jobportal.model;

import java.time.LocalDateTime;

/**
 * Represents a candidate profile in the Job Portal system.
 */
public class CandidateProfile {

    private int profileId;         // Unique profile ID
    private int userId;            // ID of the associated user
    private String fullName;       // Candidate's full name
    private String phone;          // Contact phone
    private String skills;         // Candidate skills
    private int experienceYears;   // Years of experience
    private String education;      // Educational qualifications
    private String resumeUrl;      // Resume file URL or path
    private String location;       // Candidate location
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CandidateProfile() {}

    public CandidateProfile(int userId, String fullName, String phone, String skills,
                            int experienceYears, String education, String location) {
        this.userId = userId;
        this.fullName = fullName;
        this.phone = phone;
        this.skills = skills;
        this.experienceYears = experienceYears;
        this.education = education;
        this.location = location;
    }

    // Getters and setters
    public int getProfileId() { return profileId; }
    public void setProfileId(int profileId) { this.profileId = profileId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }

    public int getExperienceYears() { return experienceYears; }
    public void setExperienceYears(int experienceYears) { this.experienceYears = experienceYears; }

    public String getEducation() { return education; }
    public void setEducation(String education) { this.education = education; }

    public String getResumeUrl() { return resumeUrl; }
    public void setResumeUrl(String resumeUrl) { this.resumeUrl = resumeUrl; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public String toString() {
        return "CandidateProfile{" +
                "profileId=" + profileId +
                ", userId=" + userId +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", skills='" + skills + '\'' +
                ", experienceYears=" + experienceYears +
                ", education='" + education + '\'' +
                ", resumeUrl='" + resumeUrl + '\'' +
                ", location='" + location + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}