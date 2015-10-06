/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
 */
package Leetcode;

import java.util.LinkedList;
import java.util.Stack;

public class BSTIterator {
	  Stack<TreeNode> s;
	    public BSTIterator(TreeNode root) {
	        s=new Stack<TreeNode>();
	        pushLeft(root);
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        if(!s.isEmpty()){
	            return true;
	        }
	        return false;
	    }

	    /** @return the next smallest number */
	    public int next() {
	        int val=-1;
	        TreeNode node;
	       if(!s.isEmpty()){
	           node=s.pop();
	           val=node.val;
	           pushLeft(node.right);
	       }
	       return val;
	    }
	    
	  private void pushLeft(TreeNode node){
	      while(node!=null){
	         s.push(node);
	         node=node.left;
	      }
	  }
	
	public static void main(String[] args){
		TreeNode node=new TreeNode(1);
		node.right=new TreeNode(2);
		BSTIterator b=new BSTIterator(node);
		System.out.println(b.next());
	}
}
