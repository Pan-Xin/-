// Sol 1: 将stack1的内容都放入stack2，pop后再放回stack1
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
        int res = stack2.pop();
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return res;
    }
}


// Sol 2: 更加简洁，stack2的栈顶元素一定是最先进入的元素
// 所以stack2不为empty的时候直接pop stack2的peek
// 如果stack2为空的话，这时候才将stack1的内容导入stack2再pop
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        if(!stack2.empty())
            return stack2.pop();
        else{
            while(!stack1.empty())
                stack2.push(stack1.pop());
            return stack2.pop();
        }
    }
}


// 相似：用两个queue实现stack
public class MyStack {
    
    private Queue<Integer> q1 = new LinkedList<Integer>();
    private Queue<Integer> q2 = new LinkedList<Integer>();
    
    public void add(Integer num) {
        q1.offer(num);
    }
    
    public Integer remove() {
        Integer temp = null;
        if(!q1.isEmpty()) {
            while(!q1.isEmpty()) {
                temp = q1.poll();
                if(q1.isEmpty())
                    return temp;
                else q2.offer(temp);
            }
        }
        else {
            while(!q2.isEmpty()) {
                temp = q2.poll();
                if(q2.isEmpty())
                    return temp;
                else q1.offer(temp);
            }
        }
        return temp;
    }
    

}
