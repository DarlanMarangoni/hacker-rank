import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsSolution {
    public static void main(String[] args) {
        new Printer<Integer>().print(Arrays.asList(1,2,3));
        new Printer<String>().print(Arrays.asList("Hello", "World"));
    }

    static class Printer<T> {
        private void print(List<T> arrayList) {
            arrayList.forEach(System.out::println);
        }
    }
}
