package AB.Data;

import java.util.*;
import java.util.stream.Collectors;

public class StreamCourseSetStrategy implements CourseSetStrategy {
    @Override
    public Set<String> getSet(Set<Student> students) {
        return students.stream()
                .map(Student::getCourse)
                .sorted()
                .collect(Collectors.toSet());
    }
}