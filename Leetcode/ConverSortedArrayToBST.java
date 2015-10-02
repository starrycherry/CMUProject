/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
package Leetcode;

public class ConverSortedArrayToBST {
	   public TreeNode sortedArrayToBST(int[] nums) {
	        if(nums.length==0){
	            return null;
	        }
	        return buildBST(nums,0,nums.length-1);
	    }
	    
	    private TreeNode buildBST(int[] nums,int l,int r){
	        if(l>r){
	            return null;
	        }
	        int m=(l+r)/2;
	        TreeNode node=new TreeNode(nums[m]);
	        node.left=buildBST(nums,l,m-1);
	        node.right=buildBST(nums,m+1,r);
	        return node;
	    }
}
