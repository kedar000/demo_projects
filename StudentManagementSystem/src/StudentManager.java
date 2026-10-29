import java.util.ArrayList;
import java.util.List;
public class StudentManager {
    private final List<Student> students;
    public StudentManager() {
        students = new ArrayList<>(
            FileHandler.loadStudents()
        );
    }
    public boolean addStudent(Student student) {
        if (findStudentById(student.getId()) != null) {
            System.out.println("Student ID already exists.");
            return false;
        }
        students.add(student);
        save();
        System.out.println("Student added successfully.");
        return true;
    }
    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }
        System.out.println("\n========== STUDENT RECORDS ==========");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("=====================================");
    }
    public Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
    public void searchStudent(int id) {
        Student student = findStudentById(id);
        if (student == null) {
            System.out.println("Student not found.");
        } else {
            System.out.println("\nStudent Details:");
            System.out.println(student);
        }
    }
    public boolean updateStudent(
            int id,
            String name,
            int age,
            String department,
            double marks) {
        Student student = findStudentById(id);
        if (student == null) {
            System.out.println("Student not found.");
            return false;
        }
        student.setName(name);
        student.setAge(age);
        student.setDepartment(department);
        student.setMarks(marks);
        save();
        System.out.println("Student updated successfully.");
        return true;
    }
    public boolean deleteStudent(int id) {
        Student student = findStudentById(id);
        if (student == null) {
            System.out.println("Student not found.");
            return false;
        }
        students.remove(student);
        save();
        System.out.println("Student deleted successfully.");
        return true;
    }
    private void save() {
        FileHandler.saveStudents(students);
    }
}