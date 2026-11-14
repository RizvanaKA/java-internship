
import java.util.ArrayList;

public class Bankaccount {

    private String accountNumber;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String accountType;
    private String pin;

    private double balance;
    private double minimumBalance;
    private String accountStatus;

    private ArrayList<String> transactions;

    // Constructor
    public Bankaccount(String accountNumber, String name,
                       String phone, String email, String address,
                       String accountType, double balance,
                       double minimumBalance, String pin) {

        this.accountNumber = accountNumber;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.accountType = accountType;
        this.balance = balance;
        this.minimumBalance = minimumBalance;
        this.pin = pin;
        this.accountStatus = "Active";

        transactions = new ArrayList<>();

        transactions.add("Account created. Opening balance: " + balance);
    }

    // Verify PIN
    public boolean verifyPin(String enteredPin) {
        return pin.equals(enteredPin);
    }

    // Change PIN
    public void changePin(String newPin) {
        pin = newPin;
        transactions.add("Account PIN changed.");
        System.out.println("PIN changed successfully!");
    }

    // Deposit money
    public void deposit(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Deposit amount must be greater than zero."
            );
        }

        balance += amount;

        transactions.add("Deposited: " + amount);

        System.out.println("Amount deposited successfully!");
        System.out.println("Current Balance: " + balance);
    }

    // Withdraw money
    public void withdraw(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Withdrawal amount must be greater than zero."
            );
        }

        if (balance - amount < minimumBalance) {
            throw new IllegalArgumentException(
                "Insufficient balance! Minimum balance is "
                + minimumBalance
            );
        }

        balance -= amount;

        transactions.add("Withdrawn: " + amount);

        System.out.println("Amount withdrawn successfully!");
        System.out.println("Current Balance: " + balance);
    }
    // Get account number
public String getAccountNumber() {
    return accountNumber;
}

    // Display balance
    public void displayBalance() {

        System.out.println("\n========== ACCOUNT BALANCE ==========");
        System.out.println("Account Holder: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Available Balance: " + balance);
    }

    // Display account details
    public void displayAccountDetails() {

        System.out.println("\n========== ACCOUNT DETAILS ==========");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: " + balance);
        System.out.println("Minimum Balance: " + minimumBalance);
        System.out.println("Account Status: " + accountStatus);
    }

    // Display transaction history
    public void displayTransactions() {

        System.out.println("\n========== TRANSACTION HISTORY ==========");

        if (transactions.isEmpty()) {
            System.out.println("No transactions available.");
            return;
        }

        for (int i = 0; i < transactions.size(); i++) {
            System.out.println((i + 1) + ". " + transactions.get(i));
        }
    }
}
