
public class Main()
{

    public static void main(String[] args) {
        Student student1 = new Student("John", "10", "john@example.com");
        Student student2 = new Student("Jane", "12", "jane@example.com");
        Student student3 = new Student("Tom", "10", "tom@example.com");

    }
}

// import java.util.Iterator;
// import java.util.Set;
// import java.util.TreeSet;

// public class Main {
// public static void main(String[] args) {
// Set<Student> students = new TreeSet<>(new ComparatorByName());
// students.add(new Student("Bessie", "8", "felil@miwodzo.bb"));
// students.add(new Student("Bessie", "8", "felil@miwodzo.bb"));
// students.add(new Student("Paul", "33", "ne@ri.br"));
// students.add(new Student("Mittie", "51", "azewut@ivzah.cu"));
// students.add(new Student("Fred", "50", "jod@loteham.pr"));

// Course c = new Course(students, "Math");

// Iterator<Student> it = students.iterator();
// while (it.hasNext()) {
// Student st = it.next();
// System.out.printf("%-10s%-20s%n", st.getName(), st.getEmail());
// }
// }
// }