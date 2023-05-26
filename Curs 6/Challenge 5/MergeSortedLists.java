import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortedLists {
    
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 5, 6);
        List<Integer> list2 = Arrays.asList(2, 3, 4);
        
        List<Integer> merged = mergeLists(list1, list2);
        System.out.println(merged); // should print [1, 2, 3, 4, 5, 6]
    }
    
    public static List<Integer> mergeLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;
        
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                merged.add(list1.get(i));
                i++;
            } else {
                merged.add(list2.get(j));
                j++;
            }
        }
        
        while (i < list1.size()) {
            merged.add(list1.get(i));
            i++;
        }
        
        while (j < list2.size()) {
            merged.add(list2.get(j));
            j++;
        }
        
        return merged;
    }
}
