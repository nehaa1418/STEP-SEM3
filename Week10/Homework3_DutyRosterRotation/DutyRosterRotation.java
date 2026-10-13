import java.util.*;

public class DutyRosterRotation {
    // Time: O(n), Space: O(n) for the result.
    // Rotating one place at a time, k times, costs O(n * k), which is too slow for k up to 10^9.
    static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        int shift = (int) (k % n);
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            result[(i + shift) % n] = names[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];

        for (int i = 0; i < n; i++) names[i] = sc.next();
        long k = sc.nextLong();

        System.out.println(Arrays.toString(rotateRoster(names, k)));
        sc.close();
    }
}