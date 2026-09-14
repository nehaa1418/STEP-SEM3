import java.util.Arrays;
import java.util.Scanner;

class Player implements Comparable<Player> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    public int compareTo(Player other) {

        if (this.battingAverage < other.battingAverage) {
            return 1;
        } else if (this.battingAverage > other.battingAverage) {
            return -1;
        }

        return 0;
    }

    static String draftAndRank(Player[] players) {

        Player[] temp = new Player[players.length];

        int count = 0;

        for (int i = 0; i < players.length; i++) {

            if (isDraftable(players[i].matchesPlayed)
                    || isDraftable(players[i].matchesPlayed, players[i].injured)) {

                temp[count] = players[i];
                count++;
            }
        }

        Player[] draftable = new Player[count];

        for (int i = 0; i < count; i++) {
            draftable[i] = temp[i];
        }

        Arrays.sort(draftable);

        String result = "";

        for (int i = 0; i < draftable.length; i++) {

            result = result + (i + 1) + ". " + draftable[i].name;

            if (i < draftable.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }
}

public class FantasyLeagueAutoDraftRankingEngine {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();
        sc.nextLine();

        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {

            System.out.println("Enter player " + (i + 1) + " details:");

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Matches played: ");
            int matchesPlayed = sc.nextInt();

            System.out.print("Batting average: ");
            double battingAverage = sc.nextDouble();

            System.out.print("Injured (true/false): ");
            boolean injured = sc.nextBoolean();
            sc.nextLine();

            players[i] = new Player(
                    name,
                    matchesPlayed,
                    battingAverage,
                    injured
            );
        }

        System.out.println(Player.draftAndRank(players));
    }
}