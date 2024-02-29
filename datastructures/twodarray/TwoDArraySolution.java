import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class TwoDArraySolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        List<Integer> max = new ArrayList<>(0);
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).size(); j++) {
                Optional<Integer> sum = sumHourGlasses(arr, i, j);
                sum.ifPresent(max::add);
            }
        }
        System.out.println(max.stream().max(Comparator.naturalOrder()).get());
        bufferedReader.close();
    }

    private static Optional<Integer> sumHourGlasses(List<List<Integer>> arr, int i, int j) {
        if (i < 4 && j < 4) {
            int[] ints = new int[7];
            ints[0] = arr.get(i).get(j);
            ints[1] = arr.get(i).get(j + 1);
            ints[2] = arr.get(i).get(j + 2);
            ints[3] = arr.get(i + 1).get(j + 1);
            ints[4] = arr.get(i + 2).get(j);
            ints[5] = arr.get(i + 2).get(j + 1);
            ints[6] = arr.get(i + 2).get(j + 2);
            return Optional.of(Arrays.stream(ints).sum());
        }
        return Optional.empty();
    }
}
