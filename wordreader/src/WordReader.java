import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WordReader implements Iterable<String>
{
    private List<String> lines;
    private BufferedReader bReader;
    private int indexCurrentLine  = 0;

    public WordReader()
    {
        this.lines = new ArrayList<String>();
    }

    public void readFile()
    {
        try
        {
            Path currentRelativePath = Paths.get("");
            String currentAbsolutPath = currentRelativePath.toAbsolutePath().toString();
            String filePath = currentAbsolutPath + "/TheHungerGames.txt";
            FileReader reader = new FileReader(filePath);
            this.bReader = new BufferedReader(reader);

            String line = this.bReader.readLine();

            while (line != null)
            {
                this.lines.add(line);
                line = this.bReader.readLine();
            }

            this.bReader.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException a)
        {
            a.printStackTrace();
        }catch (Exception e)
        {
           e.printStackTrace();
        }
    }

    public void readWordsFromCurrentLine()
    {
       String sentence = this.lines.get(indexCurrentLine);

       String[] words =  sentence.split(" ");

        for(String word: words) {
            System.out.println(word);
        }
    }

    @Override
    public Iterator<String> iterator()
    {
        return new Iterator<String>()
        {
            @Override
            public boolean hasNext() {
               if (indexCurrentLine < lines.size())
               {
                   return true;
               }

                return false;
            }

            @Override
            public String next()
            {
                indexCurrentLine++;
                return null;
            }
        };
    }
}