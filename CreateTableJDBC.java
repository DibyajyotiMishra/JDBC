
import java.sql.*;

public class CreateTableJDBC {
    public static void main(String[] args) {
        try {
            // Loading the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Creating a connection
            String dbUrl = "jdbc:mysql://localhost:3306/student";
            String user = "root";
            String password = "password";
            Connection connection = DriverManager.getConnection(dbUrl, user, password);

            // Creating a query
            String query = "create TABLE students(RollNo int primary key auto_increment, StudentName varchar(150) not null, class varchar(10) not null, age int not null)";

            // Creating a statement
            Statement statement = connection.createStatement();

            // Executing the query
            statement.executeUpdate(query);

            System.out.println("Table created successfully...");

            // Closing the connection
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
