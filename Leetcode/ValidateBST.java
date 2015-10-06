/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.


OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:
   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
 */
package Leetcode;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        
        if(root.left==null&&root.right==null){
            return true;
        }
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, long min, long max){
         if(root==null){
            return true;
        }
        if(root.left==null&&root.right==null&&withinRange(root.val,min,max)){
          return true;
        }
        if(root.left==null&&root.right!=null&&root.val<root.right.val&&isValidBST(root.right,root.val,max)){
            return true;
        }
        if(root.left!=null&&root.val>root.left.val&&isValidBST(root.left,min,root.val)&&root.right==null){
            return true;
        }
        if(root.left!=null&&root.val>root.left.val&&root.right!=null&&root.val<root.right.val&&isValidBST(root.left,min,root.val)&&isValidBST(root.right,root.val,max)){
            return true;
        }
        return false;
    }
    
    private boolean withinRange(int val,long min, long max){
        if(val<max&&val>min){
            return true;
        }else{
            return false;
        }
        
    }
    
    /**
     * ------------------------------------------The second time get the best method---------------------------------------------------------------------------------------------------------
     * @param args
     */
    
    public boolean isValidBST1(TreeNode root) {
        if(root==null){
            return true;
        }
        
        return isValidBSTHelper(Long.MIN_VALUE,Long.MAX_VALUE,root);
        
    }
    
    private boolean isValidBSTHelper(long min,long max,TreeNode node){
        if(node.val<=min||node.val>=max){
            return false;
        }
        boolean vleft=true;
        boolean vright=true;
        if(node.left!=null){
            vleft=isValidBSTHelper(min,node.val,node.left);
        }
        
        if(node.right!=null){
            vright=isValidBSTHelper(node.val,max,node.right);
        }
        
        return vleft&&vright;
    }
	 
	 public static void main(String[] args){
		 ValidateBST v=new ValidateBST();
		 TreeNode root=new TreeNode(0);
		 root.left=new TreeNode(-1);
		/* root.right=new TreeNode(15);
		 root.right.left=new TreeNode(6);
		 root.right.right=new TreeNode(20);*/
		 System.out.println(v.isValidBST(root));
	 }
}
