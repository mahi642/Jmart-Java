import java.util.Scanner;
import java.sql.*;
public class Jmart {

    public static void Welcome_Message_mart() {
        System.out.println("<<<------------WELCOME TO JMART!!!------------>>>");
    }

    public static void DisplayAllDepartments() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops", "root", "Mahi@642");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from Departments");
            System.out.println("<-----DISPLAYING DEPARTMENTS---->");
            System.out.printf("%15s | %15s \n", "Department ID", "Department Name");
            while (rs.next()) {
                System.out.printf("%15s | %15s \n", rs.getInt(1), rs.getString(2));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void Choose_Department() throws SQLException, ClassNotFoundException {
        System.out.println("CHOOSE THE DEPARTMENT EXAMPLE:: ENTERING X ,IT TAKES TO DEPARTMENT IN X ROW ");
        DisplayAllDepartments();
        Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();

                Department.DisplayDepartment(choice);

            }
        }






