package chapter2;

public class AddLinkedList {
	public ImplementLinkedList add(ImplementLinkedList list1,ImplementLinkedList list2){
		Node node1=list1.head;
		Node node2=list2.head;
		int carry=0;
		int result=0;
		ImplementLinkedList list3=new ImplementLinkedList();
		Node node3=null;
		
		while(node1!=null&&node2!=null){
			result=node1.data+node2.data+carry;
			carry=result/10;
			if(list3.head==null){
				list3.head=new Node(result%10,null);
				node3=list3.head;
			}else{
				node3.next=new Node(result%10,null);
				node3=node3.next;
			}
			node1=node1.next;
			node2=node2.next;
			
		}
		
		while(node1!=null){
			result=node1.data+0+carry;
			carry=result/10;
			node3.next=new Node(result%10,null);
			node1=node1.next;
			node3=node3.next;
		}
		
		while(node2!=null){
			result=node2.data+0+carry;
			carry=result/10;
			node3.next=new Node(result%10,null);
			node2=node2.next;
			node3=node3.next;
		}
		
		return list3;
	}
	
	public static void main(String[] arg){
		AddLinkedList a=new AddLinkedList();
		ImplementLinkedList list1=new ImplementLinkedList();
		ImplementLinkedList list2=new ImplementLinkedList();
		list1.head=new Node(7,new Node(1,new Node(6,null)));
		list2.head=new Node(5,new Node(9,new Node(2,null)));
		ImplementLinkedList list3=a.add(list1, list2);
		Node node=list3.head;
		while(node!=null){
			System.out.println(node.data);
			node=node.next;
		}
		
	}
}
