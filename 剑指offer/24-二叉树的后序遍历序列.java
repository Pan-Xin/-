public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        int len = sequence.length;
        if(len == 0)
            return false;
        
        return isValid(sequence, 0, len - 1);
        
    }
    
    public boolean isValid(int[] arr, int start, int end){
        if(start == end)
            return true;
        
        int mid = arr[end];
        
        int right = start;
        int left = end - 1;
        boolean flg = false;
        for(int i=start; i<end; i++){
            if(!flg && arr[i] > mid){
                right = i;
                if(i != start) left = i - 1;
                flg = true;
            }
            else if(flg && arr[i] <= mid)
                return false;
        }
        
        if(!isValid(arr, start, left))
            return false;
        if(!isValid(arr, right, end - 1))
            return false;
        
        return true;
        
    }
}