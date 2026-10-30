import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        int choice;

        do {
            System.out.println("\n LIBRARY MANAGEMENT SYSTEM ");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Remove Book");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter Book ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter Book Title: ");
                        String title = sc.nextLine();

                        System.out.print("Enter Author Name: ");
                        String author = sc.nextLine();

                        Book book = new Book(id, title, author);
                        library.addBook(book);
                        break;

                    case 2:
                        library.viewBooks();
                        break;

                    case 3:
                        System.out.print("Enter Book ID to search: ");
                        int searchId = Integer.parseInt(sc.nextLine());
                        library.searchBook(searchId);
                        break;

                    case 4:
                        System.out.print("Enter Book ID to issue: ");
                        int issueId = Integer.parseInt(sc.nextLine());
                        library.issueBook(issueId);
                        break;

                    case 5:
                        System.out.print("Enter Book ID to return: ");
                        int returnId = Integer.parseInt(sc.nextLine());
                        library.returnBook(returnId);
                        break;

                    case 6:
                        System.out.print("Enter Book ID to remove: ");
                        int removeId = Integer.parseInt(sc.nextLine());
                        library.removeBook(removeId);
                        break;

                    case 7:
                        System.out.println("Thank you for using the library");
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                choice = 0;
            }

        } while (choice != 7);

        sc.close();
    }
}