/**
 * Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 */
package Leetcode;

import java.util.LinkedList;

class TreeLinkNode{
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}
public class PopulatingNextRightPointers {
	   public void connect(TreeLinkNode root) {
	        if(root==null){
	            return;
	        }
	       
	        LinkedList<TreeLinkNode> q=new LinkedList<TreeLinkNode>();
	        LinkedList<TreeLinkNode> qChild=new LinkedList<TreeLinkNode>();
	        TreeLinkNode node=null;
	        q.add(root);
	        while(!q.isEmpty()){
	            node=q.poll();
	            qChild=new LinkedList<TreeLinkNode>();
	            while(node!=null){
	                qChild.add(node.left);
	                qChild.add(node.right);
	                node=node.next; 
	            }
	            q=new LinkedList<TreeLinkNode>();
	            q.addAll(qChild);
	            TreeLinkNode pre=null;
	            while(!qChild.isEmpty()){
	                TreeLinkNode temp=qChild.poll();
	                if(pre!=null){
	                    pre.next=temp;
	                    pre=pre.next;
	                }else{
	                    pre=temp;
	                }
	            }
	        }
	    }
	 
	   //The second time come up with this solution, which is much better and easy understanding. 
	   public void connect1(TreeLinkNode root) {
	        if(root==null){
	            return;
	        }
	        
	        LinkedList<TreeLinkNode> queue=new LinkedList<TreeLinkNode>();
	        queue.offer(root);
	        LinkedList<TreeLinkNode> nextQ=new LinkedList<TreeLinkNode>();
	        while(!queue.isEmpty()){
	            TreeLinkNode node=queue.poll();
	            if(queue.isEmpty()){
	                node.next=null;
	            }else{
	                node.next=queue.peek();
	            }
	            
	            if(node.left!=null) nextQ.offer(node.left);
	            if(node.right!=null) nextQ.offer(node.right);
	            if(queue.isEmpty()){
	                queue.addAll(nextQ);
	                nextQ=new LinkedList<TreeLinkNode>();
	            }
	        }
	    }
	 public static void main(String[] args){
		 PopulatingNextRightPointers p=new PopulatingNextRightPointers();
		 TreeLinkNode root=new TreeLinkNode(0);
		 root.left=new TreeLinkNode(1);
		 root.left.left=new TreeLinkNode(3);
		 root.left.right=new TreeLinkNode(4);
		 root.right=new TreeLinkNode(2);
		 root.right.left=new TreeLinkNode(5);
		 root.right.right=new TreeLinkNode(6);
		 p.connect(root);
	 }
}
