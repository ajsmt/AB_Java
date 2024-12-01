package AB.Data;

import java.util.Set;
import java.util.TreeSet;

public class LoopCourseSetStrategy implements CourseSetStrategy {
    @Override
    public Set<String> getSet(Set<Student> students) {
        Set<String> courses = new TreeSet<>();
        for (Student student : students) {
            courses.add(student.getCourse());
        }
        return courses;
    }
}