import java.util.Scanner;
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentManager manager = new StudentManager();
    public static void main(String[] args) {
        boolean running = true;
        System.out.println("=====================================");
        System.out.println("     STUDENT MANAGEMENT SYSTEM");
        System.out.println("=====================================");
        while (running) {
            displayMenu();
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    manager.viewAllStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println(
                        "Invalid choice. Please select 1-6."
                    );
            }
        }
        scanner.close();
    }
    private static void displayMenu() {
        System.out.println("\n----------- MAIN MENU -----------");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
        System.out.println("---------------------------------");
    }
    private static void addStudent() {
        System.out.println("\n--- Add Student ---");
        int id = readInt("Enter student ID: ");
        if (manager.findStudentById(id) != null) {
            System.out.println("Student ID already exists.");
            return;
        }
        String name = readNonEmptyString("Enter name: ");
        int age = readInt("Enter age: ");
        if (age <= 0 || age > 150) {
            System.out.println("Age must be between 1 and 150.");
            return;
        }
        String department = readNonEmptyString(
            "Enter department: "
        );
        double marks = readDouble("Enter marks (0-100): ");
        if (marks < 0 || marks > 100) {
            System.out.println(
                "Marks must be between 0 and 100."
            );
            return;
        }
        Student student = new Student(
            id, name, age, department, marks
        );
        manager.addStudent(student);
    }
    private static void searchStudent() {
        System.out.println("\n--- Search Student ---");
        int id = readInt("Enter student ID: ");
        manager.searchStudent(id);
    }
    private static void updateStudent() {
        System.out.println("\n--- Update Student ---");
        int id = readInt("Enter student ID to update: ");
        Student existing = manager.findStudentById(id);
        if (existing == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.println("Current details:");
        System.out.println(existing);
        String name = readNonEmptyString("Enter new name: ");
        int age = readInt("Enter new age: ");
        if (age <= 0 || age > 150) {
            System.out.println("Invalid age.");
            return;
        }
        String department = readNonEmptyString(
            "Enter new department: "
        );
        double marks = readDouble("Enter new marks (0-100): ");
        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks.");
            return;
        }
        manager.updateStudent(
            id, name, age, department, marks
        );
    }
    private static void deleteStudent() {
        System.out.println("\n--- Delete Student ---");
        int id = readInt("Enter student ID to delete: ");
        manager.deleteStudent(id);
    }
    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(
                    "Invalid input. Please enter a whole number."
                );
            }
        }
    }
    private static double readDouble(String message) {
        while (true) {
            System.out.print(message);
            try {
                double value = Double.parseDouble(
                    scanner.nextLine().trim()
                );
                if (!Double.isFinite(value)) {
                    System.out.println(
                        "Please enter a finite number."
                    );
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println(
                    "Invalid input. Please enter a number."
                );
            }
        }
    }
    private static String readNonEmptyString(String message) {
        while (true) {
            System.out.print(message);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty() && !value.contains(",")) {
                return value;
            }
            System.out.println(
                "Input cannot be empty or contain commas."
            );
        }
    }
}