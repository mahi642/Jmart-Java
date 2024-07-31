package EmployeeManagement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.Statement;

public class Insert_employee {
    public static void Hire_employee(){
        Scanner input = new Scanner(System.in);
        try {
            Connection connection = Connection_Provider.createConnection();
            Statement statement=connection.createStatement();
            System.out.println("Enter the details of the Employee you want to hire : ");
            System.out.println("Enter the Role : ");
            String new_role = input.nextLine();
            System.out.println("Enter Name : ");
            String Name = input.nextLine();
            System.out.println("Enter Aadhaar number : ");
            String ahr = input.next();
            System.out.println("Enter Contact number : ");
            String cnum = input.next();
            System.out.println("Enter Age : ");
            String age = input.next();
            System.out.println("Enter Employee id : ");
            String new_emp_id = input.next();
            System.out.println("Enter workplace id : ");
            String new_wp_id = input.next();
            System.out.println("Enter Manager_id : ");
            String new_mgr_id = input.next();
            System.out.println("Enter Salary : ");
            int new_sal = input.nextInt();
            String query_statement = new_emp_id+","+"\""+Name+"\"" +","+ new_wp_id+","+ahr+","+ new_sal +","+ cnum +","+ age  +","+ "\" " + new_role +"\" "+","+ new_mgr_id ;
            String hiring_query = "INSERT INTO Employees VALUES("+query_statement+ ");";
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
        Hire_employee();
    }
}

/****************************************************/
/*

            System.out.println("Enter 1 for Department Manager \s Enter 2 for Section Employee \s Enter 3 for Security guard \s Enter 4 for Cleaner \s Enter 5 for Cashier");
            int role_num = input.nextInt();
            int new_wid;
            String Salary,Role,Manager;
            switch (role_num)
            {
                case 1:
                    System.out.println("Enter department id :");
                    new_wid = input.nextInt();
                    Salary = "80000";
                    Role = "department manager";
                    Manager = "100";
                break;
                case 2:
                    System.out.println("Enter Section id");
                    new_wid = input.nextInt();
                    System.out.println("Select role [Section Manager -> 1 | Section filler -> 2 | Section Helper ->3]");
                    int sub_role = input.nextInt();
                    switch(sub_role)
                    {
                        case 1:
                            Salary = "80000";
                            Role = "section manager";
                            Manager = "100";
                    }
 */