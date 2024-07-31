package ProductManagement;

import EmployeeManagement.Connection_Provider;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class delete_product {
    public static void delete_product_from_id(){
        Scanner input = new Scanner(System.in);
        try {
            Connection connection = Connection_Provider.createConnection();
            Statement statement=connection.createStatement();
            System.out.println("Enter the id of the product for which you want to DELETE the record : ");
            String prod_id = input.next();
            String query_statement= "DELETE FROM products WHERE id = "+prod_id+" ; ";
            System.out.println(query_statement);
            int result = statement.executeUpdate(query_statement);
            if (result > 0)
            {
                System.out.println("Update Successfull");
            }
            else {
                System.out.println("Update UNSuccessfull");
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
        delete_product_from_id();
    }
}
