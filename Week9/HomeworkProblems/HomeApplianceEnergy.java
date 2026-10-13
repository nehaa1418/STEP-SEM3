
import java.util.*;

interface SaverMode {
    double applySaver(double units);
}

abstract class Appliance {
    abstract double getPower();

    double calculateUnits(double hours) {
        return getPower() * hours / 1000.0;
    }
}

class Fridge extends Appliance {
    double getPower() {
        return 150;
    }
}

class AirConditioner extends Appliance implements SaverMode {
    double getPower() {
        return 1500;
    }

    public double applySaver(double units) {
        return units * 0.75;
    }
}

class Television extends Appliance {
    double getPower() {
        return 100;
    }
}

class Washer extends Appliance implements SaverMode {
    double getPower() {
        return 500;
    }

    public double applySaver(double units) {
        return units * 0.75;
    }
}

public class HomeApplianceEnergy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");
            String type = input[0];
            double hours = Double.parseDouble(input[1]);
            boolean saver = input.length == 3
                    && input[2].equals("SAVER");

            Appliance appliance;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge();
                    break;
                case "AC":
                    appliance = new AirConditioner();
                    break;
                case "TV":
                    appliance = new Television();
                    break;
                default:
                    appliance = new Washer();
            }

            if (saver && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = appliance.calculateUnits(hours);

            if (saver) {
                units = ((SaverMode) appliance).applySaver(units);
            }

            double cost = units * 8;
            System.out.printf(Locale.US,
                    "%s: Units=%.2f Cost=%.2f%n", type, units, cost);
            totalCost += cost;
        }

        System.out.printf(Locale.US, "Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
