package ProductManagement;

import EmployeeManagement.Connection_Provider;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class update_product_name {

    public static void update_prod_name(){
        Scanner input = new Scanner(System.in);
        try {
            Connection connection = Connection_Provider.createConnection();
            Statement statement=connection.createStatement();
            System.out.println("Enter the id of the product for which you want to update the name : ");
            String p_id = input.next();
            System.out.println("Enter the updated name : ");
            String newname = input.next();
            String new_name = "\""+newname+"\"";
            String query_statement= "UPDATE products SET name = "+new_name+" WHERE id = "+p_id+" ; ";
            System.out.println(query_statement);
            int result = statement.executeUpdate(query_statement);
            if (result > 0)
            {
                System.out.println("Update Successfull");
            }
            else {
                System.out.println("Update UN-Successfull");
            }
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("!!WRONG ENTRIES GIVEN!!");
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello, Now I'll run the query : ");
        update_prod_name();
    }
}
