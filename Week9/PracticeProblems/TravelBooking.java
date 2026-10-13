
import java.util.*;

abstract class Booking {
    private static final double BOOKING_FEE = 50.0;
    double distance;

    Booking(double distance) {
        this.distance = distance;
    }

    abstract double calculateBaseFare();

    final double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends Booking {
    BusBooking(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return distance * 2.0;
    }
}

class TrainBooking extends Booking {
    TrainBooking(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return distance * 1.5;
    }
}

class FlightBooking extends Booking {
    FlightBooking(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return 2500 + distance * 4.0;
    }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            Booking booking;

            switch (mode) {
                case "BUS":
                    booking = new BusBooking(distance);
                    break;
                case "TRAIN":
                    booking = new TrainBooking(distance);
                    break;
                default:
                    booking = new FlightBooking(distance);
            }

            System.out.printf(Locale.US, "%s: %.2f%n",
                    mode, booking.calculateTotal());
        }

        sc.close();
    }
}
