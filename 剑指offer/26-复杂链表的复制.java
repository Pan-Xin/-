/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead == null)
            return null;
        
        // copy
        RandomListNode temp = pHead;
        RandomListNode p = new RandomListNode(temp.label);
        RandomListNode res = p;
        temp = temp.next;
        while(temp != null){
            RandomListNode next = new RandomListNode(temp.label);
            p.next = next;
            p = p.next;
            temp = temp.next;
        }
        
        // set the random
        temp = pHead;
        p = res;
        while(temp != null){
            RandomListNode r = temp.random;
            int cont = 0;
            RandomListNode t = pHead;
            while(t != null){
                if(t.equals(r))
                    break;
                t = t.next;
                cont ++;
            }
            t = res;
            while(cont > 0){
                t = t.next;
                cont --;
            }
            p.random = t;
            p = p.next;
            temp = temp.next;
        }
        
        return res;
    }
}

// Time O(n ^ 2)，暴力求解

/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/

public class Solution {
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead == null)
            return null;
        
        RandomListNode temp = pHead;
        while(temp != null){
            RandomListNode p = new RandomListNode(temp.label);
            p.next = temp.next;
            temp.next = p;
            temp = p.next;
        }
        
        RandomListNode res = pHead.next;
        
        temp = pHead;
        while(temp != null){
            RandomListNode p = temp.next;
            RandomListNode r = temp.random;
            if(r != null)
                p.random = r.next;
            else
                p.random = null;
            temp = p.next;
        }
        
        temp = pHead;
        while(temp != null){
            RandomListNode p = temp.next;
            temp = p.next;
            if(temp == null)
                p.next = null;
            else
                p.next = temp.next;
        }
        
        if(pHead.next != null)
            pHead.next = pHead.next.next;
        
        return res;
    }

}

// 将新new的节点插入原先的节点之中
// Time O(n)
// 不清楚为什么过不了牛客上的case，说输入有问题，再看吧

