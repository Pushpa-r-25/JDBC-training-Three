// Version 3 – Simplified Try Block (IDE Way)
//🔍 Key Points:
//The connection is created inside the try block (not in try(...)).
//It does not close automatically after use.
// You’re not closing the connection anywhere.
//It’s short, but risky — the connection stays open until the program ends.
//Used for: Quick testing or demos (not recommended in real applications).
// they can get to know the loop because we did not close it
package dayy28;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main2 {
    public static void main(String[] args) {
        String user = "root";
        String pass = "12345564";
        String url = "jdbc:mysql://localhost:3306/learningmysql"; // ✅ Correct URL

        System.out.println("Connecting to the database...");


        try {
             Connection conn = DriverManager.getConnection(url, user, pass);
            // Establish connection
            if(conn != null) {
                System.out.println(" Connected to the database!");
            }
        } catch (Exception e) {
            System.out.println("Connection Failed... ");
        }
    }
}
