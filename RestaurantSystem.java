/**
 Restaurant Order System
 Scenario:
 A Customer Thread places an order.
 A Chef Thread prepares the food.
 If there is no order, the chef waits.
 When a customer places an order, the chef is notified and starts cooking.
 This uses Java's wait() and notify() methods for inter-thread communication.
 */

class OrderBuffer {
    String orderDescription = null;
    boolean hasOrder = false;
    boolean isClosed = false;

    public synchronized void placeOrder(String order) {
        while (hasOrder) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        this.orderDescription = order;
        this.hasOrder = true;
        System.out.println("Customer Placed order for: " + order);
        notify();
    }

    public synchronized String takeOrder() {
        while (!hasOrder && !isClosed) {
            try {
                System.out.println("No orders available. Chef is Waiting fr order");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        if (isClosed && !hasOrder) {
            return null;
        }

        String orderToPrepare = orderDescription;
        System.out.println("Chef Received order: " + orderToPrepare + ". Starting to prepare");

        this.orderDescription = null;
        this.hasOrder = false;
        notify();
        return orderToPrepare;
    }

    public synchronized void closeBuffer() {
        this.isClosed = true;
        notify();
    }
}

class RestaurantCustomer implements Runnable {
    final OrderBuffer buffer;

    public RestaurantCustomer(OrderBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        String[] menu = {"Burger", "Pizza", "Pasta", "Dosa", "Ice Cream"};

        for (String dish : menu) {
            buffer.placeOrder(dish);
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Customer Done orders for the day.");
        buffer.closeBuffer();
    }
}

class Chef implements Runnable {
    final OrderBuffer buffer;

    public Chef(OrderBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            String dish = buffer.takeOrder();
            if (dish == null) {
                System.out.println("Chef is closing kitchen soon. No more orders.");
                break;
            }

            try {
                Thread.sleep(1500);
                System.out.println("Chef finished cooking: " + dish );
                System.out.println("Order served\n");
            } catch (InterruptedException e) {
                System.out.println("interrupted.");
                break;
            }
        }
    }
}

public class RestaurantSystem {
    public static void main(String[] args) {
        OrderBuffer sharedKitchenBuffer = new OrderBuffer();

        Thread customerThread = new Thread(new RestaurantCustomer(sharedKitchenBuffer), "Customer_Thread");
        Thread chefThread = new Thread(new Chef(sharedKitchenBuffer), "Chef_Thread");

        chefThread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

        customerThread.start();
    }
}
