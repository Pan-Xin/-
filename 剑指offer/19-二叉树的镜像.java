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
    public void Mirror(TreeNode root) {
        if(root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(left == null && right == null)
            return;
        root.left = right;
        root.right = left;
        if(right != null) Mirror(root.left);
        if(left != null) Mirror(root.right);
    }
}
