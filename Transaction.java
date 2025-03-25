import java.io.Serializable;
import java.util.Date;

public class Transaction implements Serializable {
    private String type; // Deposit or Withdraw
    private double amount;
    private Date date;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.date = new Date(); // current timestamp
    }

    public String toString() {
        return type + " of ₹" + amount + " on " + date;
    }
}

