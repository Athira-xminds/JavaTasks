
/**
 Create a thread pool with 3 threads.
 Simulate 6 customers.
 Each customer should be served by an available waiter (thread).
 Display which thread is serving which customer.
 Simulate serving time using Thread.sleep(3000).
 After serving all customers, shut down the thread pool.
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class RestaurantCust implements Runnable {
    int custNum;

    public RestaurantCust(int custNum){
        this.custNum = custNum;
    }

    public void run(){
        System.out.println("Waiter: "+ Thread.currentThread().getName() +" serving customer: "+ custNum);
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
public class Restaurant {


    public static void main(String[] args){
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int j = 1; j <= 6; j++){
            service.execute(new RestaurantCust(j));
        }

        service.shutdown();
    }
}
