import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class PhonebookSearch {
    public static void main(String[] args) {
        String phonebookUrl = "https://raw.githubusercontent.com/miualinionut/java-training/master/_4_exceptions_io/_test_files/in/phonebook.txt";
        Map<String, String> phonebook = loadPhonebook(phonebookUrl);

        String phoneNumberAbbey = phonebook.get("Abbey");
        String phoneNumberAbdul = phonebook.get("Abdul");

        System.out.println("Phone number of Abbey: " + phoneNumberAbbey);
        System.out.println("Phone number of Abdul: " + phoneNumberAbdul);
    }

    private static Map<String, String> loadPhonebook(String url) {
        Map<String, String> phonebook = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                if (parts.length == 2) {
                    String name = parts[0];
                    String phoneNumber = parts[1];
                    phonebook.put(name, phoneNumber);
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to load phonebook: " + e.getMessage());
        }

        return phonebook;
    }
}
