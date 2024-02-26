import java.util.Scanner;

class UsernameValidator {
    /*
     * ^ inicio de linha
     * $ final de linha
     * [a-zA-Z] qualquer letra alfanumerica
     * [a-zA-Z0-9_]{7,29} qualquer letra, numero ou underline em seguida a quantidade minima e maxima
     */
    public static final String regularExpression = "^[a-zA-Z][a-zA-Z0-9_]{7,29}$";
}


public class Solution {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine());
        while (n-- != 0) {
            String userName = scan.nextLine();

            if (userName.matches(UsernameValidator.regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        }
    }
}