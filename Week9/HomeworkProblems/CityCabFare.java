
import java.util.*;

interface NightService {
}

abstract class Cab {
    private static final double MIN_FARE = 100.0;
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    final double calculateFare(boolean night) {
        double fare = Math.max(MIN_FARE, km * getRate());

        if (night) {
            fare *= 1.20;
        }

        return fare;
    }
}

class MiniCab extends Cab {
    MiniCab(double km) {
        super(km);
    }

    double getRate() {
        return 10;
    }
}

class SedanCab extends Cab implements NightService {
    SedanCab(double km) {
        super(km);
    }

    double getRate() {
        return 14;
    }
}

class SUVCab extends Cab implements NightService {
    SUVCab(double km) {
        super(km);
    }

    double getRate() {
        return 18;
    }
}

public class CityCabFare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();
            boolean night = time.equals("NIGHT");
            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new MiniCab(km);
                    break;
                case "SEDAN":
                    cab = new SedanCab(km);
                    break;
                default:
                    cab = new SUVCab(km);
            }

            if (night && !(cab instanceof NightService)) {
                System.out.println(type + ": night service not available");
            } else {
                double fare = cab.calculateFare(night);
                System.out.printf(Locale.US, "%s: %.2f%n", type, fare);
                total += fare;
            }
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}
