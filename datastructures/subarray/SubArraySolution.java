import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubArraySolution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfItens = in.nextInt();
        List<Integer> inputList = new ArrayList<>(numberOfItens);

        for (int i = 0; i < numberOfItens; i++) {
            inputList.add(in.nextInt());
        }

        List<List<Integer>> subArrays = createSubArrays(inputList);

        int size = (int) subArrays
                .stream()
                .filter(i -> i.stream().reduce(0, Integer::sum) < 0)
                .count();
        System.out.println(size);
    }

    private static List<List<Integer>> createSubArrays(List<Integer> inputList) {
        List<List<Integer>> intList = new ArrayList<>(0);

        int subListSize = 1;
        while (subListSize <= inputList.size()) {
            for (int j = 0; j < inputList.size(); j++) {
                if (j + subListSize <= inputList.size()) {
                    intList.add(inputList.subList(j, j + subListSize));
                }
            }
            subListSize++;
        }
        return intList;
    }
}
