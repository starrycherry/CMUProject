package Chapter4;

import java.util.ArrayList;
import java.util.LinkedList;

public class Item4_4 {
	public ArrayList<LinkedList<Node>> createLevelLinkedList(Node root){
		ArrayList<LinkedList<Node>> result=new ArrayList<LinkedList<Node>>();
		if (root==null) return null;
		LinkedList<Node> current=new LinkedList<Node>();
		current.add(root);
		
		while(current.size()>0){
			result.add(current);
			LinkedList<Node> parent=current;
			
			for(Node n:parent){
				current.add(n.left);
				current.add(n.right);
			}
		}
		return result;
	}
}
