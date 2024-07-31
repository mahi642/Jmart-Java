
import java.sql.*;
import java.sql.ResultSet;
import java.util.Scanner;



public class Cart {

    public static void select_product() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("ENTER THE PRODUCT ID TO SELECT");
            int pro_id = scanner.nextInt();
            System.out.println("ENTER PRODUCT QUANTITY ");
            int quantity = scanner.nextInt();

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops", "root", "Mahi@642");
            Statement statement = con1.createStatement();
            System.out.println("ENTER THE SECTION NUMBER");
            int sn = scanner.nextInt();
            String q1 = "insert into cart1 select "+section.cart_id +"  ,Product_id,Product_quantity,Product_price  from Section_"+sn+" where Product_id =" + pro_id;

            String q2 = "update Section_"+sn+" set Product_quantity = Product_quantity -" + quantity + " " + "where Product_id =" + pro_id;
            String q3 = "update cart1 set Product_quantity = " + quantity + " ,Product_totalprice  = Product_totalprice * " + quantity + " where  Product_id = " + pro_id;
            String q4 = "update all_products set Product_quantity = Product_quantity -" + quantity + " " + "where Product_id =" + pro_id;
            PreparedStatement ps = con1.prepareStatement(q1);
            ps.executeUpdate(q1);
            ps.executeUpdate(q2);
            ps.executeUpdate(q3);
            ps.executeUpdate(q4);


        } catch (Exception e) {
            System.out.println(e);
        }


    }






    public static void Edit_quantity() {
        Scanner in = new Scanner(System.in);
        System.out.println("<-------YOU SELECTED TO EDIT QUANITY OF THE PRODUCT----->");
        System.out.println("ENTER THE PRODUCT ID TO CHANGE THE QUANTITY");
        int pro_id = in.nextInt();
        System.out.println("ENTER THE NEW QUANTITY OF SELECTED PRODUCT");
        int new_quantity = in.nextInt();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops", "root", "Mahi@642");
            String q4 = "update cart1 set Product_quantity = " + new_quantity + " where Product_id = " + pro_id;
            PreparedStatement ps = con.prepareStatement(q4);
            ps.executeUpdate(q4);


        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public static void Delete_product(){
        Scanner in = new Scanner(System.in);
        System.out.println("<-----------YOU ARE SELECTED TO DELETE THE PRODUCT----------->");
        System.out.println("ENTER THE PRODUCT ID TO DELETE ITEM");
        int pro_id = in.nextInt();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops", "root", "Mahi@642");
            String q5 = "delete from cart1  where Product_id = " + pro_id;
            PreparedStatement ps = con.prepareStatement(q5);
            ps.executeUpdate(q5);


        } catch (Exception e) {
            System.out.println(e);
        }

    }

     public static void show_cart(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops", "root", "Mahi@642");
            Statement statement = con1.createStatement();
            ResultSet resultSet = statement.executeQuery("select "+section.cart_id+",Product_id,Product_quantity from cart1 where cart_id = "+section.cart_id);
            System.out.println("<-----------YOUR CART--------->");
            System.out.println("");
            System.out.printf("%15s |%15s |%15s | \n","CART ID","PRODUCT ID","PRODUCT QUANTITY");
            while (resultSet.next()){
                System.out.printf("%15s|%15s|%15s\n",resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));

            }

        }catch (Exception e){
            System.out.println(e);
        }
     }


}
