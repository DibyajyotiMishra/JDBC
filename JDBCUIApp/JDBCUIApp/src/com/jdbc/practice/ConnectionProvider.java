package com.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            if (connection == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String dbUrl = "jdbc:mysql://localhost:3306/student";
                String userName = "root";
                String password = "password";
                connection = DriverManager.getConnection(dbUrl, userName, password);
            }
        } catch (Exception e) {
            System.out.println("Error in Connection Provider");
            e.printStackTrace();
        }
        return connection;
    }
}
