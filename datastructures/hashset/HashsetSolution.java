import java.util.HashSet;
import java.util.Scanner;

public class HashsetSolution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPairs = scanner.nextInt();

        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < numberOfPairs; i++) {
            String n1 = scanner.next();
            String n2 = scanner.next();
            hashSet.add(String.join(",", n1, n2));
            System.out.println(hashSet.size());
        }
    }
}
