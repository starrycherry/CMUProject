package Chapter4;

class Node{
	int key;
	Node left,right;
	
	public Node(int key){
		this.key=key;
		left=right=null;
	}
}
public class BST {
	Node root=null;
	
	public boolean find(int key){
		if (root==null)
			return false;
		Node current = root;
		while(current!=null&&current.key!=key){
			if(key>current.key){
				current=current.right;
			}else {
				current=current.left;
			}
		}
		
		if(current==null){
			return false;
		}
		
		return true;
	}
	
	public void insert(int key){
		Node newNode=new Node(key);
		if(root==null){
			root=newNode;
		}
		
		Node current=root;
		Node parent=null;
		while(true){
			if(current.key==key){
				return;
			}
			parent=current;
			if(key<current.key){
				current=current.left;
				if(current==null){
					parent.left=newNode;
					return;
				}
			}
			
			if(key>current.key){
				current=current.right;
				if(current==null){
					parent.right=newNode;
					return;
				}
			}
		}		
	}
	
	public void delete(int key){
		Node parent=null;
		Node current=root;
		boolean isLeftChild=true;
		
		//case1:if the node is not in the tree;
		while(current!=null&&current.key!=key){
			if(key<current.key){
				current=current.left;
				isLeftChild=true;
			}
			if(key>current.key){
				current=current.right;
				isLeftChild=false;
			}
		}
		
		if(current==null){
			return;
		}
		
		//case2: The node is a leaf
		if(current.left==null&&current.right==null){
			if(isLeftChild){
				parent.left=null;
			}else{
				parent.right=null;
			}
		}
		
		//case3: A node with one child
		
		if(current.right==null){//no right child
			if(current==root){
				root=current.left;
			}
			if(isLeftChild){
				parent.left=current.left;
			}else{
				parent.right=current.left;
			}
		}else if(current.left==null){//no left child
			if(current==root){
				root=current.right;
			}
			if(isLeftChild){
				parent.left=current.right;
			}else{
				parent.right=current.right;
			}
		}
		
		//case4: A node with 2 children
		if(current.left!=null&&current.right!=null){
			Node node=getSuccessor(current);
			if(isLeftChild){
				parent.left=node;
				node.left=current.left;
				node.right=current.right;
			}else{
				parent.right=node;
				node.left=current.left;
				node.right=current.right;
			}
		}
		
	}

	//bascially the successor is the smallest Child in the right sub-tree of the node to be deleted. 
	public Node getSuccessor(Node node){
		Node successorParent=node; 
		Node successor= node; 
		Node current=node.right;
		
		while(current!=null){
			successorParent=current;
			successor=current.left;
			current=current.left;
		}
		
		if(successor!=node.right){
			successorParent.left=successor.left;
		}
		return successor;
	}
	
	public void traverse(){
		inOrderTraverseHelper(root);		
	}
	
	public void inOrderTraverseHelper(Node node){
		inOrderTraverseHelper(node.left);
		System.out.println(node.key);
		inOrderTraverseHelper(node.right);
	}
}
