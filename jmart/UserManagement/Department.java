import java.sql.*;
import java.util.Scanner;
public class Department extends Jmart
{    
    public  static void DisplayDepartment(int choice) throws SQLException, ClassNotFoundException {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops", "root", "Mahi@642");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from Dept_"+ choice);
            System.out.println("<------------DISPLAYING DEPARTMENT-------------->");
            System.out.println("");
            System.out.printf("%15s | %15s | %15s |%15s \n", "Department ID", "Department Name", "Section Name", "Section ID");
            while (rs.next()) 
            {
                System.out.println("----------------------------------------------------------------------");
                System.out.printf("%15s | %15s | %15s |%15s \n", rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
            con.close();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
        System.out.println("ENTER 1 TO CONTINUE WITH SAME DEPARTMENT");
        System.out.println(" ENTER 2 TO CHANGE THE DEPARTMENT");
        Scanner scan = new Scanner(System.in);

            int ch = scan.nextInt();
            switch (ch)
            {
                case 1: Department.Choose_Section(choice);



                break;


                case 2: Jmart.Choose_Department();

            }
        }




    public static  void Choose_Section(int dn) throws SQLException, ClassNotFoundException {
        System.out.println("ENTER THE SECTION (1 TO 5) EXAMPLE : ENTERING X TAKES TO X SECTION");
        try(Scanner sc = new Scanner(System.in)) {


            int sn = sc.nextInt();
            section.Display_Section(dn, sn);
        }

    }
}