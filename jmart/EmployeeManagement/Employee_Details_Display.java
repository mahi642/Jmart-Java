package EmployeeManagement;
import java.util.Scanner;
import java.sql.*;

public class Employee_Details_Display {

    public static void Employee_Details_Display(){
        try {

            Connection connection = Connection_Provider.createConnection();
            Statement statement=connection.createStatement();
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the employee for whom you want the details : ");
            String empid = input.next();
            String query = "SELECT * FROM employees WHERE id = "+empid+";";
            System.out.println(query);
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
            {
                System.out.printf("\n\nEmployee ID : %s\nName : %s\nWorkplace ID : %s\nAadhaar number : %s\nMonthly Salary : %s\nContact : %s\nAge : %s\nRole : %s\nManager ID : %s\n",resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getDouble(4),resultSet.getInt(5),resultSet.getDouble(6),resultSet.getInt(7),resultSet.getString(8),resultSet.getInt(9));
            }
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Employee_Details_Display();
    }
}