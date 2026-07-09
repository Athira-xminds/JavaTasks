/**
 12.Given a list of Student objects, you need to convert list to Map with name as key and age as value. In case, there are duplicate keys, then you need to preserve old value.Student class contains properties name and age.
 */

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class StudentData {
    String name;
    int age;
    public StudentData(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
}

public class StudentDetails {
    public static void main(String[] args) {
        List<StudentData> student = Arrays.asList(
                new StudentData("Ram",25),
                new StudentData("Sita", 22),
                new StudentData("Veena", 28)
        );

        Map<String, Integer> studentMap = student.stream()
                .collect(Collectors.toMap(
                        StudentData::getName,
                        StudentData::getAge,
                        (oldValue, newValue) -> oldValue
                ));

        System.out.println(studentMap);
    }
}
