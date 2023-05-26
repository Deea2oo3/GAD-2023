import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class SecretMessageDecoder {
    public static void main(String[] args) {
        String textUrl = "https://raw.githubusercontent.com/miualinionut/java-training/master/_4_exceptions_io/_test_files/in/message.txt";
        String secretMessage = decodeSecretMessage(textUrl);
        System.out.println("Secret Message: " + secretMessage);
    }

    private static String decodeSecretMessage(String url) {
        StringBuilder secretMessageBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    if (Character.isUpperCase(c) || c == 'X') {
                        if (c == 'X') {
                            secretMessageBuilder.append(' ');
                        } else {
                            secretMessageBuilder.append(c);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to decode secret message: " + e.getMessage());
        }

        return secretMessageBuilder.toString();
    }
}