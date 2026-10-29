import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class FileHandler {
    private static final String FILE_PATH = "data/students.txt";
    public static void saveStudents(List<Student> students) {
        File file = new File(FILE_PATH);
        try {
            File parent = file.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            try (BufferedWriter writer = new BufferedWriter(
                    new FileWriter(file))) {
                for (Student student : students) {
                    writer.write(
                        student.getId() + "," +
                        student.getName() + "," +
                        student.getAge() + "," +
                        student.getDepartment() + "," +
                        student.getMarks()
                    );
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving student records: "
                               + e.getMessage());
        }
    }
    public static List<Student> loadStudents() {
        List<Student> students = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return students;
        }
        try (BufferedReader reader = new BufferedReader(
                new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] data = line.split(",", -1);
                    if (data.length != 5) {
                        System.out.println(
                            "Skipping invalid student record."
                        );
                        continue;
                    }
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    String department = data[3];
                    double marks = Double.parseDouble(data[4]);
                    students.add(
                        new Student(
                            id, name, age, department, marks
                        )
                    );
                } catch (IllegalArgumentException e) {
                    System.out.println(
                        "Skipping corrupted student record."
                    );
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading student records: "
                               + e.getMessage());
        }
        return students;
    }
}