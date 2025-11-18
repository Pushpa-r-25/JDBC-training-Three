// Version 2 – Modern Try-with-Resources Way
// try with idea way( try with conn)
//🔍 Key Points:
//Introduced in Java 7 — this is the modern and recommended way.
//The connection is created inside the parentheses of try(...).
// The connection automatically closes itself when the try block ends. ✅
//No finally block needed.
//Cleaner, shorter, and best practice for JDBC.
//Used in: Modern Java projects (Java 7+).
package dayy28;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main1 {
    public static void main(String[] args) {
        String user = "root";
        String pass = "12345";
        String url = "jdbc:mysql://localhost:3306/learningmyysql"; // ✅ Correct URL

        System.out.println("Connecting to the database...");


        try( Connection conn = DriverManager.getConnection(url, user, pass)) {

            // Establish connection
            if(conn != null) {
                System.out.println(" Connected to the database!");
            }
        } catch (Exception e) {
            System.out.println("Connection Failed... ");
        }
    }
}
