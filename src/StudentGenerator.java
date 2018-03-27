import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StudentGenerator {
    List<Student> studentList;

    public static List<Student> generateStudentList(int limit){
        return Stream.generate(new Supplier<Student>(){
            long start = 0l;
            @Override
            public Student get() {
                Student student = new Student();
                student.setId(++start);
                student.setName("S" + student.getId());
                student.setGender(student.getId() % 2 == 0 ? "Male" : "Female");
                return student;
            }
        }).limit(limit).collect(toList());
    }
}
