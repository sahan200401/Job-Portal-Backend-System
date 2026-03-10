package com.jobportal.model;

import java.time.LocalDateTime;

/**
 * Represents an employer's profile in the Job Portal system.
 * Stores company details, industry info, and metadata.
 */
public class EmployerProfile {

    private int profileId;       // Unique profile ID
    private int userId;          // ID of the associated user (employer account)
    private String companyName;  // Name of the company
    private String industry;     // Industry the company belongs to
    private String companySize;  // Size of the company (e.g., "50-100 employees")
    private String website;      // Company website URL
    private String description;  // Short description of the company
    private String location;     // Company headquarters or office location
    private LocalDateTime createdAt; // Timestamp when profile was created
    private LocalDateTime updatedAt; // Timestamp when profile was last updated

    // Default constructor
    public EmployerProfile() {}

    // Constructor to create a new employer profile
    public EmployerProfile(int userId, String companyName, String industry, String companySize,
                           String website, String description, String location) {
        this.userId = userId;
        this.companyName = companyName;
        this.industry = industry;
        this.companySize = companySize;
        this.website = website;
        this.description = description;
        this.location = location;
    }

    // Getters and setters
    public int getProfileId() { return profileId; }
    public void setProfileId(int profileId) { this.profileId = profileId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getIndustry() { return industry; }
    public void setIndustry(String industry) { this.industry = industry; }

    public String getCompanySize() { return companySize; }
    public void setCompanySize(String companySize) { this.companySize = companySize; }

    public String getWebsite() { return website; }
    public void setWebsite(String website) { this.website = website; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public String toString() {
        return "EmployerProfile{" +
                "profileId=" + profileId +
                ", userId=" + userId +
                ", companyName='" + companyName + '\'' +
                ", industry='" + industry + '\'' +
                ", companySize='" + companySize + '\'' +
                ", website='" + website + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}