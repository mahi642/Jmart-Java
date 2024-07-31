abstract class tax{
    abstract   double findcgst(double  amount);
}
public class Gst extends tax {
        @Override
       double  findcgst(double amount) {
        double tax = 0;
        if (amount < 1000) {
            tax = 0.05;
            amount = amount + amount * tax;
            System.out.println("Amount after  adding tax "+amount);
            return amount;
        } else if (amount >= 1000 && amount < 5000) {
            tax = 0.12;
            amount = amount + (amount * tax);
            System.out.println(" amount after adding tax "+amount);
            return amount;

        } else if (amount >= 5000 && amount < 10000) {
            tax = 0.18;
            amount = amount + (amount * tax);
            System.out.println(" amount after adding tax "+amount);
            return  amount;

        } else {
            tax = 0.28;
            amount = amount + (amount * 0.28);
            System.out.println(" amount after adding tax "+amount);
            return amount;
        }

    }
}