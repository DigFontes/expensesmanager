import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Type your credit card limit: ");
        double limit = reader.nextDouble();
        CreditCard card = new CreditCard(limit);

        int exit = 1;
        while(exit != 0) {
            System.out.println("Type the description of this purchase:");
            String description = reader.next();

            System.out.println("Type the value of this purchase:");
            double value = reader.nextDouble();

            Purchase Purchase = new Purchase(description, value);
            boolean PurchaseExecuted = card.insertPurchase(Purchase);

            if (PurchaseExecuted) {
                System.out.println("Purchase executed succesfully!");
                System.out.println("Type 0 to exit or 1 to keep purchasing");
                exit = reader.nextInt();
            } else {
                System.out.println("Your account is out of balance!");
                exit = 0;
            }
        }

        System.out.println("***********************");
        System.out.println("Purchases executed:\n");
        Collections.sort(card.getPurchases());
        for (Purchase p : card.getPurchases()) {
            System.out.println(p.getDescription() + " - " +p.getValue());
        }
        System.out.println("\n***********************");

        System.out.println("\nCredit card balance: " +card.getAccountBalance());
    }


}