package ProductManagement;

import EmployeeManagement.Connection_Provider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class read_product_details {
    public static void Product_Details_Display(){
        try {

            Connection connection = Connection_Provider.createConnection();
            Statement statement=connection.createStatement();
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the product id for which you want the details : ");
            String pid = input.next();
            String query = "SELECT * FROM products WHERE id = "+pid+";";
            System.out.println(query);
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
            {
                System.out.printf("\n\nSection id : ID : %s\nSection name : %s\nProduct id : %s\nProduct name : %s\nPrice : %s\nQuantity : %s\nTax rate : %s\n",resultSet.getInt(3),resultSet.getString(1),resultSet.getInt(2),resultSet.getString(4),resultSet.getInt(5),resultSet.getInt(6),resultSet.getInt(7));
            }
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Product_Details_Display();
    }
}
