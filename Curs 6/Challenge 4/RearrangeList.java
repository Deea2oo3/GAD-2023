import java.util.*;

public class RearrangeList {
    
    public static void main(String[] args) {
        List<Integer> input1 = Arrays.asList(4, 3, 7, 8, 6, 2, 1);
        System.out.println(rearrange(input1)); // should print [3, 7, 4, 8, 2, 6, 1]
        
        List<Integer> input2 = Arrays.asList(1, 4, 3, 2);
        System.out.println(rearrange(input2)); // should print [1, 4, 2, 3]
    }
    
    public static List<Integer> rearrange(List<Integer> nums) {
        // Sort the list in ascending order
        Collections.sort(nums);
        
        // Swap adjacent pairs starting from the second element
        for (int i = 1; i < nums.size() - 1; i += 2) {
            Collections.swap(nums, i, i + 1);
        }
        
        return nums;
    }
}
