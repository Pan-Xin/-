public class Solution {
    public void swap(int[] array, int i1, int i2){
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }
    
    public void reOrderArray(int [] array) {
        int len = array.length;
        
        for(int i=0; i<len; i++){
            if(array[i] % 2 == 0){
                int j = i + 1;
                boolean isFind = false;
                while(j < len){
                    if(array[j] % 2 != 0){
                        isFind = true;
                        break;
                    }
                    else j ++;
                }
                if(isFind){
                    int temp = array[j];
                    for(int t = j; t > i; t--){
                        array[t] = array[t - 1];
                    }
                    array[i] = temp;
                 }
            }
        }
    }
}

// Time: O(n2)

// 可以使用空间换时间则能达到 O(n) O(n)

// 如果不需要保证相对性的话，则可以使用双指针，就是O(n)时间复杂度