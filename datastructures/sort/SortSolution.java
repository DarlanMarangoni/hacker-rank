import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class SortSolution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ArrayList<Student> studentList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Integer id = scanner.nextInt();
            String name = scanner.next();
            Double note = scanner.nextDouble();
            studentList.add(new Student(id, name, note));
        }
        PlayerComparator playerComparator = new PlayerComparator();
        studentList.sort(playerComparator);
        studentList.forEach(student -> System.out.println(student.name));
    }

    static class Student {
        Integer id;
        String name;
        Double note;

        public Student(Integer id, String name, Double note) {
            this.id = id;
            this.name = name;
            this.note = note;
        }
    }

    static class PlayerComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            int result = Double.compare(s2.note, s1.note);
            if (result == 0) {
                return s1.name.compareTo(s2.name);
            }
            return result;
        }
    }
}
