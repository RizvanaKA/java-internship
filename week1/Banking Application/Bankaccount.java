
public class Bankaccount {
    private double balance;

    public Bankaccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
        } else {
            balance = balance + amount;
            System.out.println("Deposit successful.");
            System.out.printf("Current Balance: %.2f%n", balance);
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance = balance - amount;
            System.out.println("Withdrawal successful.");
            System.out.printf("Current Balance: %.2f%n", balance);
        }
    }

    public double getBalance() {
        return balance;
    }
}
