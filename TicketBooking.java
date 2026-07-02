/**
 2.In a movie Ticket Booking program create Enum SeatType with Values

 SILVER
 GOLD
 PLATINUM

 Each seat type has a different ticket price.

 Create constructor inside enum
 Method getPrice()

 Display

 Seat Type : GOLD
 Price : ₹250
 */
public class TicketBooking {

    enum SeatType {
        SILVER(150),
        GOLD(250),
        PLATINUM(350);

        int price;

        SeatType(int price) {
            this.price = price;
        }

        public void getPrice() {
            System.out.println("Ticket Rate: " +  this.price);
        }
    }

    public static void main(String[] args) {
        SeatType selectedSeat1 = SeatType.GOLD;
        System.out.println("Seat Type : " + selectedSeat1);
        selectedSeat1.getPrice();
        SeatType selectedSeat2 = SeatType.SILVER;
        System.out.println("Seat Type : " + selectedSeat2);
        selectedSeat2.getPrice();
        SeatType selectedSeat3 = SeatType.PLATINUM;
        System.out.println("Seat Type : " + selectedSeat3);
        selectedSeat3.getPrice();
    }
}

