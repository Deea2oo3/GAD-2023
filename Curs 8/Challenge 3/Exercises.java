import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercises {
    public static void main(String[] args) {
        // Exercise 1
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        StringBuilder sb = new StringBuilder();
        words.forEach(s -> sb.append(s.charAt(0)));
        String result1 = sb.toString();
        System.out.println(result1); // Output: "abc"
        
        // Exercise 2
        List<String> words2 = Arrays.asList("apple", "banana", "cherry");
        List<String> result2 = words2.stream()
                                     .filter(s -> s.length() % 2 == 0)
                                     .collect(Collectors.toList());
        System.out.println(result2); // Output: ["banana"]
        
        // Exercise 3
        List<String> words3 = Arrays.asList("apple", "banana", "cherry");
        List<String> result3 = words3.stream()
                                     .map(String::toUpperCase)
                                     .collect(Collectors.toList());
        System.out.println(result3); // Output: ["APPLE", "BANANA", "CHERRY"]
        
        // Exercise 4
        Map<String, Integer> map = Map.of("apple", 1, "banana", 2, "cherry", 3);
        StringBuilder sb2 = new StringBuilder();
        map.forEach((k, v) -> sb2.append(k).append(v));
        String result4 = sb2.toString();
        System.out.println(result4); // Output: "apple1banana2cherry3"
        
        // Exercise 5
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        new Thread(() -> numbers.forEach(System.out::println)).start();
    }
}
