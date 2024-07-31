package ReturnCounter;
import EmployeeManagement.Connection_Provider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class ReturningProducts {
    public static void verify_bill() {
        Scanner input = new Scanner(System.in);
        try {
            Connection connection = Connection_Provider.createConnection();
            Statement statement = connection.createStatement();
            System.out.println("Hello, Enter your bill id :");
            String bill_id = input.next();
            String verifying_statement = "SELECT EXISTS(SELECT * FROM bills WHERE bill_id = " + bill_id + ");";
            System.out.println(verifying_statement);
            ResultSet resultSet = statement.executeQuery(verifying_statement);
            boolean res = false;
            if (resultSet.next()) {
                res = resultSet.getBoolean(1);
            }
            if (res) {
                System.out.println("Bill Verified!");
                String cart_finder = "SELECT cart_id from bills where bill_id = " + bill_id + ";";
                System.out.println(cart_finder);
                ResultSet resultSet2 = statement.executeQuery(cart_finder);
                resultSet2.next();
                int cart = resultSet2.getInt(1);
                String cart_id = String.valueOf(cart);
                System.out.println("The cart associated with bill " + bill_id + " has cart id = " + cart_id);
                product_verification(cart_id);
            } else {
                System.out.println("Sorry, the bill does not exist in our database.");
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("!!WRONG ENTRIES GIVEN!!");

        }
    }

    public static void product_verification(String cart_id) {
        Scanner input = new Scanner(System.in);
        try {
            Connection connection = Connection_Provider.createConnection();
            Statement statement = connection.createStatement();
            System.out.println("Your Bill is verified, please enter the product id of the product you want to return. :");
            String product_id = input.next();
            String verifying_statement = "SELECT EXISTS(SELECT * FROM carts WHERE cart_id = " + cart_id + " AND product_id = " + product_id + ");";
            System.out.println(verifying_statement);
            ResultSet resultSet = statement.executeQuery(verifying_statement);
            boolean res = false;
            if (resultSet.next()) {
                res = resultSet.getBoolean(1);
            }
            if (res) {
                System.out.println("Product Exists!");
                return_product(cart_id, product_id);
            } else {
                System.out.println("Sorry, you didn't purchase this product with this bill.");
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("!!WRONG ENTRIES GIVEN!!");

        }
    }

    public static void return_product(String cart_id, String product_id) {
        Scanner input = new Scanner(System.in);
        try {
            Connection connection = Connection_Provider.createConnection();
            Statement statement = connection.createStatement();
            String quantity_statement = "SELECT quantity FROM carts WHERE cart_id = " + cart_id + " AND product_id = " + product_id + ";";
            System.out.println(quantity_statement);
            ResultSet resultSet3 = statement.executeQuery(quantity_statement);
            resultSet3.next();
            int total_quantity = resultSet3.getInt(1);
            System.out.println("You have purchased " + total_quantity + " units of this item.");
            System.out.println("Are you sure that you want to return it? [Type Yes/No]");
            String response = input.next();
            if (response.equalsIgnoreCase("yes")) {
                System.out.println("Enter the quantity of return : ");
                int return_quantity = input.nextInt();
                if (total_quantity >= return_quantity) {
                    System.out.println("Return Successful!!");
                    edit_bill_info(cart_id,product_id,return_quantity);
                    refund(product_id, return_quantity);
                } else {
                    System.out.println("Return Quantity greater than total purchased quantity!");
                }
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("!!WRONG ENTRIES GIVEN!!");

        }
    }
    public static void edit_bill_info(String cart_id,String product_id , int return_quantity )
    {
        try {
            Connection connection = Connection_Provider.createConnection();
            Statement statement=connection.createStatement();
            String query_statement= "UPDATE carts SET quantity = quantity - "+return_quantity+" WHERE cart_id = " + cart_id + " AND product_id = " + product_id + ";";
            System.out.println(query_statement);
            int result = statement.executeUpdate(query_statement);
            if (result > 0)
            {
                System.out.println("Cart Update Successfully");
            }
            else {
                System.out.println("Cart Update UNSuccessfully");
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("!!WRONG ENTRIES GIVEN!!");

        }
    }
    public static void refund(String product_id,  int return_quantity) {
        try {
            Connection connection = Connection_Provider.createConnection();
            Statement statement = connection.createStatement();
            String price_statement = "SELECT price FROM products WHERE id = " + product_id + ";";
            System.out.println(price_statement);
            ResultSet resultSet4 = statement.executeQuery(price_statement);
            resultSet4.next();
            int price = resultSet4.getInt(1);
            int amount = price * return_quantity;
            System.out.println("Thank you for shopping at JMart.\nYour total refund amount is ₹" + amount);
            System.out.println("Have a nice day!");
            System.out.println("x----------x-----------x-----------x------------x-----------x---------x-------------x");
            return_to_shelf(product_id,return_quantity);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("!!WRONG ENTRIES GIVEN!!");

        }
    }

    public static void return_to_shelf(String product_id, int return_quantity)
    {
        try {
            Connection connection = Connection_Provider.createConnection();
            Statement statement=connection.createStatement();
                        String query_statement= "UPDATE products SET quantity = quantity + "+return_quantity+" WHERE id = "+product_id+" ; ";
            System.out.println(query_statement);
            int result = statement.executeUpdate(query_statement);
            if (result > 0)
            {
                System.out.println("Update Successfully");
            }
            else {
                System.out.println("Update UNSuccessfully");
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("!!WRONG ENTRIES GIVEN!!");
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello, Now I'll run the query : ");
        verify_bill();
    }    }

