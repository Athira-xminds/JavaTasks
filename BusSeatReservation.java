//Array Assignment
//===========
//In a bus Seat Reservation  Store seat availability.
//Use:
//0 = Available
//1 = Booked
//Operations
//Book a seat
//Cancel booking
//Display available seats
//Count booked seats

import java.util.ArrayList;
import java.util.Scanner;

public class BusSeatReservation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        int totalSeats = 20;
        ArrayList<Integer> seats = new ArrayList<>();
        for (int i = 0; i < totalSeats; i++) {
            seats.add(0);
        }

        while (option != 5) {
            System.out.println("Bus Ticket Reservation");
            System.out.println("---------------------------");
            System.out.println("1. Book a ticket");
            System.out.println("2. Cancel booking");
            System.out.println("3. Display available seats");
            System.out.println("4. Count booked seats");
            System.out.println("5. Logout");
            System.out.print("Choose any above options: ");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Available Seats: ");
                    for (int i = 0; i < totalSeats; i++) {
                        if (seats.get(i) == 0) {
                            System.out.print((i + 1) + " ");
                        }
                    }
                    System.out.println();
                    System.out.print("Enter seat number to book (1-20): ");
                    int bookNum = sc.nextInt();
                    if (bookNum < 0 || bookNum > 20){
                        System.out.println("Invalid seat number");
                    }
                    else if (seats.get(bookNum - 1) == 1) {
                        System.out.println("Seat is already booked!");
                    } else {
                        seats.set(bookNum - 1, 1);
                        System.out.println("Seat " + bookNum + " successfully booked.");
                    }
                    break;

                case 2:
                    System.out.print("Currently Booked Seats: ");
                    for (int i = 0; i < totalSeats; i++) {
                        if (seats.get(i) == 1) {
                            System.out.print((i + 1) + " ");
                        }
                    }
                    System.out.println();
                    System.out.print("Enter seat number to cancel (1-20): ");
                    int cancelNum = sc.nextInt();
                    if (cancelNum < 0 || cancelNum > 20){
                        System.out.println("Invalid seat number");
                    }
                    else if (seats.get(cancelNum - 1) == 0) {
                        System.out.println("This seat is already available!");
                    } else {
                        seats.set(cancelNum - 1, 0);
                        System.out.println("Booking for seat " + cancelNum + " cancelled.");
                    }
                    break;

                case 3:
                    System.out.print("Available Seats: ");
                    boolean emptyBus = true;
                    for (int i = 0; i < totalSeats; i++) {
                        if (seats.get(i) == 0) {
                            System.out.print((i + 1) + " ");
                            emptyBus = false;
                        }
                    }
                    if (emptyBus) {
                        System.out.print("No seats available");
                    }
                    System.out.println();
                    break;

                case 4:
                    int bookedCount = 0;
                    for (int state : seats) {
                        if (state == 1) {
                            bookedCount++;
                        }
                    }
                    System.out.println("Count of booked seats: " + bookedCount);
                    break;

                case 5:
                    System.out.println("Thank you");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
