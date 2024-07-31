package ProductManagement;

import EmployeeManagement.Connection_Provider;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class update_quantity {
    public static void update_prod_quantity(){
        Scanner input = new Scanner(System.in);
        try {
            Connection connection = Connection_Provider.createConnection();
            Statement statement=connection.createStatement();
            System.out.println("Enter the id of the product for which you want to update the quantity : ");
            String p_id = input.next();
            System.out.println("Enter the updated quantity : ");
            String new_quant = input.next();
            String query_statement= "UPDATE products SET quantity = "+new_quant+" WHERE id = "+p_id+" ; ";
            System.out.println(query_statement);
            int result = statement.executeUpdate(query_statement);
            if (result > 0)
            {
                System.out.println("Update Successfully");
            }
            else {
                System.out.println("Update UNSuccessfully");
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
        update_prod_quantity();
    }
}
