import java.util.*;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    private List<TreeNode> list = new ArrayList<>();
    
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null)
            return null;
        
        getList(pRootOfTree);
        int len = list.size();
        for(int i=0; i<len; i++){
            TreeNode cur = list.get(i);
            TreeNode prev = null;
            TreeNode next = null;
            if(i - 1 >= 0)
               prev = list.get(i - 1);
            if(i + 1 < len)
                next = list.get(i + 1);
            cur.left = prev;
            cur.right = next;
        }
        
        return list.get(0);
        
    }
    
    public void getList(TreeNode t){
        if(t.left != null)
            getList(t.left);
        list.add(t);
        if(t.right != null)
            getList(t.right);
    }
}

// Time O(n); Space O(n)

/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null)
            return null;
        TreeNode res = pRootOfTree;
        if(pRootOfTree.left != null){
            TreeNode left = Convert(pRootOfTree.left);
            TreeNode prev = getLastNode(left);
            pRootOfTree.left = prev;
            res = left;
            prev.right = pRootOfTree;
        }
        if(pRootOfTree.right != null){
            TreeNode right = Convert(pRootOfTree.right);
            pRootOfTree.right = right;
            right.left = pRootOfTree;  
        }
        return res;
    }
    
    public TreeNode getLastNode(TreeNode p){
        TreeNode res = p;
        while(res.right != null)
            res = res.right;
        return res;
    }
}

// Time O(logn) Spcae O(1)