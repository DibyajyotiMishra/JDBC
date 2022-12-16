
// Prepared Statement
import java.sql.*;

public class InsertData {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/student";
            String user = "root";
            String password = "password";

            Connection con = DriverManager.getConnection(url, user, password);

            String query = "Insert into students(StudentName, class, age) values(?, ?, ?);";

            // Prepared Statement

            PreparedStatement preparedStatement = con.prepareStatement(query);

            // Set the values.
            preparedStatement.setString(1, "Ramu L");
            preparedStatement.setString(2, "10 A");
            preparedStatement.setInt(3, 15);

            // Execute the query.
            preparedStatement.executeUpdate();

            System.out.println("Data Inserted Successfully");

            con.close();

        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}