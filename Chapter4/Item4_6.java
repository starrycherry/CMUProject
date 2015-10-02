/**
 * Write an algorithm to find the 'next' node (ie in-order successor) of a given node in a binary search tree. You may assume that each node has a link to its parent. 
 * if(node has right child)
 * return the leftmost Node;
 * else when node is at the left side or has no right child
 * go up and find the first node where the node is at the left side of the node. 
 */


package Chapter4;
class RNode{
	RNode parent=null;
	RNode left=null;
	RNode right=null;
	int value=0;
}
public class Item4_6 {
	public RNode findNext(RNode node){
		if(node==null) return null;
		if(node.right!=null){
			return findLeftMost(node.right);
		}else{
			RNode x=node;
			x=x.parent;
			while(x!=null&&x.left!=node){
				node=x;
				x=x.parent;
			}
			return x;
		}
	}
	
	public RNode findLeftMost(RNode node){
		if (node==null) return null;
		while(node.left!=null){
			node=node.left;
		}
		return node;
	}

}
