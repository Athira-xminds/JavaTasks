/**
 We need to maintain the attendance of 3 students.(each student is a thread)
 Each thread should update the attendance of one student 100 times.
 Display the final attendance of all students.
 */
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StudentAttendance {
    private static void updateAttendance(Map<String, Integer> map, String studentName) {
        for (int i = 0; i < 100; i++) {
            map.computeIfPresent(studentName, (key, currentAttendance) -> currentAttendance + 1);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                System.out.println("Exception:"+ e);
            }
        }
        System.out.println(Thread.currentThread().getName()  + "  updating attendance of " + studentName);
    }
    public static void main(String[] args) {
        Map<String, Integer> attendanceMap = new ConcurrentHashMap<>();
        String[] students = {"student1", "student2", "student3"};
        for (String student : students) {
            attendanceMap.put(student, 0);
        }
        ExecutorService studentThread = Executors.newFixedThreadPool(3);

        CompletableFuture<Void> task1 = CompletableFuture.runAsync(() -> updateAttendance(attendanceMap, "student1"), studentThread);
        CompletableFuture<Void> task2 = CompletableFuture.runAsync(() -> updateAttendance(attendanceMap, "student2"), studentThread);
        CompletableFuture<Void> task3 = CompletableFuture.runAsync(() -> updateAttendance(attendanceMap, "student3"), studentThread);
        CompletableFuture.allOf(task1, task2, task3).join();
        attendanceMap.forEach((student, count) ->
                System.out.println("Name: " + student + " , Attendance: " + count)
        );
        studentThread.shutdown();
    }
}
