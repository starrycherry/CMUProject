/**
 * Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
package Leetcode;

public class MaximumDepthOfBT {
	 int maxDepth=0;
	    public int maxDepth(TreeNode root) {
	        if(root==null){
	            return 0;
	        }
	        int depth=0;
	        maxDepthHelper(root,depth);
	        return maxDepth;
	    }
	    private void maxDepthHelper(TreeNode node, int depth){
	        if(node==null){
	            maxDepth=Math.max(maxDepth,depth);
	            return;
	        }
	        depth++;
	        maxDepthHelper(node.left,depth);
	        maxDepthHelper(node.right,depth);
	    }
}
