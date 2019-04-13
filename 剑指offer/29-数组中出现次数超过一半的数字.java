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

//Method 1: Time O(n); Space O(n)

public class Solution {
    public void swap(int[] arr, int i1, int i2){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
    
    public int partition(int[] arr, int start, int end){
        if(start >= end)
            return start;
        int i = start;
        int j = end;
        while(i != j){
            while(arr[j] >= arr[start] && i != j)
                j --;
            while(arr[i] <= arr[start] && i != j)
                i ++;
            swap(arr, i, j);
        }
        swap(arr, start, j);
        return i;
    }
    
    public int MoreThanHalfNum_Solution(int[] arr){
        int len = arr.length;
        if(len == 0) return 0;
        
        int mid = len / 2;
        int start = 0;
        int end = len - 1;
        int cur = partition(arr, start, end);
        
        while(cur != mid){
            if(cur > mid) end = cur - 1;
            else start = cur + 1;
            cur = partition(arr, start, end);
        }
        int cont = 0;
        for(int i=0; i<len; i++) {
            if(arr[i] == arr[cur])
                cont ++;
        }
        if(cont > mid) return arr[cur];
        return 0;
    }
}

//Method 2: 利用快排的思想，Time O(n)，Space O(1)

public class Solution {
    
    public int MoreThanHalfNum_Solution(int[] arr){
        int len = arr.length;
        if(len == 0) return 0;
        
        int curNum = arr[0];
        int curCont = 1;
        for(int i=1; i<len; i++) {
            if(arr[i] == curNum)
                curCont ++;
            else {
                curCont --;
                if(curCont == 0) {
                    curNum = arr[i];
                    curCont = 1;
                }
            }
        }
        
        int cont = 0;
        for(int i=0; i<len; i++) {
            if(arr[i] == curNum)
                cont ++;
        }
        if(cont > len / 2)
            return curNum;
        return 0;
    }
}

// Method 3: 利用数组中元素超过一半的性质，如果arr[i]==curNum的话，curCont++, 否则 curCont--
// 如果curCont == 0, curNum = arr[i], 最后检测是否超过一半；
// Time O(n), Space O(1)