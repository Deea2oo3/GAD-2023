import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        String inputFilePath = "input.txt";

        Map<String, Integer> wordCountMap = countWords(inputFilePath);
        List<Map.Entry<String, Integer>> topWordCounts = getTopWordCounts(wordCountMap, 10);

        displayTopWordCounts(topWordCounts);
    }

    private static Map<String, Integer> countWords(String filePath) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        try (Scanner scanner = new Scanner(new File(filePath))) {
            scanner.useDelimiter("[^a-zA-Z]+");

            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        return wordCountMap;
    }

    private static List<Map.Entry<String, Integer>> getTopWordCounts(Map<String, Integer> wordCountMap, int count) {
        List<Map.Entry<String, Integer>> wordCounts = new ArrayList<>(wordCountMap.entrySet());
        wordCounts.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        return wordCounts.subList(0, Math.min(count, wordCounts.size()));
    }

    private static void displayTopWordCounts(List<Map.Entry<String, Integer>> topWordCounts) {
        System.out.println("Top " + topWordCounts.size() + " word counts:");

        for (Map.Entry<String, Integer> entry : topWordCounts) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
