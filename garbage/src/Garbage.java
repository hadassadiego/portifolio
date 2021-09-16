import java.util.stream.Stream;

public class Garbage {

    public static void main(String[] args) {

        String message = "I'll send an SOS to the garbage world, " +
                "I hope that someone garbage gets my message in a garbage bottle";

        String words = Stream.of(message.split(" "))
                .filter(word -> !word.equals("garbage"))
                .map(word -> word.toUpperCase())
                //.map(String::toUpperCase)
                .reduce("", (acc, elem) -> acc + " " + elem);

        System.out.println(words);

    }





}
