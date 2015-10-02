/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
package Leetcode;

import java.util.ArrayList;

public class UniqueBST2 {
	public ArrayList<TreeNode> generateTrees(int n) {
	    return helper(1,n);
	}
	private ArrayList<TreeNode> helper(int left, int right)
	{
	    ArrayList<TreeNode> res = new ArrayList<TreeNode>();
	    if(left>right)
	    {
	        res.add(null);
	        return res;
	    }
	    for(int i=left;i<=right;i++)
	    {
	        ArrayList<TreeNode> leftList = helper(left,i-1);
	        ArrayList<TreeNode> rightList = helper(i+1,right);
	        for(int j=0;j<leftList.size();j++)
	        {
	            for(int k=0;k<rightList.size();k++)
	            {
	                TreeNode root = new TreeNode(i);
	                root.left = leftList.get(j);
	                root.right = rightList.get(k);
	                res.add(root);
	            }
	        }
	    }
	    return res;
	}
	
	public static void main(String[] args){
		UniqueBST2 u=new UniqueBST2();
		u.generateTrees(3);
	}
}
