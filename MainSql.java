
// properities + try resource block + fetching data
package dayy28;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class MainSql {
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
        try (Connection conn = DriverManager.getConnection(url, user, password);
//             Creates a Statement object — used to send SQL commands to the database.
             Statement stmt = conn.createStatement();
//             Executes the SQL query → “get all data from the employees table”.
//                     The result (rows) are stored in rs (ResultSet).
             ResultSet rs = stmt.executeQuery("select * from employees")
        ) {
            System.out.println("connection successful!");
            System.out.println("employees firstname");
            System.out.println("***********************************");
//            Loops through each row of the result.
while(rs.next()) {
//    Reads each column value (first name, employee number, job title)
//    and prints them one by one.
    String fname= rs.getString("firstname");
    String empNo= rs.getString("employeeNumber");
    String jTitle= rs.getString("jobTitle");
    System.out.println(fname+" "+empNo+" "+jTitle);
}
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e.getMessage());
        }
    }
}
