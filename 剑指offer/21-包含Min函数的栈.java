import java.util.Stack;

public class Solution {
    
    private Stack<Integer> data = new Stack<>();
    
    private Stack<Integer> aux = new Stack<>();
    
    private int curMin = Integer.MAX_VALUE;
    
    public void push(int node) {
        data.push(node);
        if(node < curMin)
            curMin = node;
        aux.push(curMin);
    }
    
    public void pop() {
        data.pop();
        aux.pop();
        curMin = aux.peek();
    }
    
    public int top() {
        return data.peek();
    }
    
    public int min() {
        return aux.peek();
    }
}

// 思路：用两个栈，一个数据栈，一个辅助栈;
// 每次push的时候都是push curMin; 因为对于大的数来说，它不可能成为min；
// 每次pop的时候，两个栈同时pop，同时更新curMin