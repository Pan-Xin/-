import java.util.*;
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int len = array.length;
        if(len == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<len; i++){
            int key = array[i];
            int val = 1;
            if(map.containsKey(key))
                val = map.get(key) + 1;
            map.put(key, val);
        }
        int mid = len / 2 + 1;
        for(Integer key: map.keySet()){
            int num = map.get(key);
            if(num >= mid)
                return key;
        }
        return 0;
    }
}

// Time O(n); Space O(n)