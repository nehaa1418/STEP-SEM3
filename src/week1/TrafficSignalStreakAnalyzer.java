public class TrafficSignalStreakAnalyzer {

    static void findLongestStreak(String signalLog) {

        int currentStreak = 1;
        int maxStreak = 1;
        char maxColor = signalLog.charAt(0);

        for (int i = 1; i < signalLog.length(); i++) {

            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                currentStreak++;
            } 
            else {
                currentStreak = 1;
            }

            if (currentStreak > maxStreak) {
                maxStreak = currentStreak;
                maxColor = signalLog.charAt(i);
            }
        }

        System.out.println(
            "Longest Streak: '" + maxColor +
            "' repeated " + maxStreak + " times"
        );
    }

    public static void main(String[] args) {

        String signalLog = "RRGGGYRR";

        findLongestStreak(signalLog);
    }
}