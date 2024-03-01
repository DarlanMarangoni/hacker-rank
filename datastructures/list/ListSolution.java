import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListSolution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfItens = scanner.nextInt();

        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < numberOfItens; i++) {
            integerList.add(scanner.nextInt());
        }
        int numberOfQueries = scanner.nextInt();
        for (int i = 0; i < numberOfQueries; i++) {
            String operation = scanner.next();
            if ("Insert".equals(operation)) {
                int index = scanner.nextInt();
                int number = scanner.nextInt();
                integerList.add(index, number);
            } else {
                int index = scanner.nextInt();
                integerList.remove(index);
            }
        }
        StringBuilder sb = new StringBuilder();
        integerList.forEach(integer -> {
            if (integer != null) {
                sb.append(integer)
                        .append(" ");
            }
        });
        System.out.println(sb.toString().trim());
    }
}
