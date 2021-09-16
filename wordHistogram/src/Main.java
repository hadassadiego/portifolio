public class Main {



    public static void main(String[] args) {

        String string = "batata batata batata arroz arroz arroz feijao";

        WordHistogramComp wordHistogramComp = new WordHistogramComp(string);

        WordHistogramHeri wordHistogramHeri = new WordHistogramHeri(string);

        for (String word: wordHistogramHeri) {

            System.out.println(word + ".." + wordHistogramHeri.get(word));
        }
    }





    }
