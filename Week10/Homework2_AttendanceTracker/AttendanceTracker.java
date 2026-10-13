import java.util.*;

public class AttendanceTracker {
    // Time: O(n), Space: O(1). Both answers come from a single pass.
    static int[] attendanceSummary(int[] days) {
        int present = 0, longest = 0, run = 0;

        for (int d : days) {
            if (d == 1) {
                present++;
                run++;
                longest = Math.max(longest, run);
            } else {
                run = 0;
            }
        }
        return new int[]{present, longest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] days = new int[n];

        for (int i = 0; i < n; i++) days[i] = sc.nextInt();

        int[] res = attendanceSummary(days);
        System.out.println("Present: " + res[0] + ", Longest streak: " + res[1]);
        sc.close();
    }
}