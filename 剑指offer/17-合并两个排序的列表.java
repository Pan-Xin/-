/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        if(p1 == null) return p2;
        else if(p2 == null) return p1;
        
        ListNode p;
        if(p1.val < p2.val){
            p = p1;
            p1 = p1.next;
        }
        else{
            p = p2;
            p2 = p2.next;
        }
        
        ListNode res = p;
        
        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                p.next = p1;
                p1 = p1.next;
            }
            else{
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        
        while(p1 != null){
            p.next = p1;
            p1 = p1.next;
            p = p.next;
        }
        
        while(p2 != null){
            p.next = p2;
            p2 = p2.next;
            p = p.next;
        }
        
        return res;
        
    }
}

// Time O(n); Space O(1)