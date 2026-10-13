
import java.util.*;

interface CustomerBill {
    double calculate();
}

class StudentBill implements CustomerBill {
    private double amount;

    StudentBill(double amount) {
        this.amount = amount;
    }

    public double calculate() {
        return amount * 0.90;
    }
}

class StaffBill implements CustomerBill {
    private double amount;

    StaffBill(double amount) {
        this.amount = amount;
    }

    public double calculate() {
        return amount * 0.95;
    }
}

class GuestBill implements CustomerBill {
    private double amount;

    GuestBill(double amount) {
        this.amount = amount;
    }

    public double calculate() {
        return amount + 10;
    }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            CustomerBill bill;

            switch (type) {
                case "STUDENT":
                    bill = new StudentBill(amount);
                    break;
                case "STAFF":
                    bill = new StaffBill(amount);
                    break;
                default:
                    bill = new GuestBill(amount);
            }

            double finalAmount = bill.calculate();
            System.out.printf(Locale.US, "%s: %.2f%n",
                    type, finalAmount);
            total += finalAmount;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}
