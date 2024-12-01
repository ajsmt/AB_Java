import AB.Student.*;

public class Main {
    public static void main(String[] args) {
        StudentLinkedList students = new StudentLinkedList();

        students.add(new Student("Lettie Jensen"));
        students.add(new Student("Darrell Leonard"));
        students.add(new Student("Gussie Woods"));

        System.out.println("\nStudentLinkedList print() : ");
        students.print();

        System.out.println("\nSortedByNameIterator  use : ");
        for (SortedByNameIterator it = new SortedByNameIterator(students); it.hasNext();) {
            System.out.println(it.next());

        }
    }
}