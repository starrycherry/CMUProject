package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 * @author Cherrie
 *
 */
public class BSTLevelOrderTraversal {
	 public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
	        ArrayList<ArrayList<Integer>> lists=new ArrayList<ArrayList<Integer>>();
	        if(root==null){
	            return lists;
	        }
	        
	        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
	        ArrayList<Integer> item=new ArrayList<Integer>();
	        LinkedList<TreeNode> nextQ=new LinkedList<TreeNode>();
	        queue.add(root);
	        while(!queue.isEmpty()){
	            TreeNode node=queue.pop();
	            item.add(node.val);
	            if(queue.isEmpty()){
	                lists.add(item);
	                item=new ArrayList<Integer>();
	            }
	            if(node.left!=null){
	                nextQ.add(node.left);
	            }
	            if(node.right!=null){
	                nextQ.add(node.right);
	            }
	            if(queue.isEmpty()){
	                queue.addAll(nextQ);
	                nextQ=new LinkedList<TreeNode>();
	            }
	        }
	        return lists;
	    }
	 
	 public static void main(String[] args){
		 BSTLevelOrderTraversal b=new BSTLevelOrderTraversal();
		 TreeNode root=new TreeNode(1);
		 root.left=new TreeNode(2);
		 root.right=new TreeNode(3);
		 b.levelOrder(root);
	 }
}
