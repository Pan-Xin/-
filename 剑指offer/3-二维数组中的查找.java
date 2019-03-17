public class Solution {
    public boolean Find(int target, int [][] array) {
        int rowNum = array.length;
        if(rowNum == 0)
            return false;
        
        int colNum = array[0].length;
        
        int col = colNum - 1;
        int row = 0;
       
        while(col >= 0 && row < rowNum){
            int cur = array[row][col];
            if(cur == target)
                return true;
            else if(cur > target){
                col --;
            }
            else{
                row ++;
            }
        }
        
        return false;
    }
}

// Time: O(n)
// Space: O(1)