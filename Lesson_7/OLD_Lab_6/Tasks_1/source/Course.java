import java.util.Set;
import java.util.Iterator;

public class Course implements Iterable<Student> {
    private Set<Student> students;
    private String name;

    public Course(Set<Student> student, String name) {
        this.students = student;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course [name=" + name + ", students=" + students + "]";
    }

    @Override
    public Iterator<Student> iterator() {
        return students.iterator();
    }
}