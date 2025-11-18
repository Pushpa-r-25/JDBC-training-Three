// Version 1 – Old / Manual Way
//🔍 Key Points:
//You create the connection outside the try block.
// You manually close it in the finally block.
//It’s safe, but long and messy.
// If you forget to close, it causes memory leaks.
//Used in: Old Java versions (before Java 7).
package dayy28;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String user = "root";
        String pass = "12345";
        String url = "jdbc:mysql://localhost:3306/learningmysql"; // ✅ Correct URL

        System.out.println("Connecting to the database...");
        Connection conn = null;

        try {

            // Establish connection
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println(" Connected to the database!");

        } catch (Exception e) {
            System.out.println(" Error: " + e.getMessage());
        } finally {
            // Close connection safely
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println(" Connection closed.");
                } catch (SQLException e) {
                    System.out.println(" Error while closing: " + e.getMessage());
                }
            }
        }
    }
}