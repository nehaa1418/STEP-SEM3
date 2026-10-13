import java.util.*;

class Student {
    String name;
    int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double average() {
        int sum = 0;
        for (int m : marks) sum += m;
        return (double) sum / marks.length;
    }

    String grade() {
        double avg = average();
        if (avg >= 90) return "A";
        else if (avg >= 75) return "B";
        else if (avg >= 60) return "C";
        else if (avg >= 40) return "D";
        else return "F";
    }
}

public class StudentResultCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            int bracket = line.indexOf('[');
            String name = line.substring(0, bracket).trim();
            String[] parts = line.substring(bracket).replaceAll("[\\[\\]]", "").trim().split("\\s*,\\s*");
            int[] marks = new int[parts.length];

            for (int i = 0; i < marks.length; i++) {
                marks[i] = Integer.parseInt(parts[i]);
            }

            Student s = new Student(name, marks);
            System.out.println(String.format(Locale.US, "%s: Average %.1f, Grade %s",
                    s.name.toUpperCase(), s.average(), s.grade()));
        }
        sc.close();
    }
}