package com.jdbc.practice;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = ConnectionProvider.getConnection();

            String query = "insert into images(image) values(?);";

            PreparedStatement pstmt = connection.prepareStatement(query);

            JFileChooser jfc = new JFileChooser();
            jfc.showOpenDialog(null);

            File file = jfc.getSelectedFile();

            FileInputStream fis = new FileInputStream(file);

            pstmt.setBinaryStream(1, fis, fis.available());
            pstmt.executeUpdate();
            System.out.println("Image inserted successfully");

            JOptionPane.showMessageDialog(null, "Image inserted successfully");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
