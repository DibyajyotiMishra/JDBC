import java.sql.*;
import java.io.*;

public class InsertImage {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String dbUrl = "jdbc:mysql://localhost:3306/student?jdbcCompliantTruncation=false";
            String username = "root";
            String password = "password";
            Connection conn = DriverManager.getConnection(dbUrl, username, password);

            String query = "INSERT INTO images(image) VALUES(?);";

            PreparedStatement pstmt = conn.prepareStatement(query);

            FileInputStream fis = new FileInputStream("image.jpg");

            pstmt.setBinaryStream(1, fis, fis.available());
            pstmt.executeUpdate();

            System.out.println("Image inserted successfully");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

/**
 * TINYBLOB ≈ 255 bytes,
 * BLOB ≈ 64KB,
 * MEDIUMBLOB ≈ 16MB
 * and
 * LONGBLOB ≈ 4GB Run
 */