import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListSolution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfLines = scanner.nextInt();

        ArrayList<ArrayList<Integer>> playList = new ArrayList<>(0);

        for (int i = 0; i < numberOfLines; i++) {
            int numberOfColumns = scanner.nextInt();
            ArrayList<Integer> coluns = new ArrayList<>(numberOfColumns);
            for (int j = 0; j < numberOfColumns; j++) {
                coluns.add(scanner.nextInt());
            }
            playList.add(coluns);
        }


        int numberOfPlay = scanner.nextInt();
        for (int i = 0; i < numberOfPlay; i++) {
            int line = scanner.nextInt() - 1;
            int column = scanner.nextInt() - 1;
            try {
                Integer integer = playList.get(line).get(column);
                System.out.println(integer);
            } catch (Exception ex) {
                System.out.println("ERROR!");
            }
        }
    }
}
