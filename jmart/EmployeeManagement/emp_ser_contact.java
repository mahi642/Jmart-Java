package EmployeeManagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class emp_ser_contact {

    public static void emp_ser_contact(){
        try {

            Connection connection = Connection_Provider.createConnection();
            Statement statement=connection.createStatement();
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the contact number of employee for whom you want the details : ");
            String cnum = input.next();
            String query = "SELECT * FROM employees WHERE contact = "+cnum;
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
        emp_ser_contact();
    }
}
