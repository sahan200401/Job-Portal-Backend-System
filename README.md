Job Portal Backend System

A professioanl java - based job partal backed system with MySql database, implementing layered architecture with clean separation concerns.

📋 Table of Contents
  Features
  Technology Stack
  Project Structure
  Database Schema
  Setup Instructions
  Running the Application
  Usage Guide
  Interview Points

Features

Three User Roles:

1.Candidates
    Create and manage profiles
    Search and filter jobs
    Apply for jobs (with duplicate prevention)
    Track application status
    Withdraw applications

2.Employers
    Create company profiles
    Post and manage job listings
    View applications for posted jobs
    Update application status (Pending/Reviewed/Shortlisted/Rejected/Accepted)
    Close job postings

3.Admin
    System oversight (expandable



Core Functionality:
  ✅ User authentication and authorization  
  ✅ Role-based access control
  ✅ Duplicate application prevention
  ✅ Clean exception handling  
  ✅ JDBC-based database operations
  ✅ Business logic separation


🛠 Technology Stack
    Language: Java 8+
    Database: MySQL 8.0+
    JDBC Driver: MySQL Connector/J
    Architecture: Layered (MVC-inspired)
    Design Patterns: DAO, Singleton, Service Laye


📁 Project Structure

com.jobportal/
├── model/              # Entity classes (POJOs)
│   ├── User.java
│   ├── CandidateProfile.java
│   ├── EmployerProfile.java
│   ├── Job.java
│   └── Application.java
│
├── dao/                # Data Access Layer
│   ├── UserDAO.java
│   ├── JobDAO.java
│   └── ApplicationDAO.java
│
├── service/            # Business Logic Layer
│   ├── AuthService.java
│   ├── JobService.java
│   └── ApplicationService.java
│
├── util/               # Utility classes
│   └── DBConnection.java
│
├── exception/          # Custom exceptions
│   ├── InvalidLoginException.java
│   ├── DuplicateApplicationException.java
│   └── UnauthorizedAccessException.java
│
└── main/               # Application entry point
    └── Main.java


🗄 Database Schema
  The system uses 5 main tables:-
    users - Authentication and user roles
    candidate_profiles - Candidate information
    employer_profiles - Company information
    jobs - Job postings
    applications - Job applications with unique constraint

Key Features:-
    Foreign key constraints for data integrity
    Indexes on frequently queried columns
    ENUM types for status fields
    Timestamps for audit trails
    Unique constraint preventing duplicate applications

Setup Instructions
  Prerequisites:-
    Java Development Kit (JDK) 8 or higher
    MySQL Server 8.0+
    MySQL JDBC Driver (mysql-connector-java)
    IDE (IntelliJ IDEA, Eclipse, or VS Code)








