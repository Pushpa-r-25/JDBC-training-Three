//Uses try-with-resources for safe file handling
//        Main6 relies on auto-loading (modern JDBC practice)
//        Uses try-with-resources to auto-close connection



        package dayy28;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Main6 {
    public static void main(String[] args) {
        System.out.println("Connecting to the database...");

        // Step 1: Create a Properties object
        Properties prop = new Properties();

        // Step 2: Load db.properties file safely using try-with-resources
        try (FileInputStream fis = new FileInputStream("db.properties")) {
            prop.load(fis);
        } catch (Exception e) {
            System.out.println("Error loading properties file: " + e.getMessage());
            return; // Exit if properties not loaded
        }

        // Step 3: Get database credentials from file
        String url = prop.getProperty("dburl");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");

        // Step 4: Try to connect to the database
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("✅ Connected to the database successfully!");
            } else {
                System.out.println("❌ Connection object is null!");
            }
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e.getMessage());
        }
    }
}