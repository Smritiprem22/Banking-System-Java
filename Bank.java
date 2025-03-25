import java.io.*;
import java.util.*;

public class Bank {
    private Map<Integer, Account> accounts = new HashMap<>();

    // Add a new account
    public void createAccount(int id, String name, double deposit) {
        if (accounts.containsKey(id)) {
            System.out.println("Account ID already exists.");
            return;
        }
        Account acc = new Account(id, name, deposit);
        accounts.put(id, acc);
        System.out.println("Account created!");
    }

    // View account by ID
    public Account getAccount(int id) {
        return accounts.get(id);
    }

    // Deposit
    public void deposit(int id, double amount) {
        Account acc = accounts.get(id);
        if (acc != null) {
            acc.deposit(amount);
            System.out.println("Deposited ₹" + amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Withdraw
    public void withdraw(int id, double amount) {
        Account acc = accounts.get(id);
        if (acc != null) {
            if (acc.withdraw(amount)) {
                System.out.println("Withdrawn ₹" + amount);
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    // View all accounts
    public void showAllAccounts() {
        for (Account acc : accounts.values()) {
            System.out.println(acc);
        }
    }

    // Save to file
    public void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("bank_data.dat"))) {
            out.writeObject(accounts);
            System.out.println("Bank data saved.");
        } catch (Exception e) {
            System.out.println("Error saving: " + e.getMessage());
        }
    }

    // Load from file
    public void loadFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("bank_data.dat"))) {
            accounts = (Map<Integer, Account>) in.readObject();
            System.out.println("Bank data loaded.");
        } catch (Exception e) {
            System.out.println("Error loading: " + e.getMessage());
        }
    }
}

