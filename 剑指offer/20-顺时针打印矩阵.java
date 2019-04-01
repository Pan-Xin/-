import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int rowNum = matrix.length;
        if(rowNum == 0)
            return res;
        int colNum = matrix[0].length;
        if(colNum == 0)
            return res;
        printInCircle(matrix, 0, 0, rowNum - 1, colNum - 1, res);
        return res;
    }
    
    public void printInCircle(int[][] matrix, int x1, int y1, int x2, int y2, ArrayList<Integer> res){
        if(x1 > x2 || y1 > y2)
            return;
        
        // right
        for(int col = y1; col <= y2; col ++)
            res.add(matrix[x1][col]);
        
        // down
        for(int row = x1 + 1; row <= x2; row ++)
            res.add(matrix[row][y2]);
        
        // 对于只有一行或者一列的情况要处理，不然会造成重复
        // left
        if(x1 != x2){ 
            for(int col = y2 - 1; col >= y1; col --)
                res.add(matrix[x2][col]);
        }
        
        // up
        if(y1 != y2){
             for(int row = x2 - 1; row > x1; row --)
                res.add(matrix[row][y1]);
        }
        
        x1 ++;
        y1 ++;
        x2 --;
        y2 --;
        
       printInCircle(matrix, x1, y1, x2, y2, res);
    }
}
