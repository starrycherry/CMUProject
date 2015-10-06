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
	        Queue<TreeNode> cq=new LinkedList<TreeNode>();
	        q.offer(root);
	        while(!q.isEmpty()){
	            TreeNode node=q.poll();
	            if(node.left!=null){
	                cq.offer(node.left);
	            }
	            if(node.right!=null){
	                cq.offer(node.right);
	            }
	            if(q.isEmpty()){
	                if(!list.contains(node.val)){
	                    list.add(node.val);
	                }
	               
	                q.addAll(cq);
	                cq=new LinkedList<TreeNode>();
	            }
	        }
	        return list;
	    }
}
