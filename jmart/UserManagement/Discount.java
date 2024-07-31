import java.util.Scanner;
public class Discount
{
    public static void discount(int total_price)
    {
        Scanner input = new Scanner(System.in);
        {
            if(total_price<=2000){
                System.out.println("NO DISCOUNT,FOR GETTING DISCOUNT YOU NEED TO BUY MORE THAN 5000Rs /-");
            }

            else if(total_price <= 5000 && total_price > 2000)
            {
                System.out.println("Discount Applicable");
                int final_price = total_price - total_price / 50;
                System.out.println("Enter 1 to Apply discount");
                System.out.println("Enter 0 to skip the discount");
                int ch = input.nextInt();
                switch(ch)
                {
                    case 0:
                    {
                        System.out.println("\t TOTAL AMOUNT IS:: "+ total_price);
                    }
                    case 1:
                    {
                        System.out.println("\t TOTAL AMOUNT IS AFTER DISCOUNT:: "+ final_price);
                    }
                }
            }
            else if(total_price <= 10000 && total_price > 5000 )
            {
                System.out.println("Discount Applicable");
                int final_price = total_price - total_price / 100;
                System.out.println("Enter 1 to Apply discount");
                System.out.println("Enter 0 to skip the discount");
                int ch = input.nextInt();
                switch(ch)
                {
                    case 0:
                    {
                        System.out.println("\t TOTAL AMOUNT IS:: "+ total_price);
                    }
                    case 1:
                    {
                        System.out.println("\t TOTAL AMOUNT IS AFTER DISCOUNT:: "+ final_price);
                    }
                }
            }
            else if(total_price <= 20000 && total_price > 10000 )
            {
                System.out.println("Discount Applicable");
                int final_price = total_price - total_price / 200;
                System.out.println("Enter 1 to Apply discount");
                System.out.println("Enter 0 to skip the discount");
                int ch = input.nextInt();
                switch(ch)
                {
                    case 0:
                    {
                        System.out.println("\t TOTAL AMOUNT IS:: "+ total_price);
                    }
                    case 1:
                    {
                        System.out.println("\t TOTAL AMOUNT IS AFTER DISCOUNT:: "+ final_price);
                    }
                }
            }
            else if(total_price <= 30000 && total_price > 20000 )
            {
                System.out.println("Discount Applicable");
                int final_price = total_price - total_price / 300;
                System.out.println("Enter 1 to Apply discount");
                System.out.println("Enter 0 to skip the discount");
                int ch = input.nextInt();
                switch(ch)
                {
                    case 0:
                    {
                        System.out.println("\t TOTAL AMOUNT IS:: "+ total_price);
                    }
                    case 1:
                    {
                        System.out.println("\t TOTAL AMOUNT IS AFTER DISCOUNT:: "+ final_price);
                    }
                }
            }
            else if(total_price > 30000)
            {
                System.out.println("Discount Applicable");
                int final_price = total_price - total_price / 500;
                System.out.println("Enter 1 to Apply discount");
                System.out.println("Enter 0 to skip the discount");
                int ch = input.nextInt();
                switch(ch)
                {
                    case 0:
                    {
                        System.out.println("\t TOTAL AMOUNT IS:: "+ total_price);
                    }
                    case 1:
                    {
                        System.out.println("\t TOTAL AMOUNT IS AFTER DISCOUNT:: "+ final_price);
                    }
                }
            }
        }

    }
}