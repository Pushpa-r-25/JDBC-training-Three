// use this method to establish
package dayy28;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class MainSql1 {
    public static void main(String[] args) {
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

        MysqlDataSource datasource = new MysqlDataSource();
        datasource.setURL(url);
        datasource.setUser(user);
        datasource.setPassword(password);
//        test this connection
        try(Connection conn = datasource.getConnection()) {
System.out.println("Connected to database successfully!");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from employees limit 5");

            while(rs.next()) {
//    Reads each column value (first name, employee number, job title)
//    and prints them one by one.
                String fname= rs.getString("firstname");
                String lname=rs.getString("lastName");
                String empNo= rs.getString("employeeNumber");
                String jTitle= rs.getString("jobTitle");
                System.out.println(fname+" -------- "+lname+" ----------- "+empNo+"------------- "+jTitle);
            }}
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}