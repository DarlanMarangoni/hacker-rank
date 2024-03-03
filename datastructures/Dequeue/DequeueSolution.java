import java.util.*;

public class DequeueSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Deque<Integer> integers = new ArrayDeque<>();
        HashMap<Integer, Integer> hashSet = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int in = scanner.nextInt();
            integers.addLast(in);
            addOrUpdateCount(in, hashSet);
            if (integers.size() == m) {
                max = Math.max(hashSet.size(), max);
                removeOrUpdateCount(integers.getFirst(), hashSet);
                integers.removeFirst();
            }
        }
        System.out.println(max);
    }

    private static void removeOrUpdateCount(Integer first, HashMap<Integer, Integer> hashSet) {
        Integer count = hashSet.get(first);
        if (count == 1) {
            hashSet.remove(first);
        } else {
            count--;
            hashSet.put(first, count);
        }
    }

    private static void addOrUpdateCount(int in, HashMap<Integer, Integer> hashSet) {
        if (hashSet.get(in) == null) {
            hashSet.put(in, 1);
        } else {
            Integer count = hashSet.get(in);
            count++;
            hashSet.put(in, count);
        }
    }
}
