/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: ¡°The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).¡±

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 */

package Leetcode;
class Result1 {
    TreeNode node;
    boolean isRoot;
    public Result1(TreeNode node, boolean isRoot){
        this.node=node;
        this.isRoot=isRoot;
    }
}
public class LowestCommonAncestorOfABinaryTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Result1 r=lowestCommonAncestorHelper(root,p,q);
        if(r.isRoot){
            return r.node;
        }
        return null;
    }
    
    private Result1 lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return new Result1(null, false);
        }
        
        if(root.equals(p)&&root.equals(q)){
            return new Result1(root, true);
        }
        
        Result1 l=lowestCommonAncestorHelper(root.left,p,q);
        if(l.isRoot&&l.node!=null){
            return l;
        }
        
        Result1 r=lowestCommonAncestorHelper(root.right,p,q);
        if(r.isRoot&&r.node!=null){
            return r;
        }
        
        if(l.node!=null&&r.node!=null){
            return new Result1(root,true);
        }else if(root.equals(p)||root.equals(q)){
            boolean isAsc=l.node!=null||r.node!=null;
            return new Result1(root,isAsc);
        }else{
            return new Result1(l.node!=null?l.node:r.node,false);
        }
    }
}
