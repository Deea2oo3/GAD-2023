import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LCDNumberConverter {
    private static final String[] LCD_DIGITS = {
            " _     _  _     _  _  _  _  _ ",
            "| |  | _| _||_||_ |_   ||_||_|",
            "|_|  ||_  _|  | _||_|  ||_| _|"
    };

    public static void main(String[] args) {
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        String number = readInputFromFile(inputFilePath);
        String lcdNumbers = convertToLCDNumbers(number);

        writeOutputToFile(lcdNumbers, outputFilePath);

        System.out.println("LCD-style numbers generated and written to output.txt");
    }

    private static String readInputFromFile(String filePath) {
        StringBuilder input = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                input.append(line);
            }
        } catch (IOException e) {
            System.out.println("Failed to read input file: " + e.getMessage());
        }

        return input.toString();
    }

    private static String convertToLCDNumbers(String number) {
        StringBuilder lcdNumbers = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            for (char digit : number.toCharArray()) {
                int index = Character.getNumericValue(digit);
                String lcdDigit = LCD_DIGITS[i].substring(index * 3, (index + 1) * 3);
                lcdNumbers.append(lcdDigit).append(' ');
            }
            lcdNumbers.append('\n');
        }

        return lcdNumbers.toString();
    }

    private static void writeOutputToFile(String lcdNumbers, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(lcdNumbers);
        } catch (IOException e) {
            System.out.println("Failed to write output to file: " + e.getMessage());
        }
    }
}
