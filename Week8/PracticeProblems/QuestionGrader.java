
import java.util.*;
import java.util.regex.*;

interface Grading {
    double calculateScore();
}

class MCQGrading implements Grading {
    private String correct, answer;
    private double points;

    MCQGrading(String correct, String answer, double points) {
        this.correct = correct;
        this.answer = answer;
        this.points = points;
    }

    public double calculateScore() {
        return answer.equals(correct) ? points : 0;
    }
}

class TFGrading implements Grading {
    private String correct, answer;
    private double points;

    TFGrading(String correct, String answer, double points) {
        this.correct = correct;
        this.answer = answer;
        this.points = points;
    }

    public double calculateScore() {
        return answer.equals(correct) ? points : 0;
    }
}

class EssayGrading implements Grading {
    private String correct, answer;
    private double points;

    EssayGrading(String correct, String answer, double points) {
        this.correct = correct;
        this.answer = answer;
        this.points = points;
    }

    public double calculateScore() {
        String[] keywords = correct.split(",");
        int count = 0;

        for (String keyword : keywords) {
            if (answer.toLowerCase().contains(
                    keyword.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        }

        return 0;
    }
}

public class QuestionGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        Pattern pattern = Pattern.compile(
                "^(\\S+)\\s+\"(.*?)\"\\s+\"(.*?)\"\\s+\"(.*?)\"\\s+(\\d+)$");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            Matcher matcher = pattern.matcher(line);

            if (!matcher.matches()) {
                System.out.println("Invalid input");
                return;
            }

            String type = matcher.group(1);
            String correct = matcher.group(3);
            String answer = matcher.group(4);
            double points = Double.parseDouble(matcher.group(5));

            Grading grading;

            switch (type) {
                case "MCQ":
                    grading = new MCQGrading(
                            correct, answer, points);
                    break;
                case "TF":
                    grading = new TFGrading(
                            correct, answer, points);
                    break;
                default:
                    grading = new EssayGrading(
                            correct, answer, points);
            }

            double score = grading.calculateScore();
            System.out.printf(Locale.US, "%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf(Locale.US, "Total Score: %.2f%n", total);
        sc.close();
    }
}
