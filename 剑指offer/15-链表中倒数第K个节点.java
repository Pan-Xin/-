/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k == 0) // 空链表 or k = 0 的情况
            return null;
        
        int cont = 1;
        ListNode p1 = head;
        ListNode p2 = head;
        
        while(p1.next != null){
            p1 = p1.next;
            cont ++;
            if(cont > k)
                p2 = p2.next;
        }
        if(k > cont) return null; // k 的值大于链表长度
        return p2;

    }
}

// 双指针，一个先走K-1步
// 需要考虑robust