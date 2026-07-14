/**
 In a food delivery app
 Display "Customer placed an order."
 Start food preparation asynchronously using CompletableFuture.runAsync().
 Simulate food preparation by pausing the thread for 5 seconds.
 Display the thread name that is preparing the food.
 While the food is being prepared, the main thread should display:
 "Generating bill..."
 "Sending order confirmation..."
 Use join() to wait until food preparation is complete.
 Finally, display "Order is ready for delivery."
 */

import java.util.concurrent.CompletableFuture;

public class FoodDeliveryApp {
     static void simulateThreadTask(String taskMessage) {
        System.out.println(Thread.currentThread().getName()+":"+taskMessage);
    }
    public static void main(String[] args) {
        System.out.println("Customer placed an order");
        CompletableFuture<Void> foodPreparation = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName()+": Started preparing food");
            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName()+": Food preparation finished.");
            } catch (InterruptedException e) {
                System.out.println("Preparation interrupted."+ e);
            }
        });

        simulateThreadTask("Generating bill");
        simulateThreadTask("Sending order confirmation");
        foodPreparation.join();
        System.out.println("Order is ready for delivery.");
    }
}

