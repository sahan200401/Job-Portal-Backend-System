package com.jobportal.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/job_portal";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "9103865429";

    private static Connection connection = null;

    private DBConnection() {}


    public static Connection getConnection() throws SQLException{
        if (connection == null || connection.isClosed()){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("Database connection established successfully!");
            }catch (ClassNotFoundException e){
                System.err.println("MySQL JDBC Driver not found.");
                throw new SQLException("Driver not found " , e );
            }
            catch (SQLException e){
                System.err.println("Failed to connect to database");
                throw e;
            }
        }
        return connection;
    }

    public static void closeConnection(){
        if (connection != null){
            try{
                connection.close();
                System.out.println("Database connection closed");
            }catch(SQLException e){
                System.err.println("Error closing connection:  ");
            }
        }
    }

    public static boolean testConnection(){
        try{
            Connection conn = getConnection();
            return conn != null && !conn.isClosed();
        }
        catch (SQLException e){
            return false;
        }
    }

}
