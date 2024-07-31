
    import java.sql.*;
    import java.util.Scanner;

    public class Search
    {
        public static void Search_Product(String Pro_name)
        {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops", "root", "Mahi@642");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from all_products where Product_name = '" + Pro_name + "'");
                System.out.printf("%15s |%15s |%15s |%15s |%15s |%15s |%15s \n","Section Name", "Section ID", "Product ID", "Product Name", "Product Price", "product Quantity", "TaxRate");
                while (rs.next()) {
                    System.out.println("------------------------------------------------------------------------------------------------------");
                    System.out.printf("%15s |%15s |%15s |%15s |%15s |%15s |%15s |\n", rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));

                }

            }
            catch (Exception e)
            {
                System.out.println(e);

            }
        }
        public  static void search_by_id(){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oops", "root", "Mahi@642");
                Statement st = con.createStatement();
                Scanner scan = new Scanner(System.in);
                System.out.println("ENTER THE PRODUCT ID TO SEARCH");
                int pro_id = scan.nextInt();
                ResultSet rs = st.executeQuery("select * from all_products where Product_id = "+pro_id);
                System.out.printf("%15s |%15s |%15s |%15s |%15s |%15s |%15s \n","Section Name", "Section ID", "Product ID", "Product Name", "Product Price", "product Quantity", "TaxRate");
                while (rs.next()) {
                    System.out.println("------------------------------------------------------------------------------------------------------");
                    System.out.printf("%15s |%15s |%15s |%15s |%15s |%15s |%15s |\n", rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));

                }

            }
            catch (Exception e)
            {
                System.out.println(e);

            }

        }
    }



