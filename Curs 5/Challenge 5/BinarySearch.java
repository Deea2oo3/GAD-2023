public class BinarySearch {
    public static <T extends Comparable<T>> int binarySearch(T[] arr, T value) throws ArrayNotSortedException {
        if (!isSorted(arr)) {
            throw new ArrayStoreException("Array is not sorted");
        }

        int low = 0;
        int high = arr.length - 1;
        boolean isAscending = arr[low].compareTo(arr[high]) <= 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            int compareResult = arr[mid].compareTo(value);

            if ((isAscending && compareResult < 0) || (!isAscending && compareResult > 0)) {
                low = mid + 1;
            } else if ((isAscending && compareResult > 0) || (!isAscending && compareResult < 0)) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    private static <T extends Comparable<T>> boolean isSorted(T[] arr) {
        boolean isAscending = arr[0].compareTo(arr[arr.length - 1]) <= 0;

        for (int i = 1; i < arr.length; i++) {
            int compareResult = arr[i].compareTo(arr[i - 1]);
            if ((isAscending && compareResult < 0) || (!isAscending && compareResult > 0)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Integer[] ascendingArr = {1, 2, 3, 4, 5};
        Integer[] descendingArr = {5, 4, 3, 2, 1};

        try {
            int indexAsc = binarySearch(ascendingArr, 3);
            System.out.println("Index of 3 in ascendingArr: " + indexAsc); // Output: 2

            int indexDesc = binarySearch(descendingArr, 3);
            System.out.println("Index of 3 in descendingArr: " + indexDesc); // Output: 2

            int indexUnsorted = binarySearch(new Integer[]{2, 1, 3}, 3); // Throws ArrayNotSortedException
        } catch (ArrayStoreException e) {
            System.out.println(e.getMessage());
        }
    }
}
