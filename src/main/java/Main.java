import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        String input = "Java Academy By Global Logic";
        countOccurences(input);
    }

    public static void countOccurences(String input) {

        HashMap<String, Integer> occurence = new HashMap<>();
        String[] wordIntoLetters = input.toLowerCase().split("");
        for (int i = 0; i < input.length(); i++) {
            if (occurence.containsKey(wordIntoLetters[i])) {
                occurence.merge(wordIntoLetters[i], 0, (newValue, notUsed) -> {
                    return newValue + 1;
                });
            } else occurence.put(wordIntoLetters[i], 1);
        }
        List<Map.Entry<String, Integer>> result =
                occurence.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByKey())
                        .collect(Collectors.toList());

        for (Map.Entry e : result) {
            System.out.println(e.getKey().toString().replace(" ", "space") + ": " + e.getValue());
        }
    }
}
