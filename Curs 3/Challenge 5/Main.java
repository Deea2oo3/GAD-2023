public class Main {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3, 1, 4, 2, 5};
        AscBubbleSort ascSort = new AscBubbleSort();
        ascSort.sort(arr);
        System.out.println("Ascending order: " + Arrays.toString(arr));

        Integer[] arr2 = new Integer[]{3, 1, 4, 2, 5};
        DescBubbleSort descSort = new DescBubbleSort();
        descSort.sort(arr2);
        System.out.println("Descending order: " + Arrays.toString(arr2));
    }
}
