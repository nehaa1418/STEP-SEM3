import java.util.*;

public class EvenOddCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] parts = sc.nextLine().replaceAll("[\\[\\]]", "").trim().split("\\s*,\\s*");
        int even = 0, odd = 0;

        for (String p : parts) {
            int num = Integer.parseInt(p);
            if (num % 2 == 0) even++;
            else odd++;
        }

        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
        sc.close();
    }
}