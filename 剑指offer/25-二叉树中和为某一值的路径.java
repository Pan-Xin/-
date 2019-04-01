import java.util.ArrayList;
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
        private ArrayList<Integer> curPath = new ArrayList<>();;
		private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	
	    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
	        if(root == null)
	            return res;
	        
	        dfs(root, target, res, curPath);
	        
	        return res;
	    }
	    
	    
	    public void dfs(TreeNode root, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> curPath){
	        if(root.left == null && root.right == null){ // leave node
	            if(target == root.val){ // 满足要求，加入结果
	                curPath.add(root.val);
	                res.add(new ArrayList<Integer>(curPath));
                    curPath.remove(curPath.size() - 1);
	            }
	            return ;
	        }
	        
	        target = target - root.val;
	        curPath.add(root.val);
	        if(root.left != null) 
	            dfs(root.left, target, res, curPath);
	        if(root.right != null)
	            dfs(root.right, target, res, curPath);
            curPath.remove(curPath.size() - 1);
	    }

}