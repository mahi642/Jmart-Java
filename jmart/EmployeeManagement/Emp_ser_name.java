package EmployeeManagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Emp_ser_name {

    public static void EMP_SEARCH_name(){
        Scanner input = new Scanner(System.in);
        try {
            Connection connection = Connection_Provider.createConnection();
            Statement statement=connection.createStatement();
            System.out.println("Enter the string for searching employees using name [The string can also be partial] : ");
            String ser_name = input.nextLine();
            System.out.println("Enter the Limit of results you want  to see ");
            String res_limit = input.next();
            String partial_query = " '%"+ser_name+"%' ";
            String query_statement= "SELECT * FROM Employees WHERE Name LIKE "+partial_query+" ORDER BY id limit 0 ,"+res_limit+";";
            System.out.println(query_statement);
            ResultSet resultSet = statement.executeQuery(query_statement);
            while (resultSet.next())
            {
                System.out.printf("\n\nEmployee ID : %s\nName : %s\nWorkplace ID : %s\nAadhaar number : %s\nMonthly Salary : %s\nContact : %s\nAge : %s\nRole : %s\nManager ID : %s\n",resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getDouble(4),resultSet.getInt(5),resultSet.getDouble(6),resultSet.getInt(7),resultSet.getString(8),resultSet.getInt(9));
            }
            String count_query = "SELECT COUNT(id) FROM Employees WHERE Name LIKE "+partial_query+";";
            System.out.println(count_query);
            ResultSet resultSet2 = statement.executeQuery(count_query);
            while (resultSet2.next())
            {
                System.out.printf("Total count of such entries = %s\n",resultSet2.getInt(1));
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
        EMP_SEARCH_name();
    }
}
