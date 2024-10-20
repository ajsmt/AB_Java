import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.util.function.Predicate;

public class Course implements Iterable<Student> {
    private Set<Student> students;
    private String name;

    public Course(Set<Student> student, String name) {
        this.students = student;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Course [name=" + name + ", students=" + students + "]";
    }

    @Override
    public Iterator<Student> iterator() {
        return students.iterator();
    }

    public Set<Postgraduate> getPostgraduates(String supervisorName) {
        Set<Postgraduate> result = new HashSet<>();
        for (Student student : students) {
            if (student instanceof Postgraduate) {
                Postgraduate pg = (Postgraduate) student;
                if (pg.getSupervisor().getName().equals(supervisorName)) {
                    result.add(pg);
                }
            }
        }
        return result;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Set<Student> getWithPredicate(Predicate<Student> predicate) {
        Set<Student> result = new HashSet<>();
        for (Student student : students) {
            if (predicate.test(student)) {
                result.add(student);
            }
        }
        return result;
    }
}