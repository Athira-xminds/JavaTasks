/**
 bus reservation system semaphore+CompletableFuture+ExecutorService combined aayi cheyye
 Semaphore → Limits the number of booking requests processed simultaneously (
 CompletableFuture → Processes passenger booking requests asynchronously.
 ExecutorService → Provides a thread pool for running the asynchronous tasks.
 */

import java.util.concurrent.*;

    public class BusReservationSystem {
        static ExecutorService pool;
        static Semaphore sem;
        static int availableSeats;

        public BusReservationSystem(int initialSeats, int maxTasks, int poolSize) {
            this.availableSeats = initialSeats;
            this.sem = new Semaphore(maxTasks);
            this.pool = Executors.newFixedThreadPool(poolSize);
        }
        public record BookingResult(String name, boolean success) {
        }
        public static void main(String[] args) throws Exception {
            BusReservationSystem system = new BusReservationSystem(10, 1, 4);

            String[] passengers = {"Passenger 1", "Passenger 2", "Passenger 3", "Passenger 4"};
            int[] requests = {4, 3, 3, 1};

            CompletableFuture<BookingResult>[] futures = new CompletableFuture[4];

            for (int i = 0; i < 4; i++) {
                final String name = passengers[i];
                final int requested = requests[i];
                futures[i] = CompletableFuture.supplyAsync(() -> {
                    try {
                        sem.acquire();
                        System.out.println("Processing: " + name);

                        if (availableSeats >= requested) {
                            availableSeats -= requested;
                            return new BookingResult(name, true);
                        } else {
                            return new BookingResult(name, false);
                        }
                    } catch (InterruptedException e) {
                        return new BookingResult(name, false);
                    } finally {
                        sem.release();
                    }
                }, pool)
                .thenApply(result -> {
                    if (result.success()) {
                        System.out.println("Ticket ready for: " + name + " | remaining seats: " + availableSeats);
                    }
                    return result;
                });
            }
            CompletableFuture.allOf(futures).join();
            for (CompletableFuture<BookingResult> future : futures) {
                System.out.println(future.get());
                }
            pool.shutdown();
        }
}