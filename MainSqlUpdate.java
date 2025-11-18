package dayy28;
// Defines the package name for organizing your Java files

import java.io.FileInputStream;   // To read the db.properties file
import java.sql.Connection;       // Represents a connection to the database
import java.sql.DriverManager;    // Used to get database connections
import java.sql.Statement;        // Used to execute SQL statements
import java.util.Properties;      // To load key–value pairs from a properties file

public class MainSqlUpdate {
    public static void main(String[] args) {

        // Step 1: Create a Properties object to hold database connection info
        Properties prop = new Properties();

        // Step 2: Load db.properties file using try-with-resources
        // try-with-resources automatically closes the FileInputStream after use
        try (FileInputStream fis = new FileInputStream("db.properties")) {
            // Load the properties (key=value pairs) from the file
            prop.load(fis);
        } catch (Exception e) {
            // If there's an error (e.g., file not found), print error message
            System.out.println("Error loading properties file: " + e.getMessage());
            return; // Exit the program if properties file not loaded properly
        }

        // Step 3: Read database connection details from the properties file
        // The file should contain keys like dburl, user, and password
        String url = prop.getProperty("dburl");      // e.g. jdbc:mysql://localhost:3306/classicmodels
        String user = prop.getProperty("user");      // e.g. root
        String password = prop.getProperty("password");  // e.g. 1234

        // Step 4: Write the SQL INSERT query to add a new employee record
        String query = "UPDATE employees SET jobTitle='Junior Developer' WHERE employeeNumber=2208";

        // Step 5: Establish the connection and execute the SQL statement
        // try-with-resources ensures the connection and statement are closed automatically
        try (Connection conn = DriverManager.getConnection(url, user, password); // Open connection
             Statement stmt = conn.createStatement()) { // Create statement object to send SQL commands

            // Step 6: Execute the INSERT query
            // executeUpdate() is used for INSERT, UPDATE, or DELETE queries
            int rows = stmt.executeUpdate(query);

            // Step 7: Print confirmation of how many records were inserted
            System.out.println(rows + " record(s) updated successfully!");

        } catch (Exception e) {
            // If any SQL or connection error occurs, print the error message
            System.out.println("Database error: " + e.getMessage());
        }
    }
}

