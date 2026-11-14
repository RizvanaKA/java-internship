
import java.util.ArrayList;
import java.util.Scanner;

public class studentmanager {

    ArrayList<student> students = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    // 1. Add Student
    public void addStudent() {

        System.out.println("\n===== ADD STUDENT =====");

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        // Check duplicate ID
        for (student s : students) {
            if (s.getId() == id) {
                System.out.println("Student ID already exists!");
                return;
            }
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();

        System.out.print("Enter Date of Birth: ");
        String dob = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        System.out.print("Enter Semester: ");
        int semester = sc.nextInt();

        System.out.print("Enter Grade: ");
        double grade = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Subjects: ");
        String subjects = sc.nextLine();

        System.out.print("Enter Attendance (%): ");
        double attendance = sc.nextDouble();

        if (age <= 0 || semester <= 0 ||
                grade < 0 || grade > 100 ||
                attendance < 0 || attendance > 100) {

            System.out.println("Invalid student details!");
            return;
        }

        student student = new student(
                id, name, age, gender, dob, email,
                phone, address, department, course,
                semester, grade, subjects, attendance
        );

        students.add(student);

        System.out.println("Student added successfully!");
    }

    // 2. Display All Students
    public void displayAllstudents() {

        System.out.println("\n===== ALL STUDENTS =====");

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        for (student s : students) {
            s.displaystudent();
        }
    }

    // 3. Search Student by ID
    public void searchById() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        for (student s : students) {

            if (s.getId() == id) {
                System.out.println("Student Found!");
                s.displaystudent();
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // 4. Search Student by Name
    public void searchByName() {

        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        boolean found = false;

        for (student s : students) {

            if (s.getName().equalsIgnoreCase(name)) {
                s.displaystudent();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    // 5. Update Student Details
    public void updatestudent() {

        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();

        for (student s : students) {

            if (s.getId() == id) {

                System.out.println("1. Update Name");
                System.out.println("2. Update Age");
                System.out.println("3. Update Email");
                System.out.println("4. Update Phone");
                System.out.println("5. Update Address");
                System.out.println("6. Update Grade");
                System.out.println("7. Update Subjects");
                System.out.println("8. Update Attendance");

                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        System.out.print("Enter New Name: ");
                        s.setName(sc.nextLine());
                        break;

                    case 2:
                        System.out.print("Enter New Age: ");
                        int age = sc.nextInt();
                        if (age > 0) {
                            s.setAge(age);
                        } else {
                            System.out.println("Invalid age.");
                            return;
                        }
                        break;

                    case 3:
                        System.out.print("Enter New Email: ");
                        s.setEmail(sc.nextLine());
                        break;

                    case 4:
                        System.out.print("Enter New Phone: ");
                        s.setPhone(sc.nextLine());
                        break;

                    case 5:
                        System.out.print("Enter New Address: ");
                        s.setAddress(sc.nextLine());
                        break;

                    case 6:
                        System.out.print("Enter New Grade: ");
                        double grade = sc.nextDouble();
                        if (grade >= 0 && grade <= 100) {
                            s.setGrade(grade);
                        } else {
                            System.out.println("Invalid grade.");
                            return;
                        }
                        break;

                    case 7:
                        System.out.print("Enter New Subjects: ");
                        s.setSubjects(sc.nextLine());
                        break;

                    case 8:
                        System.out.print("Enter New Attendance: ");
                        double attendance = sc.nextDouble();
                        if (attendance >= 0 && attendance <= 100) {
                            s.setAttendance(attendance);
                        } else {
                            System.out.println("Invalid attendance.");
                            return;
                        }
                        break;

                    default:
                        System.out.println("Invalid choice.");
                        return;
                }

                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // 6. Delete Student
    public void deletestudent() {

        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        for (student s : students) {

            if (s.getId() == id) {

                System.out.print("Confirm deletion? (yes/no): ");
                sc.nextLine();
                String confirm = sc.nextLine();

                if (confirm.equalsIgnoreCase("yes")) {
                    students.remove(s);
                    System.out.println("Student deleted successfully!");
                } else {
                    System.out.println("Deletion cancelled.");
                }

                return;
            }
        }

        System.out.println("Student not found.");
    }

    // 7. Calculate Average Grade
    public void calculateAverage() {

        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        double total = 0;

        for (student s : students) {
            total += s.getGrade();
        }

        double average = total / students.size();

        System.out.println("Total Students: " + students.size());
        System.out.println("Average Grade: " + average);
    }
}
