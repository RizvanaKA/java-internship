
import java.util.Scanner;

public class BankingApp {
    private Bankaccount account;
    private Scanner sc;

    public BankingApp() {
        account = new Bankaccount(10000.00);
        sc = new Scanner(System.in);
    }

    public void start() {
        int choice = 0;

        do {
            System.out.println("\n===== BANKING APPLICATION =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance Inquiry");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount =
                                Double.parseDouble(sc.nextLine());
                        account.deposit(depositAmount);
                        break;

                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount =
                                Double.parseDouble(sc.nextLine());
                        account.withdraw(withdrawAmount);
                        break;

                    case 3:
                        System.out.printf(
                                "Current Balance: %.2f%n",
                                account.getBalance());
                        break;

                    case 4:
                        System.out.println(
                                "Thank you for using the Banking Application!");
                        break;

                    default:
                        System.out.println(
                                "Invalid choice. Please try again.");
                }

            } catch (NumberFormatException e) {
                System.out.println(
                        "Invalid input. Please enter a numeric value.");
                choice = 0;
            }

        } while (choice != 4);

        sc.close();
    }
}
