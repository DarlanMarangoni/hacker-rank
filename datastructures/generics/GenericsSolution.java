import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsSolution {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Hello", "World");
        List<Integer> integers = Arrays.asList(1,2,3);
        new Printer<Integer>().print(integers);
        new Printer<String>().print(strings);
    }

    static class Printer<T> {
        private void print(List<T> arrayList) {
            arrayList.forEach(System.out::println);
        }
    }
}
