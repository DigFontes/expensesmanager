import java.util.ArrayList;
import java.util.List;

public class CreditCard {
    private double limit;
    private double accountBalance;
    private List<Purchase> purchases;

    public CreditCard(double limit) {
        this.limit = limit;
        this.accountBalance = limit;
        this.purchases = new ArrayList<>();
    }

    public boolean insertPurchase(Purchase purchase) {
        if(this.accountBalance >= purchase.getValue()) {
            this.accountBalance -= purchase.getValue();
            this.purchases.add(purchase);
            return true;
        }
        return false;
    }

    public double getLimit() {
        return limit;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }
}
