import java.util.*;

public class ExamScoreBand {
    // First index with scores[i] >= target
    static int lowerBound(int[] a, int target) {
        int lo = 0, hi = a.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (a[mid] >= target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    // First index with scores[i] > target
    static int upperBound(int[] a, int target) {
        int lo = 0, hi = a.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (a[mid] > target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    // Linear scan: O(n) time, O(1) space.
    // This solution: O(log n) time, O(1) space.
    // Duplicates at the edges mean a normal binary search is not enough, because it stops
    // at any match. The two searches find the first position of low and the position just
    // past the last high, so every duplicate is counted.
    static int countInBand(int[] scores, int low, int high) {
        return upperBound(scores, high) - lowerBound(scores, low);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) scores[i] = sc.nextInt();
        int low = sc.nextInt(), high = sc.nextInt();

        System.out.println(countInBand(scores, low, high));
        sc.close();
    }
}