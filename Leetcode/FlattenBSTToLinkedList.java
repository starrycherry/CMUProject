package Leetcode;
/**
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 * @author Cherrie
 *
 */
public class FlattenBSTToLinkedList {
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        
        flattenHelper(root);
    }
    
    private TreeNode flattenHelper(TreeNode node){
        if(node.left==null&&node.right==null){
            return node;
        }
        TreeNode lend=node;
        
        if(node.left!=null){
            lend=flattenHelper(node.left);
        }  
        TreeNode rend=lend;
        if(node.right!=null){
            rend=flattenHelper(node.right);
        }
        TreeNode right=node.right;
        node.right=node.left;
        node.left=null;
      
        
        
        lend.right=right;
        return rend;
    }
}
