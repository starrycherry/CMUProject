package chapter2;

public class Partition {
	
	public ImplementLinkedList partitionNode(int x,ImplementLinkedList list){
		Node node=list.head;
		ImplementLinkedList biggerList=new ImplementLinkedList();
		ImplementLinkedList lessList=new ImplementLinkedList();
		Node node1=biggerList.head;
		Node node2=lessList.head;
		
		if(list.head==null) return null;
		
		while(node!=null){
			if(node.data<x){
				node2=new Node(node.data,null);
				node2=node2.next;
			}else{
				node1=new Node(node.data,null);
				node1=node1.next;
			}
			node=node.next;
		}
		
		node2=biggerList.head;
		return lessList;
	}

}
