import java.sql.*;
import java.util.*;
public class section extends Department {
      static int cart_id;

    public  static void setCart_id() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops", "root", "Mahi@642");
        Statement st = con.createStatement();
        ResultSet rs= st.executeQuery("Select max(cart_id) from cart1");
        if(rs.next()) {
            cart_id = rs.getInt(1);
            cart_id++;
        }

    }


    public static void Display_Section(  int dn,int sn) throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops", "root", "Mahi@642");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from Section_" +dn + "" + sn);
            System.out.println("<------------Displaying section items--------------->");
            System.out.println("");
            System.out.printf("%15s |%15s |%15s |%15s |%15s |%15s |%15s \n", "Section Name", "Section ID", "Product ID", "Product Name", "Product Price", "product Quantity", "TaxRate");
            while (rs.next()) {
                System.out.println("------------------------------------------------------------------------------------------------------");
                System.out.printf("%15s |%15s |%15s |%15s |%15s |%15s |%15s |\n", rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));

            }

        } catch (Exception e) {
            System.out.println(e);

        }
        while (true) {
            System.out.println("ENTER THE OPTION ,TO DO WHAT YOU NEED");
            System.out.println("1. CHOOSE PRODUCTS IN THIS SECTION");
            System.out.println("2. CHANGE TO DIFFERENT SECTION WITHIN SAME DEPARTMENT ");
            System.out.println("3. CHANGE THE DEPARTMENT");
            System.out.println("4. GO TO CART");
            System.out.println("5. GO TO BILL");
            System.out.println("6.TO EXIT THE CODE");
            Scanner sc = new Scanner(System.in);

            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    Cart.select_product();
                    break;

                case 2:
                    try {
                        Department.DisplayDepartment(dn);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 3:
                    Jmart.Choose_Department();
                    break;
                case 4:

                    System.out.println(" ENTER THE OPTION \n1.TO SHOW THE CART \n2.TO EDIT THE QUANTITY\n3.TO DELETE THE PRODUCT");
                    int opt = sc.nextInt();
                    switch (opt){
                        case 1: Cart.show_cart();
                        break;
                        case 2:Cart.Edit_quantity();
                        break;
                        case 3:Cart.Delete_product();

                    }
                    break;
                case 5:
                    Billing.bill();
                    break;


            }if(ch ==6){
            
                break;
            }

        }
    }
}


