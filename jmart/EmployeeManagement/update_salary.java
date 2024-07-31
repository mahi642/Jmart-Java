package EmployeeManagement;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class update_salary {
    public static void update_salary(){
        Scanner input = new Scanner(System.in);
        try {
            Connection connection = Connection_Provider.createConnection();
            Statement statement=connection.createStatement();
            System.out.println("Enter the id of the Employee for whom you want to update salary : ");
            String emp_id = input.next();
            System.out.println("Enter the updated salary : ");
            String new_sal = input.next();
            String query_statement= "UPDATE Employees SET Salary = "+new_sal+" WHERE id = "+emp_id+" ; ";
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
        update_salary();
    }
}
