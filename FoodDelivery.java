public class FoodDelivery {
    public static void main(String[] args) {


        Runnable order101 = () -> {
            System.out.println("Order-101 has started preparation.");
            try {
                Thread.sleep(2000); // Simulate preparation time
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
