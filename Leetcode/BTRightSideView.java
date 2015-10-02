/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
 */
package Leetcode;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BTRightSideView {
	 public ArrayList<Integer> rightSideView(TreeNode root) {
	        ArrayList<Integer> list=new ArrayList<Integer>();
	        if(root==null){
	            return list;
	        }
	        
	        Queue<TreeNode> q=new LinkedList<TreeNode>();
	        Stack<TreeNode> childS=new Stack<TreeNode>();
	        q.offer(root);
	        list.add(root.val);
	        while(!q.isEmpty()){
	            TreeNode node=q.poll();
	            if(node!=null){
	                if(node.left!=null)
	                    childS.push(node.left);
	                if(node.right!=null)
	                    childS.push(node.right);
	            }
	            
	            if(q.isEmpty()){
	                q.addAll(childS);
	                if(!childS.isEmpty())
	                    list.add(childS.pop().val);
	                childS=new Stack<TreeNode>();
	            }
	        }
	        return list;
	    }
}
