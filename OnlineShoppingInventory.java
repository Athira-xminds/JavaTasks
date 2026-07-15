/**
 Creates a ConcurrentHashMap<String, Integer> to store product stock.
 Uses 3 CompletableFuture.runAsync() tasks.
 Each task updates the stock of one product:
 Laptop → 20
 Mobile → 35
 Headphones → 15
 Waits for all tasks to complete using CompletableFuture.allOf(...).join().
 Displays the final inventory.
 */

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CompletableFuture;

public class OnlineShoppingInventory {
    public static void main(String[] args){
        ConcurrentHashMap<String, Integer> inventory = new ConcurrentHashMap<>();
        System.out.println("stock update started");
        CompletableFuture<Void> laptopTask = CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Getting the current stock of Laptops");
                Thread.sleep(2000);
                inventory.put("Laptop", 20);
                System.out.println("Laptop stock updated to 20");
            } catch (InterruptedException e) {
                System.out.println("Exception: "+e);
            }
        });
        CompletableFuture<Void> mobileTask = CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Getting current stock of mobiles");
                Thread.sleep(2000);
                inventory.put("Mobile", 35);
                System.out.println("Mobile stock updated to 35");
            } catch (InterruptedException e) {
                System.out.println("Exception: "+e);
            }
        });
        CompletableFuture<Void> headphoneTask = CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Getting current stock of headphones");
                Thread.sleep(2000);
                inventory.put("Headphones", 15);
                System.out.println("Headphones stock updated to 15");
            } catch (InterruptedException e) {
                System.out.println("Exception: "+e);
            }
        });
        CompletableFuture.allOf(laptopTask, mobileTask, headphoneTask).join();
        System.out.println("Final Inventory");
        inventory.forEach((product, stock) ->
                System.out.println(product + " : " + stock)
        );
    }
}

