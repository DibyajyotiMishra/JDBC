import java.util.Scanner;
import java.sql.*;

public class Practice {
    private static Connection conn;

    private static void setupDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String dbURL = "jdbc:mysql://localhost:3306/student";
            String userName = "root";
            String password = "password";
            conn = DriverManager.getConnection(dbURL, userName, password);
        } catch (Exception err) {
            System.out.println("=========================================");
            System.out.println("Error in setupDB() method");
            err.printStackTrace();
        }
    }

    private static int addStudentData() {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter student Name: ");
            String sname = sc.nextLine();

            System.out.print("Enter student Class: ");
            String sclass = sc.nextLine();

            System.out.print("Enter student Age: ");
            int sage = sc.nextInt();

            sc.close();

            String query = "INSERT INTO students(StudentName, class, age) VALUES(?,?,?);";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, sname);
            pstmt.setString(2, sclass);
            pstmt.setInt(3, sage);
            int res = pstmt.executeUpdate();

            return res;
        } catch (Exception e) {
            System.out.println("=========================================");
            System.out.println("Error in addStudentData() method");
            e.printStackTrace();
            return 0;
        }
    }

    public static void main(String[] args) {
        try {

            setupDB();
            int res = addStudentData();

            if (res == 1)
                System.out.println("Data added successfully");
            else
                System.out.println("Data not added");

            conn.close();
        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}