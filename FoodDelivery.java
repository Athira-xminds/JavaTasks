/**
 In a food delivery app write a Java program by implementing the Runnable interface where:

 Each customer order is represented as a separate task.
 Create three customer orders: Order-101, Order-102, and Order-103.
 Execute each order in a separate thread.
 Display when an order starts preparation and when it is ready.
 */
public class FoodDelivery {
    public static void main(String[] args) {


        Runnable order101 = () -> {
            System.out.println("Order-101 has started preparation.");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Order-101 is ready!");
        };

        Runnable order102 = () -> {
            System.out.println("Order-102 has started preparation.");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Order-102 is ready!");
        };

        Runnable order103 = () -> {
            System.out.println("Order-103 has started preparation.");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Order-103 is ready!");
        };

        Thread t1 = new Thread(order101);
        Thread t2 = new Thread(order102);
        Thread t3 = new Thread(order103);
        t1.start();
        t2.start();
        t3.start();
    }
}
