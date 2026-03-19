package com.jobportal.dao;

import com.jobportal.model.*;
import com.jobportal.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // Create new user
    public int createUser(User user) throws SQLException {
        String query = "INSERT INTO users (username, password, email, role) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getRole().name());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
            }
            return -1;
        }
    }

    // Find user by username and password
    public User findByUsernameAndPassword(String username, String password) throws SQLException {
        String query = "SELECT * FROM users WHERE username = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, username);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    User user = extractUserFromResultSet(rs);
                    // ✅ FIXED: password verification using BCrypt
                    if (user != null && user.verifyPassword(password)) {
                        return user;
                    }
                }
            }
        }
        return null;
    }

    // Find user by ID
    public User findById(int userId) throws SQLException {
        String query = "SELECT * FROM users WHERE user_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, userId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return extractUserFromResultSet(rs);
                }
            }
        }
        return null;
    }

    // Find user by username
    public User findByUsername(String username) throws SQLException {
        String query = "SELECT * FROM users WHERE username = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, username);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return extractUserFromResultSet(rs);
                }
            }
        }
        return null;
    }

    // Get all users
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                users.add(extractUserFromResultSet(rs));
            }
        }
        return users;
    }

    // Update user
    public boolean updateUser(User user) throws SQLException {
        String query = "UPDATE users SET username = ?, email = ?, role = ? WHERE user_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getRole().name());
            // ✅ FIXED: uses getUserId() consistently
            pstmt.setInt(4, user.getUserId());

            return pstmt.executeUpdate() > 0;
        }
    }

    // Delete user
    public boolean deleteUser(int userId) throws SQLException {
        String query = "DELETE FROM users WHERE user_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, userId);
            return pstmt.executeUpdate() > 0;
        }
    }

    // Create Candidate Profile
    public int createCandidateProfile(CandidateProfile profile) throws SQLException {
        String query = "INSERT INTO candidate_profiles (user_id, full_name, phone, skills, " +
                "experience_years, education, resume_url, location) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, profile.getUserId());
            pstmt.setString(2, profile.getFullName());
            pstmt.setString(3, profile.getPhone());
            pstmt.setString(4, profile.getSkills());
            pstmt.setInt(5, profile.getExperienceYears());
            pstmt.setString(6, profile.getEducation());
            pstmt.setString(7, profile.getResumeUrl());
            pstmt.setString(8, profile.getLocation());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
            }
            return -1;
        }
    }

    // Get Candidate Profile by User ID
    public CandidateProfile getCandidateProfile(int userId) throws SQLException {
        String query = "SELECT * FROM candidate_profiles WHERE user_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, userId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return extractCandidateProfileFromResultSet(rs);
                }
            }
        }
        return null;
    }

    // Create Employer Profile
    public int createEmployerProfile(EmployerProfile profile) throws SQLException {
        String query = "INSERT INTO employer_profiles (user_id, company_name, industry, " +
                "company_size, website, description, location) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, profile.getUserId());
            pstmt.setString(2, profile.getCompanyName());
            pstmt.setString(3, profile.getIndustry());
            pstmt.setString(4, profile.getCompanySize());
            pstmt.setString(5, profile.getWebsite());
            pstmt.setString(6, profile.getDescription());
            pstmt.setString(7, profile.getLocation());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
            }
            return -1;
        }
    }

    // Get Employer Profile by User ID
    public EmployerProfile getEmployerProfile(int userId) throws SQLException {
        String query = "SELECT * FROM employer_profiles WHERE user_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, userId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return extractEmployerProfileFromResultSet(rs);
                }
            }
        }
        return null;
    }

    // ✅ FIXED: null-safe timestamps + null-safe Role parsing + consistent getUserId/setUserId + hashed password handling
    private User extractUserFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        // ✅ FIXED: calls setUserId() — matches field 'userId' in User.java
        user.setUserId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        // ✅ FIXED: set hashed password directly without re-hashing
        user.setHashedPassword(rs.getString("password"));
        user.setEmail(rs.getString("email"));

        // ✅ FIXED: null-safe Role parsing
        String roleStr = rs.getString("role");
        if (roleStr != null) {
            user.setRole(User.Role.valueOf(roleStr));
        }

        // ✅ FIXED: null-safe timestamp parsing
        Timestamp createdAt = rs.getTimestamp("created_at");
        if (createdAt != null) {
            user.setCreatedAt(createdAt.toLocalDateTime());
        }

        Timestamp updatedAt = rs.getTimestamp("updated_at");
        if (updatedAt != null) {
            user.setUpdatedAt(updatedAt.toLocalDateTime());
        }

        return user;
    }

    // ✅ FIXED: null-safe timestamps for CandidateProfile
    private CandidateProfile extractCandidateProfileFromResultSet(ResultSet rs) throws SQLException {
        CandidateProfile profile = new CandidateProfile();
        profile.setProfileId(rs.getInt("profile_id"));
        profile.setUserId(rs.getInt("user_id"));
        profile.setFullName(rs.getString("full_name"));
        profile.setPhone(rs.getString("phone"));
        profile.setSkills(rs.getString("skills"));
        profile.setExperienceYears(rs.getInt("experience_years"));
        profile.setEducation(rs.getString("education"));
        profile.setResumeUrl(rs.getString("resume_url"));
        profile.setLocation(rs.getString("location"));

        Timestamp createdAt = rs.getTimestamp("created_at");
        if (createdAt != null) {
            profile.setCreatedAt(createdAt.toLocalDateTime());
        }

        Timestamp updatedAt = rs.getTimestamp("updated_at");
        if (updatedAt != null) {
            profile.setUpdatedAt(updatedAt.toLocalDateTime());
        }

        return profile;
    }

    // ✅ FIXED: null-safe timestamps for EmployerProfile
    private EmployerProfile extractEmployerProfileFromResultSet(ResultSet rs) throws SQLException {
        EmployerProfile profile = new EmployerProfile();
        profile.setProfileId(rs.getInt("profile_id"));
        profile.setUserId(rs.getInt("user_id"));
        profile.setCompanyName(rs.getString("company_name"));
        profile.setIndustry(rs.getString("industry"));
        profile.setCompanySize(rs.getString("company_size"));
        profile.setWebsite(rs.getString("website"));
        profile.setDescription(rs.getString("description"));
        profile.setLocation(rs.getString("location"));

        Timestamp createdAt = rs.getTimestamp("created_at");
        if (createdAt != null) {
            profile.setCreatedAt(createdAt.toLocalDateTime());
        }

        Timestamp updatedAt = rs.getTimestamp("updated_at");
        if (updatedAt != null) {
            profile.setUpdatedAt(updatedAt.toLocalDateTime());
        }

        return profile;
    }
}