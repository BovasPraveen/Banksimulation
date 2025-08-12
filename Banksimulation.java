import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Account class with deposit, withdraw, and history
class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private List<String> transactionHistory;

    public Account(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: ₹" + initialBalance);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        transactionHistory.add("Deposited: ₹" + amount + " | Balance: ₹" + balance);
        System.out.println("Deposit successful! New Balance: ₹" + balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }
        balance -= amount;
        transactionHistory.add("Withdrew: ₹" + amount + " | Balance: ₹" + balance);
        System.out.println("Withdrawal successful! New Balance: ₹" + balance);
    }

    public void showBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public void showTransactionHistory() {
        System.out.println("\nTransaction History for " + accountHolder + ":");
        for (String record : transactionHistory) {
            System.out.println(record);
        }
    }
}

// Main program to simulate banking
public class BankSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create an account
        System.out.print("Enter account number: ");
        String accNo = sc.nextLine();
        System.out.print("Enter account holder name: ");
        String accHolder = sc.nextLine();
        System.out.print("Enter initial balance: ₹");
        double initialBalance = sc.nextDouble();

        Account account = new Account(accNo, accHolder, initialBalance);

        // Menu-driven banking
        int choice;
        do {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ₹");
                    account.deposit(sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    account.withdraw(sc.nextDouble());
                    break;
                case 3:
                    account.showBalance();
                    break;
                case 4:
                    account.showTransactionHistory();
                    break;
                case 5:
                    System.out.println("Thank you for banking with us!");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}