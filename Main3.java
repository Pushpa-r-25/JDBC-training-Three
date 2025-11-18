// old school method

package dayy28;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main3 {
    public static void main(String[] args) {
        String user = "root";
        String password = "12345";
        String url = "jdbc:mysql://localhost:3306/learnmysql1";

        System.out.println("Connecting to the database...");

        try {
            // 1. Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish the connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established successfully!");

            // 3. Close the connection
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

