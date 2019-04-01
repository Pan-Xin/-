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
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2 == null || root1 == null)
            return false;
        
        if(sameSubtree(root1, root2)) return true;
        if(HasSubtree(root1.left, root2)) return true;
        if(HasSubtree(root1.right, root2)) return true;
        
        return false;
        
    }
    
    public boolean sameSubtree(TreeNode r1, TreeNode r2){
        if(r1.val != r2.val) // 根节点不等，return false
            return false;
        
        if(r2.left == null && r2.right == null) // r2 只是单独节点且根节点相等，return true
            return true;
        
        if(r2.left != null){ // 如果左子树存在，进行比较
            if(r1.left == null) return false;
            if(!sameSubtree(r1.left, r2.left))
                return false;
        }
        if(r2.right != null){ // 如果右子树存在，进行比较
            if(r1.right == null) return false;
            if(!sameSubtree(r1.right, r2.right))
                return false;
        }
       
        return true;
    }
}