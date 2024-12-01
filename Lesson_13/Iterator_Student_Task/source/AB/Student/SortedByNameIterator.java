package AB.Student;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Comparator;

public class SortedByNameIterator implements Iterator<Student> {
    private ArrayList<Student> students;
    private int currentStudentIndex;

    public SortedByNameIterator(StudentLinkedList students) {
        this.students = new ArrayList<>();
        for (Student student : students) {
            this.students.add(student);
        }

        this.students.sort(Comparator.comparing(Student::getName));
        this.currentStudentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return this.currentStudentIndex < students.size();
    }

    @Override
    public Student next() {
        Student result = this.students.get(this.currentStudentIndex);
        this.currentStudentIndex++;
        return result;
    }

    public Student getCurrentStudent(){
        return this.students.get(this.currentStudentIndex);
    }
}