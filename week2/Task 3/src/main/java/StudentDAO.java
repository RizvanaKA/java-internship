
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {

    // Add a new student
    public void addStudent(String name, int age, String gender,
            String email, String phone, String department,
            String course, int semester, double grade) {

        String sql = "INSERT INTO students (name, age, gender, email, phone, department, course, semester, grade) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection()) {
            if (con == null) return;

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, gender);
            ps.setString(4, email);
            ps.setString(5, phone);
            ps.setString(6, department);
            ps.setString(7, course);
            ps.setInt(8, semester);
            ps.setDouble(9, grade);

            ps.executeUpdate();
            System.out.println("Student added successfully!");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // View all students
    public void viewStudents() {
        String sql = "SELECT * FROM students";

        try (Connection con = DBConnection.getConnection()) {
            if (con == null) return;

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("\n========== STUDENT DETAILS ==========");

            while (rs.next()) {
                System.out.println("ID         : " + rs.getInt("id"));
                System.out.println("Name       : " + rs.getString("name"));
                System.out.println("Age        : " + rs.getInt("age"));
                System.out.println("Gender     : " + rs.getString("gender"));
                System.out.println("Email      : " + rs.getString("email"));
                System.out.println("Phone      : " + rs.getString("phone"));
                System.out.println("Department : " + rs.getString("department"));
                System.out.println("Course     : " + rs.getString("course"));
                System.out.println("Semester   : " + rs.getInt("semester"));
                System.out.println("Grade      : " + rs.getDouble("grade"));
                System.out.println("-------------------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Search student by ID
    public void searchStudent(int id) {
        String sql = "SELECT * FROM students WHERE id = ?";

        try (Connection con = DBConnection.getConnection()) {
            if (con == null) return;

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Student found: " + rs.getString("name"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Course: " + rs.getString("course"));
                System.out.println("Grade: " + rs.getDouble("grade"));
            } else {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Update student grade
    public void updateGrade(int id, double grade) {
        String sql = "UPDATE students SET grade = ? WHERE id = ?";

        try (Connection con = DBConnection.getConnection()) {
            if (con == null) return;

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, grade);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student grade updated successfully!");
            } else {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Delete student
    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection con = DBConnection.getConnection()) {
            if (con == null) return;

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
