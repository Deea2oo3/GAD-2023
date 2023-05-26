import java.util.*;

public class TripletCount {
    public static void main(String[] args) {
        int[] arr = {-1, -1, -1, 2};

        int tripletCount = countTriplets(arr);

        System.out.println(Arrays.toString(arr) + " => " + tripletCount);
    }

    public static int countTriplets(int[] arr) {
        int tripletCount = 0;
        int n = arr.length;

        Arrays.sort(arr);

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue; // Skip duplicates
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) {
                    tripletCount++;
                    left++;
                    right--;

                    while (left < right && arr[left] == arr[left - 1]) {
                        left++; // Skip duplicates
                    }
                    while (left < right && arr[right] == arr[right + 1]) {
                        right--; // Skip duplicates
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return tripletCount;
    }
}

