package com.jobportal.model;
import java.time.LocalDateTime;

public class CandidateProfile {
    private int profileId;
    private int userid;
    private String fullName;
    private String phone;
    private String skills;
    private int experienceYears;
    private String education;
    private String resumeUrl;
    private String Location;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CandidateProfile() {
    }

    public CandidateProfile(int userid, String fullName, String phone, String skills, int experienceYears, String education, String location) {
        this.userid = userid;
        this.fullName = fullName;
        this.phone = phone;
        this.skills = skills;
        this.experienceYears = experienceYears;
        this.education = education;
        Location = location;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getResumeUrl() {
        return resumeUrl;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
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
        return "CandidateProfile{" +
                "profileId=" + profileId +
                ", userid=" + userid +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", skills='" + skills + '\'' +
                ", experienceYears=" + experienceYears +
                ", education='" + education + '\'' +
                ", resumeUrl='" + resumeUrl + '\'' +
                ", Location='" + Location + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
