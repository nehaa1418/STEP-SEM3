
import java.util.*;

interface Parking {
    double calculateCharge();
}

class Bike implements Parking {
    private int hours;

    Bike(int hours) {
        this.hours = hours;
    }

    public double calculateCharge() {
        return hours * 10.0;
    }
}

class Car implements Parking {
    private int hours;

    Car(int hours) {
        this.hours = hours;
    }

    public double calculateCharge() {
        return 30 + (hours - 1) * 20.0;
    }
}

class Truck implements Parking {
    private int hours;

    Truck(int hours) {
        this.hours = hours;
    }

    public double calculateCharge() {
        return Math.max(100, hours * 50.0);
    }
}

public class ParkingCharge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            Parking vehicle;

            switch (type) {
                case "BIKE":
                    vehicle = new Bike(hours);
                    break;
                case "CAR":
                    vehicle = new Car(hours);
                    break;
                default:
                    vehicle = new Truck(hours);
            }

            double charge = vehicle.calculateCharge();
            System.out.printf(Locale.US, "%s: %.2f%n",
                    type, charge);
            total += charge;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}
