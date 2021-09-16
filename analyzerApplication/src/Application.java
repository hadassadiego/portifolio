import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

    String myFile = "C:\\Projects\\mycodes\\myCodes\\analyzerApplication\\src\\TheHungerGames.txt";
    String secondFile = "C:\\Projects\\mycodes\\myCodes\\analyzerApplication\\Mytext";

    public void readAndCount() throws IOException {

        long words = Files.lines(Paths.get(myFile))
                .flatMap(line -> Stream.of(line.split(" +")))
                .count();

        System.out.println(words);
    }

     Optional<String> firstWord() throws IOException {

        Optional<String> firstWordInText = Files.lines(Paths.get(myFile))
                .flatMap(line -> Stream.of(line.split(" ")))
                .filter(words -> words.length() > 100)
                .findFirst();

         System.out.println("The first word is: " + firstWordInText.orElse("empty"));

         return firstWordInText;
    }

    public void longestWord(int max) throws IOException {
        Stream<String> longestWordInText = Files.lines(Paths.get(myFile))
                .flatMap(line -> Stream.of(line.split("[\\s-.]"))) //s space... tudo apos as barras eh deletado
                .sorted((word1, word2) -> word2.length() - word1.length())
                .distinct()
                .limit(max);

        System.out.println(longestWordInText.collect(Collectors.joining("\n")));

    }

    public void commonWords() throws IOException {

        List<String> firstText = Files.lines(Paths.get(myFile))
                .flatMap(line -> Stream.of(line.split(" ")))
                .collect(Collectors.toList());

        List<String> matchingWords = Files.lines(Paths.get(secondFile))
                .flatMap(line -> Stream.of(line.split(" ")))
                .filter(word1 -> firstText.contains(word1))
                .distinct()
                .collect(Collectors.toList());

        System.out.println(matchingWords);

    }
}