/**
 * Design an algorithm and write code to find the fist common ancestor of two nodes in a binary tree. Avoid storing additional nodes in a data structure. Node: this is not necessarily a binary search tree.
 */
package Chapter4;

class Result{
	Node node;
	boolean isAsc;
	
	public Result(Node n, boolean isAsc){
		this.node=n;
		this.isAsc=isAsc;
	}
}

public class Item4_7 {
	public Node findCommonNodes(Node root, Node p, Node q){
		Result r=findCommonNodesHelper(root,p,q);
		if(r==null) return null;
		return r.node;
	}
	
	public Result findCommonNodesHelper(Node root,Node p,Node q){
		if (root==null)
			return new Result(null,false);
		
		if(root.equals(q)&&root.equals(p))
			return new Result(root,true);
		
		Result la=findCommonNodesHelper(root.left,p,q);
		if(la.isAsc)
			return la;
		
		Result ra=findCommonNodesHelper(root.right,p,q);
		if(ra.isAsc)
			return ra;
		
		if(ra.node!=null&&la.node!=null)
			return new Result(root,true);
		else if(root.equals(p)||root.equals(q)){
			boolean isAsc=la.node!=null||ra.node!=null;
			return new Result(root,isAsc);
			}else
				return new Result(la.node!=null?la.node:ra.node,false);
		}
	}

