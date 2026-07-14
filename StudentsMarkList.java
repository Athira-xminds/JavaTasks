
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 A school wants to calculate the total marks obtained by different students.
 Each student's total should be calculated in a separate thread using Callable.
 */
class Marks implements Callable<Double> {
    String studentName;
    List<Double> subjectMarks;

    public Marks(String studentName, List<Double> subjectMarks) {
        this.studentName = studentName;
        this.subjectMarks = subjectMarks;
    }

    @Override
    public Double call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " is calculating marks of " + studentName);

        double totalMark = 0;
        for (double mark : subjectMarks) {
            totalMark += mark;
        }
        return totalMark;
    }
}

public class StudentsMarkList {
    public static void main(String[] args) {
        ExecutorService markSheet = Executors.newFixedThreadPool(2);

        Marks student1 = new Marks("student1", Arrays.asList(85.5, 90.0, 78.0));
        Marks student2 = new Marks("student2", Arrays.asList(92.0, 88.5, 95.0));
        Marks student3 = new Marks("student3", Arrays.asList(70.0, 65.5, 80.0));
        List<Future<Double>> futureResults = new ArrayList<>();
        futureResults.add(markSheet.submit(student1));
        futureResults.add(markSheet.submit(student2));
        futureResults.add(markSheet.submit(student3));

        for (int i = 0; i < futureResults.size(); i++) {
            try {
                Double totalMarks = futureResults.get(i).get();
                System.out.println("Student " + (i + 1) + " Total Marks: " + totalMarks);
//            } catch (ExecutionException e) {
//                throw new RuntimeException(e);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            } catch (ExecutionException | InterruptedException e){
                throw new RuntimeException(e);
            }
        }
        markSheet.shutdown();
    }
}
