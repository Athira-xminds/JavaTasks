/**
 13.Define a class Student with roll_no,name,gender,class,grade .Using Predicate and Stream API methods
 display all girls students data
 find all students having Aplus,A and B grade.
 */

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class StudentRecord {
    int rollNo;
    String name;
    String gender;
    String classDiv;
    String grade;
    public StudentRecord(int rollNo, String name, String gender, String classDiv, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.gender = gender;
        this.classDiv = classDiv;
        this.grade = grade;
    }
    public int getRollNo() {
        return rollNo;
    }
    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
    public String getClassDiv() {
        return classDiv;
    }
    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student[Roll=" + rollNo + ", Name='" + name + "', Gender='" + gender +
                "', Class='" + classDiv + "', Grade='" + grade + "']";
    }
}

public class StudentsResult {
    public static void main(String[] args) {
        List<StudentRecord> students = Arrays.asList(
                new StudentRecord(1, "Anjana", "Female", "12", "Aplus"),
                new StudentRecord(2, "Ram", "Male", "12", "B"),
                new StudentRecord(3, "Sita", "Female", "11", "C"),
                new StudentRecord(4, "Nithin", "Male", "12th", "A"),
                new StudentRecord(5, "Lakshmi", "Female", "10", "A"),
                new StudentRecord(6, "George", "Male", "11", "D")
        );
        Predicate<StudentRecord> isFemale = student -> student.getGender().equalsIgnoreCase("Female");

        Predicate<StudentRecord> hasTopGrades = student -> student.getGrade().equalsIgnoreCase("Aplus") || student.getGrade().equalsIgnoreCase("A") || student.getGrade().equalsIgnoreCase("B");

        students.stream().filter(isFemale).forEach(System.out::println);
        System.out.println("\n");
        students.stream().filter(hasTopGrades).forEach(System.out::println);
    }
}
