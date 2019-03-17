// Sol 1: 添加到list中再反转list
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(listNode == null)
            return list;
        
        ListNode p = listNode;
        int cont = 0;
        while(p != null){
            list.add(p.val);
            cont ++;
            p = p.next;
        }
        
        int i = 0;
        int j = cont - 1;
        while(i < j){
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
            i ++;
            j --;
        }
        
        return list;
        
    }
}
// Time: O(n)

// Sol 2: 用递归实现 / 同样递归可以改为显示地用stack实现
public class Solution {
    
    public void addFunc(ListNode head, ArrayList<Integer> list){
        if(head == null)
            return;
        addFunc(head.next, list);
        list.add(head.val);
    }
    
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        // 用递归实现
        ArrayList<Integer> list = new ArrayList<>();
        
        addFunc(listNode, list);
        
        return list;
        
    }
}