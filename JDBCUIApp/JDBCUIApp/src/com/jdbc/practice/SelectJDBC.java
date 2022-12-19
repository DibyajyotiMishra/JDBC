package com.jdbc.practice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectJDBC {
    public static void main(String[] args) {
        try {
            Connection conn = ConnectionProvider.getConnection();

            String query = "select * from students;";

            Statement stmt = conn.createStatement();
            ResultSet set = stmt.executeQuery(query);

            while (set.next()) {
                int srollNo = set.getInt(1);
                String sname = set.getString(2);
                String sclass = set.getString(3);
                String sage = set.getString(4);

                System.out
                        .println("Name: " + sname + ", Roll No: " + srollNo + ", Class: " + sclass + ", Age: " + sage);
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
