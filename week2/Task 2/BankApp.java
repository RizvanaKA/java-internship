
import java.util.Scanner;

public class BankApp {

    private Bankaccount account;
    private Scanner sc;

    // Constructor
    public BankApp(Scanner sc) {
        this.sc = sc;
    }

    // Read integer safely
    private int readInt(String message) {

        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }

    // Read decimal number safely
    private double readDouble(String message) {

        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount! Please enter a number.");
            }
        }
    }

    // Read and validate PIN
    private String readPin(String message) {

        while (true) {
            System.out.print(message);
            String pin = sc.nextLine();

            if (pin.matches("\\d{4}")) {
                return pin;
            }

            System.out.println("PIN must contain exactly 4 digits.");
        }
    }

    // Verify account PIN
    private boolean authenticate() {

        String enteredPin = readPin("Enter your 4-digit PIN: ");

        if (account.verifyPin(enteredPin)) {
            return true;
        }

        System.out.println("Incorrect PIN!");
        return false;
    }

    // Create bank account
    public void createAccount() {

        if (account != null) {
            System.out.println("An account has already been created.");
            return;
        }

        System.out.println("\n===== CREATE BANK ACCOUNT =====");

        String accountNumber;

        while (true) {
            System.out.print("Enter 11-Digit Account Number: ");
            accountNumber = sc.nextLine();

            if (accountNumber.matches("\\d{11}")) {
                break;
            }

            System.out.println("Invalid account number!");
            System.out.println("Please enter exactly 11 digits.");
        }

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        System.out.println("\nSelect Account Type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");

        int typeChoice = readInt("Enter Choice: ");

        String accountType;
        double minimumBalance;

        if (typeChoice == 1) {
            accountType = "Savings";
            minimumBalance = 1000;
        } else if (typeChoice == 2) {
            accountType = "Current";
            minimumBalance = 5000;
        } else {
            System.out.println("Invalid account type.");
            return;
        }

        double balance = readDouble("Enter Opening Balance: ");

        if (balance < minimumBalance) {
            System.out.println(
                "Opening balance must be at least " + minimumBalance
            );
            return;
        }

        String pin = readPin("Create a 4-digit PIN: ");
        String confirmPin = readPin("Confirm your PIN: ");

        if (!pin.equals(confirmPin)) {
            System.out.println("PIN does not match. Account not created.");
            return;
        }

        account = new Bankaccount(
            accountNumber, name, phone, email, address,
            accountType, balance, minimumBalance, pin
        );

        System.out.println("\nAccount created successfully!");
    }

    // Deposit money
    public void depositMoney() {

        if (!checkAccount()) {
            return;
        }

        try {
            double amount = readDouble("Enter Deposit Amount: ");
            account.deposit(amount);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // Withdraw money
    public void withdrawMoney() {

        if (!checkAccount()) {
            return;
        }

        if (!authenticate()) {
            return;
        }

        try {
            double amount = readDouble("Enter Withdrawal Amount: ");
            account.withdraw(amount);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // Check balance
    public void checkBalance() {

        if (!checkAccount()) {
            return;
        }

        account.displayBalance();
    }

    // View account details
    public void viewAccountDetails() {

        if (!checkAccount()) {
            return;
        }

        account.displayAccountDetails();
    }

    // View transaction history
    public void viewTransactions() {

        if (!checkAccount()) {
            return;
        }

        account.displayTransactions();
    }

    // Change PIN
    public void changeAccountPin() {

        if (!checkAccount()) {
            return;
        }

        System.out.println("\n========== CHANGE PIN ==========");

        if (!authenticate()) {
            return;
        }

        String newPin = readPin("Enter New 4-Digit PIN: ");
        String confirmPin = readPin("Confirm New PIN: ");

        if (!newPin.equals(confirmPin)) {
            System.out.println("PIN does not match!");
            return;
        }

        if (newPin.equals(readExistingPinCheck(newPin))) {
            System.out.println("New PIN must be different from the old PIN.");
            return;
        }

        account.changePin(newPin);
    }

    // Check whether new PIN is same as existing PIN
    private String readExistingPinCheck(String newPin) {
        return account.verifyPin(newPin) ? newPin : "";
    }

    // Delete account
    public void deleteAccount() {

        if (!checkAccount()) {
            return;
        }

        System.out.println("\n========== DELETE ACCOUNT ==========");
        System.out.println("Account Number: " + accountNumberForDisplay());
        System.out.println("This action will permanently remove this account from this application.");

        System.out.print("Are you sure you want to delete? (yes/no): ");
        String confirmation = sc.nextLine();

        if (!confirmation.equalsIgnoreCase("yes")) {
            System.out.println("Account deletion cancelled.");
            return;
        }

        if (!authenticate()) {
            return;
        }

        account = null;

        System.out.println("Account deleted successfully!");
    }

    // Account number for deletion confirmation
    private String accountNumberForDisplay() {
        return account.getAccountNumber();
    }

    // Check account existence
    private boolean checkAccount() {

        if (account == null) {
            System.out.println("Please create an account first.");
            return false;
        }

        return true;
    }

    // Display banking menu
    public void showMenu() {

        int choice;

        do {
            System.out.println("\n=================================");
            System.out.println("       BANKING APPLICATION");
            System.out.println("=================================");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Balance Inquiry");
            System.out.println("5. View Account Details");
            System.out.println("6. Transaction History");
            System.out.println("7. Change PIN");
            System.out.println("8. Delete Account");
            System.out.println("9. Exit");
            System.out.println("=================================");

            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    createAccount();
                    break;

                case 2:
                    depositMoney();
                    break;

                case 3:
                    withdrawMoney();
                    break;

                case 4:
                    checkBalance();
                    break;

                case 5:
                    viewAccountDetails();
                    break;

                case 6:
                    viewTransactions();
                    break;

                case 7:
                    changeAccountPin();
                    break;

                case 8:
                    deleteAccount();
                    break;

                case 9:
                    System.out.println(
                        "Thank you for using our banking application."
                    );
                    break;

                default:
                    System.out.println("Invalid choice! Select 1 to 9.");
            }

        } while (choice != 9);
    }
}
