/**
 A teacher wants to calculate the average marks of a class.
 This calculation may take some time, it is done asynchronously using CompletableFuture.supplySync().
 Once the list of marks is received, the Stream API is used to calculate the average.
 Use thenApply()  method for the further process.(Display the average mark)
 */

//import java.util.Arrays;
//import java.util.List;
//import java.util.concurrent.CompletableFuture;
//
//public class AverageMarkCalculation {
//    public static void main(String[] args) {
//        CompletableFuture<Double> studentMarks = CompletableFuture.supplyAsync(() -> {
//                    try {
//                        Thread.sleep(1500);
//                    } catch (InterruptedException e) {
//                        System.out.println("Thread interrupted: " + e);
//                    }
//                    List<Double> marksList = Arrays.asList(85.0, 92.0, 78.5, 64.75, 95.0, 88.5);
//                    return marksList.stream()
//                            .mapToDouble(Double::doubleValue)
//                            .average()
//                            .orElse(0.0);
//                })
//                .thenApply(averageMark -> {
//                    return averageMark;
//                });
//        double averageMark = studentMarks.join();
//        System.out.println("The average mark of the class is: " + averageMark);
//    }
//}

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AverageMarkCalculation {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(1);
        CompletableFuture<Double> studentMarks = CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        System.out.println("Thread interrupted: " + e);
                    }
                    List<Double> marksList = Arrays.asList(85.0, 92.0, 78.5, 64.75, 95.0, 88.5);
                    return marksList.stream()
                            .mapToDouble(Double::doubleValue)
                            .average()
                            .orElse(0.0);
                },threadPool)
                .thenApply(averageMark -> {
                    System.out.println(Thread.currentThread().getName()+": calculated the average mark");
                    return averageMark;
                });
        double averageMark = studentMarks.join();
        System.out.println(Thread.currentThread().getName()+": The average mark of the class is: " + averageMark);
        threadPool.shutdown();
    }
}