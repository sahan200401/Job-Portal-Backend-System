package com.jobportal.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Utility class for managing application configuration
 */
public class ConfigUtil {
    private static Properties properties;
    private static final String CONFIG_FILE = "config.properties";
    
    static {
        loadProperties();
    }
    
    private static void loadProperties() {
        properties = new Properties();
        try (InputStream input = ConfigUtil.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input != null) {
                properties.load(input);
            } else {
                // Fallback to environment variables if config file not found
                loadFromEnvironment();
            }
        } catch (IOException e) {
            System.err.println("Error loading configuration: " + e.getMessage());
            loadFromEnvironment();
        }
    }
    
    private static void loadFromEnvironment() {
        properties.setProperty("db.url", System.getenv().getOrDefault("DB_URL", "jdbc:mysql://localhost:3306/job_portal"));
        properties.setProperty("db.username", System.getenv().getOrDefault("DB_USERNAME", "root"));
        properties.setProperty("db.password", System.getenv().getOrDefault("DB_PASSWORD", ""));
        properties.setProperty("password.bcrypt.rounds", System.getenv().getOrDefault("BCRYPT_ROUNDS", "12"));
    }
    
    public static String getDbUrl() {
        return properties.getProperty("db.url");
    }
    
    public static String getDbUsername() {
        return properties.getProperty("db.username");
    }
    
    public static String getDbPassword() {
        return properties.getProperty("db.password");
    }
    
    public static int getBcryptRounds() {
        return Integer.parseInt(properties.getProperty("password.bcrypt.rounds", "12"));
    }
    
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
