import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class Student {
    String lastName;
    int course;
    double averageScore;

    public Student(String lastName, int course, double averageScore) {
        this.lastName = lastName;
        this.course = course;
        this.averageScore = averageScore;
    }

    public double getAverageScore() {
        return averageScore;
    }

    @Override
    public String toString() {
        return lastName + ", Курс: " + course + ", Ср.балл: " + averageScore;
    }
}

public class StudentContainer {
    private List<Student> students;

    public StudentContainer(String filePath) throws IOException {
        loadData(filePath);
    }

    private void loadData(String filePath) throws IOException {
        students = Files.lines(Paths.get(filePath))
                        .map(line -> {
                            String[] parts = line.split(", ");
                            return new Student(parts[0], Integer.parseInt(parts[1]), Double.parseDouble(parts[2]));
                        })
                        .collect(Collectors.toList());
    }

    public Optional<Student> getTopStudent() {
        return students.stream().max((s1, s2) -> Double.compare(s1.getAverageScore(), s2.getAverageScore()));
    }

    public Optional<Student> getLowestStudent() {
        return students.stream().min((s1, s2) -> Double.compare(s1.getAverageScore(), s2.getAverageScore()));
    }

    public static void main(String[] args) {
        try {
            StudentContainer container = new StudentContainer("in.txt");
            System.out.println("Лучший студент: " + container.getTopStudent().orElse(null));
            System.out.println("Студент с наименьшим средним баллом: " + container.getLowestStudent().orElse(null));
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Ошибка преобразования данных: " + e.getMessage());
        }
    }
}
