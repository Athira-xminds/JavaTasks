
/**
 Customer 1 books 3 tickets
 Customer 2 books 5 tickets
 Customer 3 books 5 tickets
 Display the appropriate message
 */


public class FilmTicketBooking {

    private int availableTicket = 10;

    public void bookingTicket(int count) {
        System.out.println(Thread.currentThread().getName() + " is checking tickets. Require " + count + " tickets.");
        synchronized(this) {
            System.out.println("Remaining tickets: " + availableTicket);

            if (availableTicket >= count) {
                System.out.println("Thread in use: " + Thread.currentThread().getName());
                availableTicket -= count;
                System.out.println(Thread.currentThread().getName() + " Successfully booked " + count + " Tickets");
            } else {
                System.out.println(Thread.currentThread().getName() + " requires " + count + " tickets, only " + availableTicket + " are left");
            }
        }
    }

    static class CustomerPreference implements Runnable {
        private final FilmTicketBooking bookingType;
        private final int seatsCountRequested;
        public CustomerPreference(FilmTicketBooking bookingType, int seatsCountRequested) {
            this.bookingType = bookingType;
            this.seatsCountRequested = seatsCountRequested;
        }
        public void run() {
            bookingType.bookingTicket(seatsCountRequested);
        }
    }

    public static void main(String[] args) {

        FilmTicketBooking bookingType = new FilmTicketBooking();
        CustomerPreference task1 = new CustomerPreference(bookingType, 3);
        CustomerPreference task2 = new CustomerPreference(bookingType, 5);
        CustomerPreference task3 = new CustomerPreference(bookingType, 5);
        Thread customer1 = new Thread(task1, "customer_1");
        Thread customer2 = new Thread(task2, "customer_2");
        Thread customer3 = new Thread(task3, "customer_3");
        customer1.start();
        customer2.start();
        customer3.start();
    }
}
