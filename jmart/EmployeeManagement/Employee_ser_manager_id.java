package EmployeeManagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Employee_ser_manager_id {
    public static void Employee_ser_manager_id(){
        try {

            Connection connection = Connection_Provider.createConnection();
            Statement statement=connection.createStatement();
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the id of the manager for getting the details of managed employees : ");
            String mnum = input.next();
            System.out.println("Enter the Limit of results you want to see ");
            String res_limit = input.next();
            String query = "SELECT * FROM employees WHERE manager_id = "+mnum+" ORDER BY id limit 0 ,"+res_limit+";";
            System.out.println(query);
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
            {
                System.out.printf("\n\nEmployee ID : %s\nName : %s\nWorkplace ID : %s\nAadhaar number : %s\nMonthly Salary : %s\nContact : %s\nAge : %s\nRole : %s\nManager ID : %s\n",resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getDouble(4),resultSet.getInt(5),resultSet.getDouble(6),resultSet.getInt(7),resultSet.getString(8),resultSet.getInt(9));
            }
            String count_query = "SELECT COUNT(id) FROM Employees WHERE  manager_id = "+mnum+";";
            System.out.println(count_query);
            ResultSet resultSet2 = statement.executeQuery(count_query);
            while (resultSet2.next())
            {
                System.out.printf("Total count of such entries = %s\n",resultSet2.getInt(1));
            }
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Employee_ser_manager_id();
    }
}
