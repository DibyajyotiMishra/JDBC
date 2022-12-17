package com.jdbc.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateData {
    public static void main(String[] args) {
        try {
            Connection conn = ConnectionProvider.getConnection();

            String query = "update students set StudentName = ?, class= ?, age= ? where RollNo=?;";

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter new Name: ");
            String sname = br.readLine();

            System.out.println("Enter new Class: ");
            String sclass = br.readLine();

            System.out.println("Enter new Age: ");
            int sage = Integer.parseInt(br.readLine());

            System.out.println("Enter RollNo: ");
            int rollno = Integer.parseInt(br.readLine());

            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, sname);
            pstmt.setString(2, sclass);
            pstmt.setInt(3, sage);
            pstmt.setInt(4, rollno);

            pstmt.executeUpdate();

            System.out.println("Data Updated Successfully");
            conn.close();
        } catch (Exception e) {
            System.out.println("Error in UpdateData: ");
            e.printStackTrace();
        }
    }
}
