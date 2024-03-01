import java.util.Scanner;
import java.util.Stack;

public class StackSolution {
    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            Stack<String> stack = new Stack<>();
            String input = sc.next();
            for (int i = 0; i < input.length(); i++) {
                String substring = input.substring(i, i + 1);
                stack.push(substring);
            }
            System.out.println(isValid(stack) ? "true": "false");

        }
    }

    private static boolean isValid(Stack<String> openStack) {
        if (openStack.size() % 2 != 0) {
            return false;
        }
        Stack<String> s = new Stack<>();
        for (int i = 0; i < openStack.size(); i++) {
            s.push(openStack.get(i));
            if (i > 0 && s.size() > 1) {
                String ultimo = s.get(s.size() - 1);
                String penultimo = s.get(s.size() - 2);
                if (isvalid(ultimo, penultimo)) {
                    s.pop();
                    s.pop();
                }
            }
        }
        return s.isEmpty();
    }

    private static boolean isvalid(String ultimo, String penultimo) {
        if ("(".equals(penultimo)) {
            return ")".equals(ultimo);
        }
        if ("[".equals(penultimo)) {
            return "]".equals(ultimo);
        }
        if ("{".equals(penultimo)) {
            return "}".equals(ultimo);
        }
        return false;
    }
}
