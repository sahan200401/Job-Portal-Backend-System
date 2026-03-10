package com.jobportal.service;

import com.jobportal.dao.UserDAO;
import com.jobportal.model.*;
import com.jobportal.exception.InvalidLoginException;
import java.sql.SQLException;

public class AuthService {
    private UserDAO userDAO;
    private User currentUser;

    public AuthService() {
        this.userDAO = new UserDAO();
        this.currentUser = null;
    }

    /**
     * Register a new user
     */
    public User register(String username, String password, String email, User.Role userRole)
            throws SQLException {
        // Check if username already exists
        if (userDAO.findByUsername(username) != null) {
            throw new SQLException("Username already exists");
        }

        User user = new User(username, password, email, userRole);
        int userId = userDAO.createUser(user);

        if (userId > 0) {
            user.setUserId(userId);
            return user;
        }
        throw new SQLException("Failed to register user");
    }

    /**
     * Login user with username and password
     */
    public User login(String username, String password) throws InvalidLoginException, SQLException {
        User user = userDAO.findByUsernameAndPassword(username, password);

        if (user == null) {
            throw new InvalidLoginException("Invalid username or password");
        }

        this.currentUser = user;
        return user;
    }

    /**
     * Logout current user
     */
    public void logout() {
        this.currentUser = null;
    }

    /**
     * Get current logged-in user
     */
    public User getCurrentUser() {
        return this.currentUser;
    }

    /**
     * Check if user is logged in
     */
    public boolean isLoggedIn() {
        return this.currentUser != null;
    }

    /**
     * Check if current user has specific role
     */
    public boolean hasRole(User.Role requiredRole) {
        return this.currentUser != null && this.currentUser.getRole() == requiredRole;
    }

    /**
     * Create candidate profile
     */
    public CandidateProfile createCandidateProfile(String fullName, String phone, String skills,
                                                   int experienceYears, String education, String location)
            throws SQLException {
        if (!hasRole(User.Role.CANDIDATE)) {
            throw new SQLException("Only candidates can create candidate profiles");
        }

        CandidateProfile profile = new CandidateProfile(
                currentUser.getUserId(), fullName, phone, skills,
                experienceYears, education, location
        );

        int profileId = userDAO.createCandidateProfile(profile);

        if (profileId > 0) {
            profile.setProfileId(profileId);
            return profile;
        }
        throw new SQLException("Failed to create candidate profile");
    }

    /**
     * Create employer profile
     */
    public EmployerProfile createEmployerProfile(String companyName, String industry,
                                                 String companySize, String website,
                                                 String description, String location)
            throws SQLException {
        if (!hasRole(User.Role.EMPLOYER)) {
            throw new SQLException("Only employers can create employer profiles");
        }

        EmployerProfile profile = new EmployerProfile(
                currentUser.getUserId(), companyName, industry,
                companySize, website, description, location
        );

        int profileId = userDAO.createEmployerProfile(profile);

        if (profileId > 0) {
            profile.setProfileId(profileId);
            return profile;
        }
        throw new SQLException("Failed to create employer profile");
    }

    /**
     * Get candidate profile for current user
     */
    public CandidateProfile getCandidateProfile() throws SQLException {
        if (!hasRole(User.Role.CANDIDATE)) {
            throw new SQLException("Only candidates can view candidate profiles");
        }
        return userDAO.getCandidateProfile(currentUser.getUserId());
    }

    /**
     * Get employer profile for current user
     */
    public EmployerProfile getEmployerProfile() throws SQLException {
        if (!hasRole(User.Role.EMPLOYER)) {
            throw new SQLException("Only employers can view employer profiles");
        }
        return userDAO.getEmployerProfile(currentUser.getUserId());
    }
}