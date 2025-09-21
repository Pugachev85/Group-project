package Utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinarySearch {
    
    public static <T> List<Integer> binarySearchAll(List<T> list, T key, Comparator<T> comparator) {
        List<Integer> results = new ArrayList<>();
        
        if (list.isEmpty()) {
            return results;
        }
        
        int firstIndex = findFirstIndex(list, key, comparator);
        if (firstIndex == -1) {
            return results;
        }
        
        int current = firstIndex;
        while (current < list.size() && comparator.compare(list.get(current), key) == 0) {
            results.add(current);
            current++;
        }
        
        return results;
    }
    
    private static <T> int findFirstIndex(List<T> list, T key, Comparator<T> comparator) {
        int low = 0;
        int high = list.size() - 1;
        int result = -1;
        
        while (low <= high) {
            int mid = (low + high) >>> 1;
            T midVal = list.get(mid);
            int cmp = comparator.compare(midVal, key);
            
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                result = mid;
                high = mid - 1;
            }
        }
        return result;
    }
}