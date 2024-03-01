import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ComparatorSolution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ArrayList<Player> playerList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            Integer score = scanner.nextInt();
            playerList.add(new Player(name, score));
        }
        ScoreComparator scoreComparator = new ScoreComparator();
        playerList.sort(scoreComparator);
        playerList.forEach(player -> System.out.println(player.name + " " + player.score));
    }

    static class Player {
        String name;
        Integer score;

        public Player(String name, Integer score) {
            this.name = name;
            this.score = score;
        }
    }

    static class ScoreComparator implements Comparator<Player> {
        @Override
        public int compare(Player p1, Player p2) {
            int result = p2.score - p1.score;
            if (result == 0) {
                return p1.name.compareTo(p2.name);
            }
            return result;
        }
    }
}
