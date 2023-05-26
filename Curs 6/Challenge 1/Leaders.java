import java.util.*;
public class Leaders {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(16, 17, 4, 3, 5, 2);
        List<Integer> leaders = findLeaders(nums);
        System.out.println(leaders); // [17, 5, 2]
    }
    public static List<Integer> findLeaders(List<Integer> nums) {
        List<Integer> leaders = new ArrayList<>();
        int n = nums.size();
        int maxSoFar = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums.get(i) > maxSoFar) {
                maxSoFar = nums.get(i);
                leaders.add(maxSoFar);
            }
        }
        Collections.reverse(leaders);
        return leaders;
    }
}