import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TagContentExtractorSolution {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            String line = in.nextLine();

            List<String> tags = getTags(line);

            int index = 0;
            int countValid = 0;

            if (tags == null) {
                tags = new ArrayList<>();
            }

            if (tags.isEmpty() || notExistContent(tags)) {
                System.out.println("None");
            }

            for (String tag : tags) {
                if (!tag.startsWith("<")) {
                    if (index < tags.size() - 1 && same(tags.get(index - 1), tags.get(index + 1))) {
                        System.out.println(tag);
                        countValid++;
                    } else {
                        if (countValid == 0 && allIsInvalid(tag, tags)) {
                            System.out.println("None");
                        }
                    }
                }
                index++;
            }

            testCases--;
        }
    }

    private static boolean notExistContent(List<String> tags) {
        if (tags == null) {
            return false;
        }
        List<String> list = tags.stream().filter(f -> !f.startsWith("<") && !f.startsWith(">")).collect(Collectors.toList());
        return list.isEmpty();
    }

    private static boolean allIsInvalid(String tag, List<String> tags) {
        List<String> list = tags.stream().filter(f -> !f.startsWith("<") && !f.startsWith(">")).collect(Collectors.toList());
        return list.isEmpty() || list.get(list.size() - 1).equals(tag);
    }

    private static boolean same(String s, String s1) {
        if (!s1.contains("/")) {
            return false;
        }
        if (s.equals("<>")) {
            return false;
        }
        s1 = s1.replace("/", "");
        return s.equals(s1);
    }

    private static List<String> getTags(String line) {
        List<String> tags = new ArrayList<>(0);
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '<') {
                String tag = line.substring(i);
                tags.add(tag.substring(0, tag.indexOf('>') + 1));
            }
            if (i < line.length() - 1 && line.charAt(i) == '>' && (line.charAt(i + 1) != '<' && line.charAt(i + 1) != '>')) {
                String content = line.substring(i + 1);
                if (content.indexOf('<') != -1) {
                    tags.add(content.substring(0, content.indexOf('<')));
                } else {
                    tags.add(content);
                }
            }
        }
        return tags.stream().filter(f -> !f.equals("")).collect(Collectors.toList());
    }
}
