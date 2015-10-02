/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ¡Ü k ¡Ü BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 */
package Leetcode;

import java.util.Arrays;
import java.util.LinkedList;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class KthSmallestBST {
	    int count=0;
	    int result=0;
	    public int kthSmallest(TreeNode root, int k) {
	        kthSmallestHelper(root,k);
	        return result;
	      
	    }
	    
	    public void kthSmallestHelper(TreeNode root,int k){
	        if(root==null) return;
	        if(root.left!=null){
	            kthSmallestHelper(root.left,k);
	        }
	        
	        count++;
	        if(count==k){
	            result=root.val;
	            return;
	        }   
	        
	        if(root.right!=null){
	            kthSmallestHelper(root.right,k);
	        }
	    }
	    
}
