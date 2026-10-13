
import java.time.LocalDate;
import java.util.*;

interface Subscription {
    LocalDate renewalDate();
}

class BasicPlan implements Subscription {
    private LocalDate startDate;

    BasicPlan(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate renewalDate() {
        return startDate.plusDays(30);
    }
}

class StandardPlan implements Subscription {
    private LocalDate startDate;

    StandardPlan(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate renewalDate() {
        return startDate.plusDays(90);
    }
}

class PremiumPlan implements Subscription {
    private LocalDate startDate;

    PremiumPlan(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate renewalDate() {
        return startDate.plusDays(365);
    }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            Subscription plan;

            switch (type) {
                case "BASIC":
                    plan = new BasicPlan(startDate);
                    break;
                case "STANDARD":
                    plan = new StandardPlan(startDate);
                    break;
                default:
                    plan = new PremiumPlan(startDate);
            }

            System.out.println(name + ": " + plan.renewalDate());
        }

        sc.close();
    }
}
