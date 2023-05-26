import java.util.*;

public class PairCount {
    public static void main(String[] args) {
        int[] arr1 = {3, 2, -3, -2, 3, 0};
        int[] arr2 = {1, 1, 0, -1, -1};
        int[] arr3 = {5, 9, -5, 7, -5};

        int pairCount1 = countPairs(arr1);
        int pairCount2 = countPairs(arr2);
        int pairCount3 = countPairs(arr3);

        System.out.println(Arrays.toString(arr1) + " => " + pairCount1);
        System.out.println(Arrays.toString(arr2) + " => " + pairCount2);
        System.out.println(Arrays.toString(arr3) + " => " + pairCount3);
    }

    public static int countPairs(int[] arr) {
        int pairCount = 0;
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            int complement = -num;
            if (set.contains(complement)) {
                pairCount++;
                set.remove(complement);
            } else {
                set.add(num);
            }
        }

        return pairCount;
    }
}
