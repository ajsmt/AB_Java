import java.util.Set;
import java.util.HashSet;

public class ProgrammingTest {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<Student>();

        students.add(new Undergraduate("Bryan", "gg4", "al@diwjowo.jm", new Academic("Paul Deitel")));
        students.add(new Undergraduate("Minnie", "pr3", "mehgumtuc@waba.eh", new Academic("Cay Horstmann")));

        students.add(new Postgraduate("Lloyd", "te2", "gevsis@uhiminlub.fm", new Academic("Paul Deitel")));
        students.add(new Postgraduate("Nellie", "yj34", "vo@vinotowa.tj", new Academic("Cay Horstmann")));
        students.add(new Postgraduate("Jack", "jj8", "denjafum@foeko.tz", new Academic("Cay Horstmann")));

        Course course = new Course(students, "Math");

        Set<Postgraduate> pg = course.getPostgraduates("Cay Horstmann");

        System.out.println("Postgraduates from Cay Horstmann:");
        for (Postgraduate p : pg) {
            System.out.println(p.getName());
        }

        System.out.println("\nNotifications tester:");
        Notifier notifier = new Notifier(students);
        notifier.doNotifyAll("Hello, Students!");

        System.out.println("\nCourse adder and iterator test:");
        System.out.println("Before:");
        for (Student student : course) {
            System.out.println(student);
        }

        System.out.println("After:");
        course.addStudent(new Undergraduate("Alice", "al123", "nis@wo.vn", new Academic("Ray Carroll")));
        for (Student student : course) {
            System.out.println(student);
        }

        System.out.println("\nPredicate test:");
        System.out.println("Students with 'a' in their name:");
        Set<Student> set = course.getWithPredicate(Name -> Name.getName().contains("a"));
        for (Student student : set) {
            System.out.println(student);
        }

        System.out.println("\nWriter test (to \"out.txt\"):");
        Writer.Write(course, "out.txt");
    }
}