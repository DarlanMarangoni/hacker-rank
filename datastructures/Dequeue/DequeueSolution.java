import java.util.*;
import java.util.stream.Collectors;

public class DequeueSolution {
    public static void main(String[] args) {
        long init = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Deque<Integer> integers = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            integers.addLast(scanner.nextInt());
        }

        int max = 0;
        for (int i = 0; i < integers.size(); i++) {
            if (i + m <= integers.size()) {
                Set<Integer> integerSet = new HashSet<>(new ArrayList<>(integers).subList(i, i + m));
                integers.removeFirst();
                max = Math.max(integerSet.size(), max);
            }
        }
        System.out.println(max);
        System.err.println(System.currentTimeMillis() - init);
    }
}
