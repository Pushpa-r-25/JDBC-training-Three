// hiding the user data
package dayy28;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Main5 {
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


            // 4️⃣ Establish the connection
            Connection conn = DriverManager.getConnection(url, user, password);
//            ✅ 4. Checks Connection
//            Checks if conn != null before confirming succes
//
            if(conn != null) {
//                Prints message only if connection is not null

                System.out.println("Connection established successfully!");
            }
            // 5️⃣ Close the connection


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}



