import java.util.ArrayList;
import java.util.*;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int len1 = pushA.length;
        int len2 = popA.length;
        if(len1 != len2)
            return false;
        
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        while(i < len1 && j < len2){
            if(pushA[i] == popA[j]){
                i ++;
                j ++;
                while(!stack.empty()){
                    int temp = stack.peek();
                    if(temp == popA[j]){
                        stack.pop();
                        j ++;
                    }
                    else break;
                }
            }
            else{
                stack.push(pushA[i]);
                i ++;
            }
        }
        
        if(!stack.empty())
            return false;
        return true;
       
    }
}

// 需要一个stack做辅助