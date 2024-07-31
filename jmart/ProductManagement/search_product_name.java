package ProductManagement;
import EmployeeManagement.Connection_Provider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class search_product_name {

    public static void product_SEARCH_name(){
        Scanner input = new Scanner(System.in);
        try {
            Connection connection = Connection_Provider.createConnection();
            Statement statement=connection.createStatement();
            System.out.println("Enter the string for searching products using name [The string can also be partial] : ");
            String ser_name = input.nextLine();
            System.out.println("Enter the Limit of results you want  to see ");
            String res_limit = input.next();
            String partial_query = " '%"+ser_name+"%' ";
            String query_statement= "SELECT * FROM products WHERE Name LIKE "+partial_query+" ORDER BY id limit 0 ,"+res_limit+";";
            System.out.println(query_statement);
            ResultSet resultSet = statement.executeQuery(query_statement);
            while (resultSet.next())
            {
                System.out.printf("\nSection ID : %s\nSection Name : %s\nProduct ID : %s\nProduct name : %s\nPrice : %s\nQuantity : %s\nTax rate : %s\n",resultSet.getInt(3),resultSet.getString(1),resultSet.getInt(2),resultSet.getString(4),resultSet.getInt(5),resultSet.getInt(6),resultSet.getFloat(7));
            }
            String count_query = "SELECT COUNT(id) FROM products WHERE Name LIKE "+partial_query+";";
            System.out.println(count_query);
            ResultSet resultSet2 = statement.executeQuery(count_query);
            while (resultSet2.next())
            {
                System.out.printf("\nTotal count of such entries = %s\n",resultSet2.getInt(1));
            }
            String sum_query = "SELECT SUM(price) FROM products WHERE Name LIKE "+partial_query+";";
            System.out.println(sum_query);
            ResultSet resultSet3 = statement.executeQuery(sum_query);
            while (resultSet3.next())
            {
                System.out.printf("\nTotal sum of all prices from such entries = %s\n",resultSet3.getInt(1));
            }
            String avg_query = "SELECT AVG(price) FROM products WHERE Name LIKE "+partial_query+";";
            System.out.println(sum_query);
            ResultSet resultSet4 = statement.executeQuery(avg_query);
            while (resultSet4.next())
            {
                System.out.printf("\nThe average of all salaries from such entries = %s\n",resultSet4.getFloat(1));
            }
            System.out.println("Successfull");
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
        product_SEARCH_name();
    }
}
