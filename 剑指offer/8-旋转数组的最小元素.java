import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        int len = array.length;
        if(len == 0)
            return 0;
        
        return searchMin(array, 0, len - 1);
    }
    
    public int searchMin(int[] arr, int low, int high){
        if(high == low)
            return arr[low];
        else if(high - low == 1){
            if(arr[high] < arr[low])
                return arr[high];
            else
                return arr[low];
        }
        
        int mid = (low + high) / 2;
        if(arr[mid] < arr[low])
            return searchMin(arr, low, mid);
        else if(arr[high] < arr[mid + 1])
            return searchMin(arr, mid + 1, high);
        else
            return arr[mid + 1];
    }
}

// Time: O(logn)