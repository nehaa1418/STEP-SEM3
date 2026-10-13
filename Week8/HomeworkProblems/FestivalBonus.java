
import java.util.*;

interface Bonus {
    double calculateBonus();
}

class FullTime implements Bonus {
    private double salary;

    FullTime(double salary) {
        this.salary = salary;
    }

    public double calculateBonus() {
        return salary * 0.10;
    }
}

class PartTime implements Bonus {
    private double salary;

    PartTime(double salary) {
        this.salary = salary;
    }

    public double calculateBonus() {
        return salary * 0.05;
    }
}

class Intern implements Bonus {
    public double calculateBonus() {
        return 2000;
    }
}

public class FestivalBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            Bonus employee;

            switch (type) {
                case "FULLTIME":
                    employee = new FullTime(salary);
                    break;
                case "PARTTIME":
                    employee = new PartTime(salary);
                    break;
                default:
                    employee = new Intern();
            }

            double bonus = employee.calculateBonus();
            System.out.printf(Locale.US, "%s: %.2f%n", name, bonus);
            total += bonus;
        }

        System.out.printf(Locale.US, "Total Bonus: %.2f%n", total);
        sc.close();
    }
}
