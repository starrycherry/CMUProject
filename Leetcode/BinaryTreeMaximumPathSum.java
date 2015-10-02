/**
 * Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.

基本的思路就是，在递归中计算包含该root的最大值并更新至max[0]（Java无法按引用传，就只能建立一个数组or something）。

包含该root的最大值有如下几种可能：1.root本身；2.root和左子树中一条路径；3.root和右子树中一条路径；4.左子树一条路径和root和右子树一条路径。其中取最大就可更新至max[0]

其中1，2，3可用来计算上一级的root的最大值，所以要传回去。

最终，对于最上层的root来说，数内的最大路径不一定要经过根，但由于每个节点都遍历到，其最大值已经存在max[0]里面了。
 */
package Leetcode;

public class BinaryTreeMaximumPathSum {
	  public int maxPathSum(TreeNode root) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int max[] = new int[1]; // this is used to keep max val
	        max[0] = Integer.MIN_VALUE;
	        localSum(root, max);
	        return max[0];      
	    }
	     
	    public int localSum(TreeNode root, int[] max) {
	        if (root == null) return 0;
	        int lsum = localSum(root.left, max);
	        int rsum = localSum(root.right, max);
	        int csum = Math.max(root.val, Math.max(root.val + lsum, root.val + rsum));
	         
	        max[0] = Math.max(max[0], Math.max(csum, lsum + root.val + rsum));
	        return csum;
	    }
	    
	    public static void main(String[] args){
	    	
	    }
}
