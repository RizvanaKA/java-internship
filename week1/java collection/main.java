import java.util.Scanner;

public class main {

public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    collectionmgr manager = new collectionmgr();

    int choice = 0;

    do {
        System.out.println("\n===== JAVA COLLECTIONS CHALLENGE =====");
        System.out.println("1. ArrayList Operations");
        System.out.println("2. HashMap Operations");
        System.out.println("3. Queue Operations");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");

        try {
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    arrayListMenu(sc, manager);
                    break;

                case 2:
                    hashMapMenu(sc, manager);
                    break;

                case 3:
                    queueMenu(sc, manager);
                    break;

                case 4:
                    System.out.println("Thank you for using Java Collections Challenge!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            choice = 0;
        }

    } while (choice != 4);

    sc.close();
}

// ArrayList Menu
public static void arrayListMenu(Scanner sc, collectionmgr manager) {

    int choice = 0;

    do {
        System.out.println("\n--- ARRAYLIST MENU ---");
        System.out.println("1. Add Item");
        System.out.println("2. View Items");
        System.out.println("3. Search Item");
        System.out.println("4. Update Item");
        System.out.println("5. Remove Item");
        System.out.println("6. Back to Main Menu");
        System.out.print("Enter your choice: ");

        try {
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Enter item name: ");
                    manager.addItem(sc.nextLine());
                    break;

                case 2:
                    manager.viewItems();
                    break;

                case 3:
                    System.out.print("Enter item to search: ");
                    manager.searchItem(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Enter old item name: ");
                    String oldItem = sc.nextLine();

                    System.out.print("Enter new item name: ");
                    String newItem = sc.nextLine();

                    manager.updateItem(oldItem, newItem);
                    break;

                case 5:
                    System.out.print("Enter item to remove: ");
                    manager.removeItem(sc.nextLine());
                    break;

                case 6:
                    System.out.println("Returning to main menu...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            choice = 0;
        }

    } while (choice != 6);
}

// HashMap Menu
public static void hashMapMenu(Scanner sc, collectionmgr manager) {

    int choice = 0;

    do {
        System.out.println("\n--- HASHMAP MENU ---");
        System.out.println("1. Add Student");
        System.out.println("2. View Student");
        System.out.println("3. Update Student");
        System.out.println("4. Back to Main Menu");
        System.out.print("Enter your choice: ");

        try {
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Enter student ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();

                    manager.addStudent(id, name);
                    break;

                case 2:
                    System.out.print("Enter student ID: ");
                    int searchId = Integer.parseInt(sc.nextLine());

                    manager.viewStudent(searchId);
                    break;

                case 3:
                    System.out.print("Enter student ID: ");
                    int updateId = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter new student name: ");
                    String updatedName = sc.nextLine();

                    manager.updateStudent(updateId, updatedName);
                    break;

                case 4:
                    System.out.println("Returning to main menu...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            choice = 0;
        }

    } while (choice != 4);
}

// Queue Menu
public static void queueMenu(Scanner sc, collectionmgr manager) {

    int choice = 0;

    do {
        System.out.println("\n--- QUEUE MENU ---");
        System.out.println("1. Add Customer");
        System.out.println("2. Remove Customer");
        System.out.println("3. View Queue");
        System.out.println("4. Back to Main Menu");
        System.out.print("Enter your choice: ");

        try {
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Enter customer name: ");
                    manager.addCustomer(sc.nextLine());
                    break;

                case 2:
                    manager.removeCustomer();
                    break;

                case 3:
                    manager.viewQueue();
                    break;

                case 4:
                    System.out.println("Returning to main menu...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            choice = 0;
        }

    } while (choice != 4);
}

}