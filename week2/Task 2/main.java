
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("       WELCOME TO OUR BANK");
        System.out.println("====================================");

        BankApp bankApp = new BankApp(sc);

        bankApp.showMenu();

        sc.close();

        System.out.println("Banking Application Closed.");
    }
}
