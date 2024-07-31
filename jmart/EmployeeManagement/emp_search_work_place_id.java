package EmployeeManagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class emp_search_work_place_id {

    public static void emp_search_work_place_id(){
        Scanner input = new Scanner(System.in);
        try {
            Connection connection = Connection_Provider.createConnection();
            Statement statement=connection.createStatement();
            System.out.println("Enter the workplace id ");
            String wpl_id = input.next();
            System.out.println("Enter the Limit of results you want to see ");
            String res_limit = input.next();

            String query_statement= "SELECT * FROM Employees WHERE WorkPlace_id = "+wpl_id+" ORDER BY id limit 0 ,"+res_limit+";";
            System.out.println(query_statement);
            ResultSet resultSet = statement.executeQuery(query_statement);
            while (resultSet.next())
            {
                System.out.printf("\n\nEmployee ID : %s\nName : %s\nWorkplace ID : %s\nAadhaar number : %s\nMonthly Salary : %s\nContact : %s\nAge : %s\nRole : %s\nManager ID : %s\n",resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getDouble(4),resultSet.getInt(5),resultSet.getDouble(6),resultSet.getInt(7),resultSet.getString(8),resultSet.getInt(9));
            }
            String count_query = "SELECT COUNT(id) FROM Employees WHERE WorkPlace_id = "+wpl_id+";";
            System.out.println(count_query);
            ResultSet resultSet2 = statement.executeQuery(count_query);
            while (resultSet2.next())
            {
                System.out.printf("Total count of such entries = %s\n",resultSet2.getInt(1));
            }
            String sum_query = "SELECT SUM(salary) FROM Employees WHERE WorkPlace_id = "+wpl_id+";";
            System.out.println(sum_query);
            ResultSet resultSet3 = statement.executeQuery(sum_query);
            while (resultSet3.next())
            {
                System.out.printf("Total sum of all salaries from such entries = %s\n",resultSet3.getInt(1));
            }
            String avg_query = "SELECT AVG(salary) FROM Employees WHERE WorkPlace_id = "+wpl_id+";";
            System.out.println(sum_query);
            ResultSet resultSet4 = statement.executeQuery(avg_query);
            while (resultSet4.next())
            {
                System.out.printf("The average of all salaries from such entries = %s\n",resultSet4.getInt(1));
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
        emp_search_work_place_id();
    }
}
