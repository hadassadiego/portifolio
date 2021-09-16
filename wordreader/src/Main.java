import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        WordReader wordReader = new WordReader();

        wordReader.readFile();

        Iterator<String> iterator = wordReader.iterator();

        while (iterator.hasNext())
        {
            wordReader.readWordsFromCurrentLine();
            iterator.next();
        }
    }
}