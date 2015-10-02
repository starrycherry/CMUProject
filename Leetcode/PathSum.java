package Leetcode;

public class PathSum {
	   boolean res=false;
	    public boolean hasPathSum(TreeNode root, int sum) {
	        if(root==null){
	            return false;
	        }
	        
	        hasPathSumHelper(root,sum,0);
	        return res;
	    }
	    private void hasPathSumHelper(TreeNode node, int target, int pathSum){
	        if(node==null){
	            return;
	        }
	        pathSum+=node.val;
	        
	        if(node.left==null&&node.right==null){
	            if(pathSum==target){
	                res=true;
	            }
	            return;
	        }
	        
	        hasPathSumHelper(node.left,target,pathSum);
	        hasPathSumHelper(node.right,target,pathSum);
	        
	    }
	    
	    public static void main(String[] args){
	    	PathSum p=new PathSum();
	    	TreeNode root=new TreeNode(1);
	    	root.left=new TreeNode(2);
	    	System.out.println(p.hasPathSum(root, 1));
	    }
}
