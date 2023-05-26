import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnagramGenerator {
    public static void main(String[] args) {
        String inputWord = "listen";
        String wordListUrl = "https://gist.githubusercontent.com/calvinmetcalf/084ab003b295ee70c8fc/raw/314abfdc74b50f45f3dbbfa169892eff08f940f2/wordlist.txt";
        String outputFile = "output.txt";

        List<String> wordList = loadWordList(wordListUrl);
        List<String> anagrams = generateAnagrams(inputWord, wordList);

        writeOutputToFile(anagrams, outputFile);

        System.out.println("Anagrams generated and written to output.txt");
    }

    private static List<String> loadWordList(String url) {
        List<String> wordList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(url))) {
            String word;
            while ((word = reader.readLine()) != null) {
                wordList.add(word);
            }
        } catch (IOException e) {
            System.out.println("Failed to load word list: " + e.getMessage());
        }

        return wordList;
    }

    private static List<String> generateAnagrams(String inputWord, List<String> wordList) {
        List<String> anagrams = new ArrayList<>();

        char[] inputChars = inputWord.toCharArray();
        int[] count = new int[26];
        for (char c : inputChars) {
            count[c - 'a']++;
        }

        generateAnagramsHelper(inputChars, count, "", wordList, anagrams);

        return anagrams;
    }

    private static void generateAnagramsHelper(char[] inputChars, int[] count, String currentWord,
                                               List<String> wordList, List<String> anagrams) {
        if (currentWord.length() == inputChars.length) {
            if (wordList.contains(currentWord)) {
                anagrams.add(currentWord);
            }
            return;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                count[i]--;
                generateAnagramsHelper(inputChars, count, currentWord + (char) ('a' + i), wordList, anagrams);
                count[i]++;
            }
        }
    }

    private static void writeOutputToFile(List<String> anagrams, String outputFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (String anagram : anagrams) {
                writer.write(anagram);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Failed to write output to file: " + e.getMessage());
        }
    }
}

