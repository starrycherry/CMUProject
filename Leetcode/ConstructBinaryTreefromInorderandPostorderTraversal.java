/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

重要的是通过长度来寻找index;
 */
package Leetcode;

import java.util.ArrayList;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0&&postorder.length==0){
            return null;
        }
        ArrayList<Integer> inlist=new ArrayList<Integer>();
	    ArrayList<Integer> postlist=new ArrayList<Integer>();
	    for(int i=0;i<inorder.length;i++){
	            inlist.add(inorder[i]);
	            postlist.add(postorder[i]);
	        }
        return buildTreeHelper(inlist,postlist,0,inorder.length-1,0,postorder.length-1);
    }
    
    private TreeNode buildTreeHelper(ArrayList<Integer> inorder,ArrayList<Integer> postorder, int pl,int pr,int il,int ir){
        if(pl>pr||il>ir){
            return null;
        }
        
        TreeNode node=new TreeNode(postorder.get(pr));
        int im=inorder.indexOf(node.val);
        
        int j=pl+(im-il);
     
        node.left=buildTreeHelper(inorder,postorder,pl,j-1,il,im-1);
        node.right=buildTreeHelper(inorder,postorder,j,pr-1,im+1,ir);
        
        return node;
    }
}
