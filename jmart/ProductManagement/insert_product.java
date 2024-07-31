package ProductManagement;

import EmployeeManagement.Connection_Provider;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class insert_product {
    public static void add_product(){
        Scanner input = new Scanner(System.in);
        try {
            Connection connection = Connection_Provider.createConnection();
            Statement statement=connection.createStatement();
            System.out.println("Enter the details of the product you want to insert : ");
            System.out.println("Enter product name : ");
            String pname = input.nextLine();
            System.out.println("Enter the Section name : ");
            String secname = input.nextLine();
            System.out.println("Enter the Section id : ");
            int sid = input.nextInt();
            System.out.println("Enter product id : ");
            int pid = input.nextInt();
            System.out.println("Enter product price : ");
            int pprice = input.nextInt();
            System.out.println("Enter product quantity : ");
            int pquant = input.nextInt();
            System.out.println("Enter tax rate : ");
            float taxr = input.nextFloat();
            String query_statement =  "\""+secname+"\""+" , "+ pid+" , " + sid  +"  , "+"\""+pname+"\"" +" , "+ pprice +","+ pquant +","+ taxr ;

            String hiring_query = "INSERT INTO products VALUES("+query_statement+ ");";
            System.out.println(hiring_query);
            int result = statement.executeUpdate(hiring_query);
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
        add_product();
    }


}
