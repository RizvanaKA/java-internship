
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        int choice;

        do {
            System.out.println("\n==================================");
            System.out.println("       STUDENT MANAGEMENT SYSTEM");
            System.out.println("==================================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student Grade");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.println("==================================");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("\n--- Add Student ---");

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Gender: ");
                    String gender = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter Semester: ");
                    int semester = sc.nextInt();

                    System.out.print("Enter Grade: ");
                    double grade = sc.nextDouble();

                    dao.addStudent(name, age, gender, email,
                            phone, department, course, semester, grade);
                    break;

                case 2:
                    dao.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID to search: ");
                    int searchId = sc.nextInt();
                    dao.searchStudent(searchId);
                    break;

                case 4:
                    System.out.print("Enter Student ID: ");
                    int updateId = sc.nextInt();

                    System.out.print("Enter New Grade: ");
                    double newGrade = sc.nextDouble();

                    dao.updateGrade(updateId, newGrade);
                    break;

                case 5:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = sc.nextInt();

                    dao.deleteStudent(deleteId);
                    break;

                case 6:
                    System.out.println("Thank you for using Student Management System!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}
