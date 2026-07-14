
/**
 An online learning platform reminds students about upcoming classes.
 Requirements
 Create a ScheduledThreadPool with 2 threads.
 Schedule:
 Java Class Reminder every 5 seconds
 React Class Reminder every 7 seconds
 Python Class Reminder every 10 seconds
 Run for 30 seconds, then stop.
 */

import java.util.concurrent.*;
import static java.util.concurrent.TimeUnit.SECONDS;


class Courses implements Runnable {
    String courseName;
    String startingDate;
    public Courses(String courseName, String startingDate) {
        this.courseName = courseName;
        this.startingDate = startingDate;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " started processing. Start Date: " + startingDate + " of " + courseName);
        try {
            // Simulating task processing time
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }
}

public class OnlineLearningPlatform {
    public static void main(String[] args) {
        ScheduledExecutorService courseSchedules = Executors.newScheduledThreadPool(2);

        Courses javaCourse = new Courses("Java", "20-07-2026");
        Courses reactCourse = new Courses("React", "25-07-2026");
        Courses pythonCourse = new Courses("Python", "27-07-2026");
        courseSchedules.scheduleAtFixedRate(javaCourse, 0, 5, SECONDS);
        courseSchedules.scheduleAtFixedRate(reactCourse, 0, 7, SECONDS);
        courseSchedules.scheduleAtFixedRate(pythonCourse, 0, 10, SECONDS);

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
        }
        courseSchedules.shutdownNow();
    }
}
