import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        for (Book b : books) {
            if (b.getId() == book.getId()) {
                System.out.println("Book ID already exists");
                return;
            }
        }

        books.add(book);
        System.out.println("Book added successfully");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : books) {
            book.displayBook();
        }
    }

    public void searchBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                book.displayBook();
                return;
            }
        }

        System.out.println("Book not found.");
    }

    public void issueBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                if (book.isIssued()) {
                    System.out.println("Book is already issued.");
                } else {
                    book.issueBook();
                    System.out.println("Book issued successfully");
                }
                return;
            }
        }

        System.out.println("Book not found.");
    }

    public void returnBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                if (book.isIssued()) {
                    book.returnBook();
                    System.out.println("Book returned successfully");
                } else {
                    System.out.println("Book was not issued.");
                }
                return;
            }
        }

        System.out.println("Book not found.");
    }

    public void removeBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                if (book.isIssued()) {
                    System.out.println("Return the book before removing it.");
                } else {
                    books.remove(book);
                    System.out.println("Book removed successfully");
                }
                return;
            }
        }

        System.out.println("Book not found.");
    }
}
