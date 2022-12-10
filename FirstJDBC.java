
/**
 *  First JDBC Program
 */

import java.sql.*;

public class FirstJDBC {

    public static void main(String[] args) {
        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a connection
            String dbUrl = "jdbc:mysql://localhost:3306/student";
            String user = "root";
            String password = "password";
            Connection connection = DriverManager.getConnection(dbUrl, user, password);

            // Checking if connection is active
            if (connection.isClosed()) {
                System.out.println("Connection is closed");
            } else {
                System.out.println("Connection is open now...");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}