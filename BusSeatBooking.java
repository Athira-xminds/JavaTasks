import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

/**
 Write a Java program to simulate a Bus Reservation System using multiple threads and ReentrantLock.
 Requirements
 Create a class named Bus.
 The bus initially has 5 available seats.
 Create a method:
 bookSeat(String passengerName, int seatsRequested)
 Use a ReentrantLock to ensure that only one passenger can book seats at a time.
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

class Bus {
    int availableSeats = 5;
    ReentrantLock lock = new ReentrantLock();

    public void bookSeat(String passengerName, int seatsRequested) {
        System.out.println(passengerName + " is trying to book " + seatsRequested + " seats");
        lock.lock();
        if (availableSeats >= seatsRequested) {
            System.out.println(seatsRequested + " seats booked for " + passengerName);
            availableSeats -= seatsRequested;
            System.out.println("Seats remaining: " + availableSeats);
        } else {
            System.out.println("Unable to book tickets for " + passengerName + " Remaining seats: " + availableSeats);
        }
        lock.unlock();
    }
}

public class BusSeatBooking {
    public static void main(String[] args) {
        Bus sharedBus = new Bus();
        ExecutorService passengerThread = Executors.newFixedThreadPool(3);

        CompletableFuture<Void> task1 = CompletableFuture.runAsync(() -> sharedBus.bookSeat("passenger1", 2), passengerThread);
        CompletableFuture<Void> task2 = CompletableFuture.runAsync(() -> sharedBus.bookSeat("passenger2", 3), passengerThread);
        CompletableFuture<Void> task3 = CompletableFuture.runAsync(() -> sharedBus.bookSeat("passenger3", 2), passengerThread);;
        CompletableFuture.allOf(task1, task2, task3).join();
        passengerThread.shutdown();
    }

}

