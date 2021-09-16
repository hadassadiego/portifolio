import java.util.HashMap;
import java.util.Iterator;

public class WordHistogramHeri extends HashMap<String, Integer> implements Iterable <String>{



    public WordHistogramHeri(String myString) {

        String[] histogram = myString.split(" ");

        for (int i = 0; i < histogram.length; i++) {
            if (containsKey(histogram[i])) {
                put(histogram[i], get(histogram[i]) + 1);
            } else {
                put(histogram[i], 1);
            }
        }


        }

    @Override
    public Iterator<String> iterator() {
        return this.keySet().iterator();
    }

}

