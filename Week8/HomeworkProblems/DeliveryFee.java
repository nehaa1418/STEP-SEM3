
import java.util.*;

interface Delivery {
    double calculateFee();
}

class StandardDelivery implements Delivery {
    private double weight, distance;

    StandardDelivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public double calculateFee() {
        return 5 + 0.50 * weight + 0.10 * distance;
    }
}

class ExpressDelivery implements Delivery {
    private double weight, distance;

    ExpressDelivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public double calculateFee() {
        return 15 + weight + 0.20 * distance;
    }
}

class InternationalDelivery implements Delivery {
    private double weight, distance, customsFee;

    InternationalDelivery(double weight, double distance,
                          double customsFee) {
        this.weight = weight;
        this.distance = distance;
        this.customsFee = customsFee;
    }

    public double calculateFee() {
        return 25 + 2 * weight + 0.50 * distance + customsFee;
    }
}

public class DeliveryFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();

            Delivery delivery;

            switch (type) {
                case "STANDARD":
                    delivery = new StandardDelivery(weight, distance);
                    break;
                case "EXPRESS":
                    delivery = new ExpressDelivery(weight, distance);
                    break;
                default:
                    double customsFee = sc.nextDouble();
                    delivery = new InternationalDelivery(
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
