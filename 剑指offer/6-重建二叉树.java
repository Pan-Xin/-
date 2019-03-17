/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        int len = pre.length;
        if(len == 0)
            return null;
        
        TreeNode root = new TreeNode(pre[0]);
        int cont = 0;
        for(int i=0; i<len; i++){
            if(in[i] != pre[0])
                cont ++;
            else break;
        }
        
        int[] pre1 = new int[cont];
        int[] pre2 = new int[len - cont - 1];
        int[] in1 = new int[cont];
        int[] in2 = new int[len - cont - 1];
        
        for(int i=1; i<len; i++){
            if(i < cont + 1)
                pre1[i - 1] = pre[i];
            else
                pre2[i-(cont+1)] = pre[i];
        }
        
        for(int i=0; i<len; i++){
            if(i < cont)
                in1[i] = in[i];
            else if(i > cont)
                in2[i-(cont+1)] = in[i];
        }
        
        root.left = reConstructBinaryTree(pre1, in1);
        root.right = reConstructBinaryTree(pre2, in2);
        
        return root;
        
        
        
    }
}
// 前序遍历的第一个节点是root，根据这个然后找到左子树的前序，中序，右子树的前序和中序
// 递归实现就好