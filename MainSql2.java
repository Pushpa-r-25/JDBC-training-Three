package dayy28;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class MainSql2 {
    public static void main(String[] args) {
        Properties prop = new Properties();

        // Step 2: Load db.properties file safely using try-with-resources
        try (FileInputStream fis = new FileInputStream("db.properties")) {
            prop.load(fis);
        } catch (Exception e) {
            System.out.println("Error loading properties file: " + e.getMessage());
             // Exit if properties not loaded
        }

        // Step 3: Get database credentials from file
        String url = prop.getProperty("dburl");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        String query = "SELECT * FROM employees";

        MysqlDataSource datasource = new MysqlDataSource();
        datasource.setURL(url);
        datasource.setUser(user);
        datasource.setPassword(password);
//        test this connection
        try(Connection conn = datasource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("Connected to database successfully!");
            System.out.println("Employee Number | Name | job title");

            while(rs.next()) {


                String  empNo= rs.getString("employeeNumber");
                String fname= rs.getString("firstname");
                String jTitle= rs.getString("jobTitle");
                System.out.printf("%s | %s | %s \n", empNo, fname, jTitle);
            }}
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}