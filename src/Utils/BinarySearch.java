package Utils;

import java.util.Comparator;
import java.util.List;

public class BinarySearch {
    
    public static <T> int binarySearch(List<T> list, T key, Comparator<T> comparator) {
        int low = 0;
        int high = list.size() - 1;
        
        while (low <= high) {
            int mid = (low + high) >>> 1;
            T midVal = list.get(mid);
            int cmp = comparator.compare(midVal, key);
            
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid; 
            }
        }
        return -1; 
    }
}