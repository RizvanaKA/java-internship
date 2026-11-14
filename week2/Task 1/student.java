
public class student {

    // Student details
    private int id;
    private String name;
    private int age;
    private String gender;
    private String dob;
    private String email;
    private String phone;
    private String address;
    private String department;
    private String course;
    private int semester;
    private double grade;
    private String subjects;
    private double attendance;

    // Constructor
    public student(int id, String name, int age,
            String gender, String dob, String email,
            String phone, String address, String department,
            String course, int semester, double grade,
            String subjects, double attendance) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.department = department;
        this.course = course;
        this.semester = semester;
        this.grade = grade;
        this.subjects = subjects;
        this.attendance = attendance;
    }

    // Getter methods

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getDepartment() {
        return department;
    }

    public String getCourse() {
        return course;
    }

    public int getSemester() {
        return semester;
    }

    public double getGrade() {
        return grade;
    }

    public String getSubjects() {
        return subjects;
    }

    public double getAttendance() {
        return attendance;
    }

    // Setter methods

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public void setAttendance(double attendance) {
        this.attendance = attendance;
    }

    // Display student details

    public void displaystudent() {

        System.out.println("\n========== STUDENT DETAILS ==========");

        System.out.println("Student ID : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Gender     : " + gender);
        System.out.println("Date of Birth : " + dob);
        System.out.println("Email      : " + email);
        System.out.println("Phone      : " + phone);
        System.out.println("Address    : " + address);
        System.out.println("Department : " + department);
        System.out.println("Course     : " + course);
        System.out.println("Semester   : " + semester);
        System.out.println("Grade      : " + grade);
        System.out.println("Subjects   : " + subjects);
        System.out.println("Attendance : " + attendance + "%");

        System.out.println("=====================================");
    }
}
