import java.util.Scanner;
import java.sql.*;
public class Billing extends Cart {

    public static void bill() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("YOUR CART ID IS::"+section.cart_id);
         int sum = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops", "root", "Mahi@642");
            Statement statement = connection.createStatement();
            Statement S2  = connection.createStatement();
            String price = "select sum(product_totalprice) from cart1 where cart_id ="+section.cart_id;
           // ResultSet r1 = S2.executeQuery(price);
            ResultSet resultSet = statement.executeQuery("select Product_id ,Product_quantity,product_totalprice from cart1 where cart_id =  " + section.cart_id);
           //  resultSet = statement.executeQuery(price);
           // PreparedStatement ps = connection.prepareStatement(price);

//            int total = resultSet.getInt("TOTAL");
            System.out.println("<---------------------PREPARING BILL-------------------------->");
            System.out.println("-------------------------------------------------");
            System.out.printf("%15s |%15s | %15s \n","Product ID","Product Quantity","Price");


            {
                while (resultSet.next()) {
                    System.out.println("----------------------------------------------------------------");
                    System.out.printf("%15s |%15s|%15s\n", resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));

                    int c = resultSet.getInt(3);
                    sum = sum+c;
                }
                System.out.println("\t TOTAL AMOUNT IS:: "+sum);
                Gst G1 = new Gst();
                G1.findcgst((double)sum);
                Discount.discount(sum);

            }
          //  System.out.println(total);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
