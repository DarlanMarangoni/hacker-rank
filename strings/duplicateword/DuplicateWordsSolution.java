import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateWordsSolution {
    /**
     *
     * @param args
     *
     *   \\b: Este é um delimitador de palavra. Ele garante que o padrão comece e termine em um limite de palavra, o que significa que a correspondência deve começar e terminar em uma fronteira de palavra, como espaços, pontuação ou o início/fim do texto.
     *  (\\w+): Aqui temos um grupo de captura que corresponde a uma palavra. \\w+ corresponde a um ou mais caracteres de palavra, incluindo letras, dígitos ou sublinhados.
     *   (\\s+\\1\\b)+: Este é o padrão que verifica se a palavra é repetida consecutivamente. Vamos quebrá-lo em partes menores:
     *       \\s+: Isso corresponde a um ou mais caracteres de espaço em branco.
     *       \\1: Esta é uma referência de retrovisor ao primeiro grupo de captura (\\w+). Ela corresponderá à mesma palavra que foi capturada anteriormente.
     *       \\b: Outro delimitador de palavra. Isso garante que a palavra repetida esteja em uma fronteira de palavra.
     */
    public static void main(String[] args) {
        String regex = "\\b(\\w+)(\\s+\\1\\b)+";
        Pattern p = Pattern.compile(regex , Pattern.CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());

        while (numSentences-- > 0) {
            String input = in.nextLine();

            Matcher m = p.matcher(input);

            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                input = input.replaceAll(m.group(), m.group(1));
            }

            // Prints the modified sentence.
            System.out.println(input);
        }

        in.close();

    }
}
