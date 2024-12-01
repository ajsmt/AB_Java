package AB.Student;

import java.util.Iterator;

public class StudentLinkedList implements StudentList, Iterable<Student> {
    private StudentNode head;

    private class StudentNode {
        public Student data;
        public StudentNode next;

        public StudentNode(Student data) {
            this.data = data;
            this.next = null;
        }
    }

    @Override
    public void add(Student student) {
        StudentNode newHead = new StudentNode(student);
        newHead.next = head;
        head = newHead;
    }

    @Override
    public Iterator<Student> iterator() {
        return new StudentIterator();
    }

    public class StudentIterator implements Iterator<Student> {
        private StudentNode current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Student next() {
            if (hasNext()) {
                Student result = current.data;
                current = current.next;
                return result;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void print() {
        for (Student student : this) {
            System.out.println(student);
        }
    }
}
