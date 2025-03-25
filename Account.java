import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Account implements Serializable {
    private int accountId;
    private String name;
    private double balance;
    private List<Transaction> transactionHistory;

    public Account(int accountId, String name, double initialDeposit) {
        this.accountId = accountId;
        this.name = name;
        this.balance = initialDeposit;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add(new Transaction("Deposit", initialDeposit));
    }

    public int getAccountId() { return accountId; }
    public String getName() { return name; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        transactionHistory.add(new Transaction("Withdraw", amount));
        return true;
    }

    public void showTransactions() {
        for (Transaction t : transactionHistory) {
            System.out.println(t);
        }
    }

    public String toString() {
        return "Account ID: " + accountId + ", Name: " + name + ", Balance: ₹" + balance;
    }
}

