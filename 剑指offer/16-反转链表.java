/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = cur.next;
        
        while(cur != null){
            cur.next = prev;
            prev = cur;
            cur = next;
            if(cur != null)
                next = cur.next;
        }
        
        return prev;
    }
}

// Time: O(n)  Space: O(1)