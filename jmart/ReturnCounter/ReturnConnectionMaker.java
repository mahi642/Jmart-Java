package ReturnCounter;

import java.sql.Connection;
import java.sql.DriverManager;

public class ReturnConnectionMaker {
    static Connection connection;
    public static Connection createConnection()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user="root";
            String password="P.S@1008#121";
            String url="jdbc:mysql://localhost:3306/jmart1";
            connection= DriverManager.getConnection(url,user,password);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return connection;
    }
    public static void main(String[] args)
    {
        System.out.println("Hello");
        createConnection();
        System.out.println("Connection Created!");


    }
}
