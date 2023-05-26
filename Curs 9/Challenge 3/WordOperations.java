import java.util.Arrays;
import java.util.List;

public class WordOperations {
    private static List<String> words = Arrays.asList(
            "the",
            "quick",
            "brown",
            "fox",
            "jumped",
            "over",
            "the",
            "lazy",
            "dog");

    static void displayingLetters() {
        int count = 1;
        for (String word : words) {
            for (char letter : word.toCharArray()) {
                System.out.println(count++ + ". " + letter);
            }
        }
    }

    static void findingMissingLetter() {
        int count = 1;
        for (String word : words) {
            if (word.length() < 3) {
                for (char letter : word.toCharArray()) {
                    System.out.println(count++ + ". " + letter);
                }
            }
        }
    }

    static void restoringMissingLetter() {
        int count = 1;
        for (String word : words) {
            if (word.length() < 3) {
                StringBuilder reconstructedWord = new StringBuilder(word);
                reconstructedWord.insert(1, 'a');
                for (char letter : reconstructedWord.toString().toCharArray()) {
                    System.out.println(count++ + ". " + letter);
                }
            }
        }
    }

    public static void main(String[] args) {
        displayingLetters();
        System.out.println();
        findingMissingLetter();
        System.out.println();
        restoringMissingLetter();
    }
}


