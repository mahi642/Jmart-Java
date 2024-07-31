import java.sql.*;
import java.util.*;
public class PartialSearch {

public static  void psearch(){

    Scanner input = new Scanner(System.in);

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops", "root", "Mahi@642");
            Statement st = con.createStatement();
            System.out.println("Enter the string for searching products using name [The string can also be partial] : ");
            String ser_name = input.nextLine();
            System.out.println("Enter the Limit of results you want  to see ");
            String res_limit = input.next();
            String partial_query = " '%"+ser_name+"%' ";

            ResultSet rs = st.executeQuery("SELECT * FROM all_products WHERE Product_name LIKE "+partial_query+" ORDER BY Product_id limit 0 ,"+res_limit+";");
            while(rs.next()){

                System.out.printf("\nProduct ID : %s\nSection Name : %s\nSection ID : %s\nProduct name : %s\nPrice : %s\nQuantity : %s\nTax rate : %s\n",rs.getInt(3),rs.getString(1),rs.getInt(2),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getFloat(7));

            }

        }
        catch (Exception e){
            System.out.println(e);
        }
    }


}

