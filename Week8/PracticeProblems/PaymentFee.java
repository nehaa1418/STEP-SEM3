
import java.util.*;

interface Payment {
    double calculateAmount();
}

class CardPayment implements Payment {
    private double amount;

    CardPayment(double amount) {
        this.amount = amount;
    }

    public double calculateAmount() {
        return amount * 1.02;
    }
}

class WalletPayment implements Payment {
    private double amount;

    WalletPayment(double amount) {
        this.amount = amount;
    }

    public double calculateAmount() {
        return amount * 1.01;
    }
}

class BankTransfer implements Payment {
    private double amount;

    BankTransfer(double amount) {
        this.amount = amount;
    }

    public double calculateAmount() {
        return amount;
    }
}

public class PaymentFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            Payment payment;

            switch (type) {
                case "CARD":
                    payment = new CardPayment(amount);
                    break;
                case "WALLET":
                    payment = new WalletPayment(amount);
                    break;
                default:
                    payment = new BankTransfer(amount);
            }

            double adjusted = payment.calculateAmount();
            System.out.printf(Locale.US, "%s: %.2f%n",
                    type, adjusted);
            total += adjusted;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}
