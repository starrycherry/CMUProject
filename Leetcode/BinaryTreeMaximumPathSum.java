/**
 * Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.

������˼·���ǣ��ڵݹ��м��������root�����ֵ��������max[0]��Java�޷������ô�����ֻ�ܽ���һ������or something����

������root�����ֵ�����¼��ֿ��ܣ�1.root����2.root����������һ��·����3.root����������һ��·����4.������һ��·����root��������һ��·��������ȡ���Ϳɸ�����max[0]

����1��2��3������������һ����root�����ֵ������Ҫ����ȥ��

���գ��������ϲ��root��˵�����ڵ����·����һ��Ҫ��������������ÿ���ڵ㶼�������������ֵ�Ѿ�����max[0]�����ˡ�
 */
package Leetcode;

public class BinaryTreeMaximumPathSum {
	  public int maxPathSum(TreeNode root) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int max[] = new int[1]; // this is used to keep max val
	        max[0] = Integer.MIN_VALUE;
	        localSum(root, max);
	        return max[0];      
	    }
	     
	    public int localSum(TreeNode root, int[] max) {
	        if (root == null) return 0;
	        int lsum = localSum(root.left, max);
	        int rsum = localSum(root.right, max);
	        int csum = Math.max(root.val, Math.max(root.val + lsum, root.val + rsum));
	         
	        max[0] = Math.max(max[0], Math.max(csum, lsum + root.val + rsum));
	        return csum;
	    }
	    
	    public static void main(String[] args){
	    	
	    }
}
