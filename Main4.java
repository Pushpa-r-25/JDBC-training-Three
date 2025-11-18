// hiding the user data
package dayy28;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Main4 {
    public static void main(String[] args) {

        System.out.println("Connecting to the database...");

        try {
            // 1️⃣ Load properties from external file
            Properties prop = new Properties();
            prop.load(new FileInputStream("db.properties"));

            // 2️⃣ Read values from db.properties file
            String url = prop.getProperty("dburl");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            // 3️⃣ Load the JDBC driver manually
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 4️⃣ Establish the connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established successfully!");
//            Assumes connection is successful if no exception
            // Explicitly closes the connection with conn.close()
            conn.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


