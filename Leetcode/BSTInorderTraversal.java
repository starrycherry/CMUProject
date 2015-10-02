/**
 * Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
 */
package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

public class BSTInorderTraversal {
	   public ArrayList<Integer> inorderTraversal(TreeNode root) {
	        ArrayList<Integer> list=new ArrayList<Integer>();
	        if(root==null){
	            return list;
	        }
	        
	        
	        traversal(root.left,list);
	        list.add(root.val);
	        traversal(root.right,list);
	        
	        return list;
	    }
	    
	    private void traversal(TreeNode node,ArrayList<Integer> list){
	        if(node==null){
	            return;
	        }
	        traversal(node.left,list);
	        list.add(node.val);
	        traversal(node.right,list);
	    }
	    
	    public LinkedList<Integer> inorderTraversal1(TreeNode root) {

	        LinkedList<Integer> result = new LinkedList<>();
	        LinkedList<TreeNode> stack = new LinkedList<>();
	        TreeNode node = root;

	        while (node != null || !stack.isEmpty()) {
	            while (node != null) {
	                stack.addLast(node);
	                node = node.left;
	            }

	            if (!stack.isEmpty()) {
	                node = stack.removeLast();
	                result.add(node.val);
	                node = node.right;
	            }
	        }

	        System.out.println(result);
	        return result;
	    }
	    
	    public static void main(String[] args){
	    	BSTInorderTraversal b=new BSTInorderTraversal();
	    	TreeNode root=new TreeNode(1);
	    	root.left=new TreeNode(2);
	    	root.right=new TreeNode(3);
	    	root.left.left=new TreeNode(4);
	    	root.left.right=new TreeNode(5);
	    	root.left.left.right=new TreeNode(8);
	    	root.right.left=new TreeNode(6);
	    	b.inorderTraversal1(root);
	    }
}
