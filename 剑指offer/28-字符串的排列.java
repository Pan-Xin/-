import java.util.*;
public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        int len = str.length();
        if(len == 0)
            return res;
        char[] arr = str.toCharArray();
        getPermutation(arr, res, 0, len - 1);
        Collections.sort(res);
        return res;
    }
    
    public void getPermutation(char[] arr, ArrayList<String> res, int start, int end){
        if(end == start){
            StringBuilder sb = new StringBuilder();
            int len = arr.length;
            for(int i=0; i<len; i++){
                sb.append(arr[i]);
            }
            res.add(sb.toString());
            return;
        }
        for(int i=start; i<=end; i++){
            if(i != start && arr[start] == arr[i])
                continue;
            swap(arr, i, start);
            getPermutation(arr, res, start + 1, end);
            swap(arr, i, start);
        }
    }
    
    public void swap(char[] arr, int index1, int index2){
        char temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
