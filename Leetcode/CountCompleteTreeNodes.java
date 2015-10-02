/**
 * Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. 
It can have between 1 and 2h nodes inclusive at the last level h.
�ñ�����, recursive��ᳬʱ O(N).   �����ĳ�ڵ�һֱ����ĸ߶� = һֱ���ҵĸ߶�, ��ô�Ըýڵ�Ϊroot������һ������������. �����������Ľڵ���,�����ù�ʽ��� 2^h - 1.
 ����߶Ȳ����, ��ݹ���� return countNode(left) + countNode(right) + 1.  ���Ӷ�ΪO(h^2) 
 */


package Leetcode;

public class CountCompleteTreeNodes {
	 public int countNodes(TreeNode root) {
	        if(root==null){
	            return 0;
	        }
	        
	        int l=countLeft(root)+1;
	        int r=countRight(root)+1;
	        int res=0;
	        if(l==r){
	            res=(2<<(l-1))-1;
	        }else{
	            res=countNodes(root.left)+countNodes(root.right)+1;
	        }
	        return res;
	       
	    }
	    
	    private int countLeft(TreeNode node){
	        int count=0;
	        while(node.left!=null){
	            count++;
	            node=node.left;
	        }
	        return count;
	    }
	    
	    private int countRight(TreeNode node){
	        int count=0;
	        while(node.right!=null){
	            count++;
	            node=node.right;
	        }
	        return count;
	    }
}
