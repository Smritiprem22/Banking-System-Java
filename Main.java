import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.loadFromFile();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Banking System ===");
            System.out.println("1. Create Account");
            System.out.println("2. View Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. View All Accounts");
            System.out.println("6. View Transaction History");
            System.out.println("7. Save Data");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Initial Deposit: ");
                    double dep = sc.nextDouble();
                    bank.createAccount(id, name, dep);
                    break;

                case 2:
                    System.out.print("Enter Account ID: ");
                    int aid = sc.nextInt();
                    Account acc = bank.getAccount(aid);
                    System.out.println((acc != null) ? acc : "Account not found.");
                    break;

                case 3:
                    System.out.print("Enter Account ID: ");
                    int did = sc.nextInt();
                    System.out.print("Amount to Deposit: ");
                    double dAmt = sc.nextDouble();
                    bank.deposit(did, dAmt);
                    break;

                case 4:
                    System.out.print("Enter Account ID: ");
                    int wid = sc.nextInt();
                    System.out.print("Amount to Withdraw: ");
                    double wAmt = sc.nextDouble();
                    bank.withdraw(wid, wAmt);
                    break;

                case 5:
                    bank.showAllAccounts();
                    break;

                case 6:
                    System.out.print("Enter Account ID: ");
                    int tid = sc.nextInt();
                    Account a = bank.getAccount(tid);
                    if (a != null) {
                        a.showTransactions();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 7:
                    bank.saveToFile();
                    break;

                case 0:
                    bank.saveToFile();
                    System.out.println("Exiting. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
        sc.close();
    }
}
