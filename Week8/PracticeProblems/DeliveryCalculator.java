
import java.util.*;

interface DeliveryService {
    double calculateFee();
}

class StandardService implements DeliveryService {
    private double weight, distance;

    StandardService(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public double calculateFee() {
        return 5 + 0.50 * weight + 0.10 * distance;
    }
}

class ExpressService implements DeliveryService {
    private double weight, distance;

    ExpressService(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public double calculateFee() {
        return 15 + weight + 0.20 * distance;
    }
}

class InternationalService implements DeliveryService {
    private double weight, distance, customsFee;

    InternationalService(double weight, double distance,
                         double customsFee) {
        this.weight = weight;
        this.distance = distance;
        this.customsFee = customsFee;
    }

    public double calculateFee() {
        return 25 + 2 * weight + 0.50 * distance + customsFee;
    }
}

public class DeliveryCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();
            DeliveryService delivery;

            switch (type) {
                case "STANDARD":
                    delivery = new StandardService(weight, distance);
                    break;
                case "EXPRESS":
                    delivery = new ExpressService(weight, distance);
                    break;
                default:
                    double customsFee = sc.nextDouble();
                    delivery = new InternationalService(
                            weight, distance, customsFee);
            }

            double fee = delivery.calculateFee();
            System.out.printf(Locale.US, "%s: %.2f%n", type, fee);
            total += fee;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}
