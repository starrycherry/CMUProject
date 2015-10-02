package chapter2;

public class kthToLast {
	
	public Node findK(int k,ImplementLinkedList list){
		Node node1=list.head;
		Node node2=list.head;
		
		for(int i=0;i<k-1;i++){
			if(node2==null) return null;
			node2=node2.next;
		}
		
		if(node2==null) return null;
		node1=list.head;
		
		while(node2!=null){
			node2=node2.next;
			node1=node1.next;
		}
		
		return node1;
	}

}
