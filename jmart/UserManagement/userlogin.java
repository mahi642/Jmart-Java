import java.sql.SQLException;
import java.util.Scanner;

class userlogin extends section{
    public static void user_login() throws SQLException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("ENTER THE NAME");
        String name = input.nextLine();
        System.out.println("ENTER 'user' FOR USERNAME AND PASSWORD TO LOGIN");
        String username, password;
        System.out.println("Enter username");
        username = input.next();
        System.out.println("Enter password");
        password = input.next();
        if (username.equals("user") && password.equals("user")) {
            System.out.println("Welcome " + name + "...!!");
            section.setCart_id();
            Enter_Jmart();
           // section.setCart_id();
        }
        else{
            System.out.println("ENTER USER FOR USERNAME AND PASSWORD");
            user_login();
        }
    }

    public static void Enter_Jmart() throws SQLException, ClassNotFoundException {

        Scanner input = new Scanner(System.in);
        System.out.println("1. To Enter Search Product by Jmart");
        System.out.println("2. To Enter Search Product by name");
        System.out.println("3.TO ENTER SEARCH BY PARTIAL SEARCH");
        System.out.println("4. TO ENTER SEARCH BY ID");
        //section.setCart_id();
        int ch = input.nextInt();
        switch (ch) {
            case 1: Jmart.Welcome_Message_mart();
                    Jmart.Choose_Department();
                    break;

            case 2: {
                System.out.println("Enter Product Name ");
                String pro_name = input.next();

                Search.Search_Product(pro_name);
                Cart.select_product();
                System.out.println("Want to add more products enter 1");
                System.out.println("Go to Cart - 2");
                System.out.println("Go to Bill - 3");
                int cho = input.nextInt();

                    switch (cho) {
                        case 1: {
                            Enter_Jmart();
                            break;
                        }
                        case 2: {
                            fun();

                            break;
                        }

                        case 3: {
                            Billing.bill();
                            break;
                        }
                    }
                    break;


            }
            case 3:



                PartialSearch.psearch();
                Cart.select_product();

                System.out.println("Want to add more products enter 1");
                System.out.println("Go to Cart - 2");
                System.out.println("Go to Bill - 3");
                int choi = input.nextInt();
                switch (choi) {
                    case 1:
                    {
                        Enter_Jmart();
                        break;
                    }
                    case 2:
                    {
                        fun();
                        break;

                    }
                    case 3:
                    {
                        Billing.bill();
                        break;
                    }
                }

            case 4: {

                Search.search_by_id();
                Cart.select_product();
                System.out.println("Want to add more products enter 1");
                System.out.println("Go to Cart - 2");
                System.out.println("Go to Bill - 3");
                int choic = input.nextInt();
                switch (choic) {
                    case 1:
                    {
                        Enter_Jmart();
                        break;
                    }
                    case 2: {
                        fun();
                        break;
                    }
                    case 3:
                    {
                        Billing.bill();
                        break;
                    }
                }
                break;
            }


        }
    }

//import java.sql.SQLException;
//import java.util.Scanner;
//
//class userlogin {
//    public static void UserLogin() throws SQLException, ClassNotFoundException {
//
//        Scanner input = new Scanner(System.in);
//
//        System.out.println("ENTER THE NAME");
//        String name = input.nextLine();
//        System.out.println("ENTER 'user' FOR USERNAME AND PASSWORD TO LOGIN");
//        String username, password;
//        System.out.println("Enter username");
//        username = input.next();
//
//        System.out.println("Enter password");
//        password = input.next();
//
//        if (username.equals("user") && password.equals("user")) {
//            System.out.println("welcome " + name + "...!!");
//            System.out.println("1. To Enter Search Product by Jmart");
//            System.out.println("2. To Enter Search Product by name");
//            System.out.println("3.TO ENTER SEARCH BY PARTIAL SEARCH");
//            System.out.println("4. TO ENTER SEARCH BY ID");
//            int ch = input.nextInt();
//            switch (ch) {
//                case 1:
//                    Jmart.Welcome_Message_mart();
//                    Jmart.Choose_Department();
//                    break;
//
//                case 2:
//
//                    System.out.println("Enter Product Name ");
//                    String pro_name = input.next();
//                    section.setCart_id();
//                    Search.Search_Product(pro_name);
//                    Cart.select_product();
//                {
//                    System.out.println("eneter 1 to cart and 2 to bill");
//                    int option = input.nextInt();
//                    switch (option) {
//
//                        case 1:
//
//                            System.out.println(" ENTER THE OPTION \n1.TO SHOW THE CART \n2.TO EDIT THE QUANTITY\n3.TO DELETE THE PRODUCT");
//                            int opt = input.nextInt();
//                            switch (opt) {
//                                case 1:
//                                    Cart.show_cart();
//                                    break;
//                                case 2:
//                                    Cart.Edit_quantity();
//                                    break;
//                                case 3:
//                                    Cart.Delete_product();
//
//                            }
//                            break;
//                        case 2:
//                            Billing.bill();
//                    }
//                }
//
//                break;
//
//
//                case 3:
//
//                    section.setCart_id();
//                    PartialSearch.psearch();
//                    Cart.select_product();
//
//                    break;
//                case 4:
//                    section.setCart_id();
//                    Search.search_by_id();
//                    Cart.select_product();
//
//            }
//        } else {
//            System.out.println("enter user for username and user for password to login");
//        }
//
//    }
//}


public static void fun() {
    while (true) {
        System.out.println(" ENTER THE OPTION \n1.TO SHOW THE CART \n2.TO EDIT THE QUANTITY\n3.TO DELETE THE PRODUCT\n4.go to bill\n5.TO EXIT");
        Scanner in = new Scanner(System.in);
        int opt = in.nextInt();
        switch (opt) {
            case 1: {
                Cart.show_cart();
                break;
            }
            case 2: {
                Cart.Edit_quantity();
                break;
            }
            case 3: {
                Cart.Delete_product();
                break;
            }
            case 4:
                Billing.bill();
                break;
            case 5:

                break;
        }
         if(opt==5){
             break;
         }
    }

}
}
