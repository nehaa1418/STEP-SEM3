
import java.util.*;

interface BusUser {
}

abstract class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateTuition();

    double calculateTotalFee() {
        double fee = calculateTuition();

        if (this instanceof BusUser) {
            fee += 12000;
        }

        return fee;
    }
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000 + 60000;
    }
}

class ScholarStudent extends Student implements BusUser {
    ScholarStudent(String name) {
        super(name);
    }

    double calculateTuition() {
        return 20000;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Student student;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;
                default:
                    student = new ScholarStudent(name);
            }

            double fee = student.calculateTotalFee();
            System.out.printf(Locale.US, "%s: %.2f%n", name, fee);
            total += fee;
        }

        System.out.printf(Locale.US,
                "Total Collected: %.2f%n", total);
        sc.close();
    }
}
