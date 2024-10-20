import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    static public void Write(Course course, String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("Course: " + course.getName() + "\n");
            bw.write("Students:\n");
            for (Student student : course) {
                bw.write(student.toString() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error!" + e.getMessage());
        }
    }
}