import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class WordHistogramComp implements Iterable<String> {

    private Map<String, Integer> hashMap;
    private String myString;



    public WordHistogramComp (String myString) {
        hashMap = new HashMap<>();


        String[] histogram = myString.split(" ");

        for (int i = 0; i < histogram.length; i++) {
            if (hashMap.containsKey(histogram[i])){
            hashMap.put(histogram[i], hashMap.get(histogram[i])+1); }
                else {
                    hashMap.put(histogram[i], 1);
                    }

                }
            }
        @Override
        public Iterator iterator() {
        return hashMap.keySet().iterator();
    }

    public int get(String word) {
        return hashMap.get(word);
    }
    }




