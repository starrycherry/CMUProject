/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
 */
package Leetcode;

import java.util.ArrayList;

public class ConstructBT {
	//time limit exceeds
	  public TreeNode buildTree(int[] preorder, int[] inorder) {
	        if(preorder.length==0||inorder.length==0){
	            return null;
	        }
	        ArrayList<Integer> inlist=new ArrayList<Integer>();
	        ArrayList<Integer> prelist=new ArrayList<Integer>();
	        for(int i=0;i<inorder.length;i++){
	            inlist.add(inorder[i]);
	            prelist.add(preorder[i]);
	        }
	        TreeNode root=new TreeNode(preorder[0]);
	        int nodeindex=inlist.indexOf(root.val);
	        root.left=buildTreeHelper(prelist,inlist,0,nodeindex-1,0);
	        nodeindex=inlist.indexOf(root.val);
	      /*  int pindex=root.left==null?0:prelist.indexOf(root.left.val);
	        while(pindex+1<prelist.size()&&inlist.indexOf(prelist.get(pindex+1))<=nodeindex){
	            pindex++;
	        }*/
	        root.right=buildTreeHelper(prelist,inlist,nodeindex+1,inorder.length-1,nodeindex);
	        
	        return root;
	    }
	    private TreeNode buildTreeHelper(ArrayList<Integer> prelist,ArrayList<Integer> inlist,int lindex,int rindex,int pindex){
	        TreeNode node=null;
	        pindex++;
	        if(lindex>rindex){
	            return null;
	        }
	        if(lindex==rindex&&pindex<prelist.size()&&prelist.get(pindex)==inlist.get(lindex)){
	            node=new TreeNode(inlist.get(lindex));
	            return node;
	        }
	        if(lindex<rindex&&lindex>=0){
	            int nodeindex=inlist.indexOf(prelist.get(pindex));
	            if(nodeindex<=rindex&&nodeindex>=lindex&&nodeindex!=-1){
	                node=new TreeNode(prelist.get(pindex));
	                node.left=buildTreeHelper(prelist,inlist,lindex,nodeindex-1,pindex);
	                //nodeindex=node.left==null?nodeindex:inlist.indexOf(node.left.val);
	               /* pindex=node.left==null?pindex:prelist.indexOf(node.left.val);
	                while(pindex+1<prelist.size()&&inlist.indexOf(prelist.get(pindex+1))<=nodeindex){
	                    pindex++;
	                }*/
	                int length=nodeindex-lindex;
	                node.right=buildTreeHelper(prelist,inlist,nodeindex+1,rindex,pindex+length);
	                return node;
	            }
	        }
	        return null;
	    }
	    
	    //Accepted
	    public TreeNode buildTree1(int[] preorder, int[] inorder) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(preorder.length==0||inorder.length==0){
	            return null;
	        }
	        return build(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
	        
	    }
	    public TreeNode build(int[] preorder,int[] inorder,int preBeg,int preEnd,int inBeg,int inEnd){
	        if(preBeg>preEnd||inBeg>inEnd){
	            return null;
	        }
	        TreeNode node=new TreeNode(preorder[preBeg]);
	        int i=inBeg;
	        for(;i<=inEnd;i++){
	            if(node.val==inorder[i]){
	                break;
	            }
	        }
	        int length=i-inBeg;
	        node.left=build(preorder,inorder,preBeg+1,preBeg+length,inBeg,i-1);
	        node.right=build(preorder,inorder,preBeg+length+1,preEnd,i+1,inEnd);
	        return node;
	    }
	    public static void main(String[] args){
	    	ConstructBT c=new ConstructBT();
	    	int[] preorder={3,2,1,4};
	    	int[] inorder={1,2,3,4};
	    	c.buildTree(preorder, inorder);
	    }
}
