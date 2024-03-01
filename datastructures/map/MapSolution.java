import java.util.HashMap;
import java.util.Scanner;

public class MapSolution {

    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        HashMap<String, Integer> phoneMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            in.nextLine();
            phoneMap.put(name, phone);
        }
        while (in.hasNext()) {
            String searchName = in.nextLine();
            Integer integer = phoneMap.get(searchName);
            if (integer != null) {
                System.out.println(searchName + "=" + integer);
            } else {
                System.out.println("Not found");
            }
        }
    }

}
