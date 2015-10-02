package chapter2;

class Node{
	Node next;
	int data;
	
	public Node(int data,Node next){
		this.next=next;
		this.data=data;
	}
}
public class ImplementLinkedList {
	Node head;
	public ImplementLinkedList(){
		head=null;
	}
	
	public void addFirst(int data){
		head=new Node(data,head);
	}
	
	public void traverse(){
		Node tmp=head;
		while(tmp.next !=null){
			tmp=tmp.next;
		}
	}
	
	public void addLast(int data){
		if(head==null){
			head=new Node(data,head);
			return;
		}
		
		Node tmp =head;
		while(tmp.next!=null){
			tmp=tmp.next;
		}
		tmp.next=new Node(data,null);
	}
	
	public void insertAfter(int key,int data){
		if(head==null) return;
		
		Node tmp=head;
		while(tmp!=null&&tmp.data!=key){
			tmp=tmp.next;
		}
		if(tmp==null) return;
		tmp.next=new Node(data,tmp.next);
	}
	
	public void insertBefore(int key,int data){
		if(head==null) return;
		if(head.data==data){
			head=new Node(data,head);
			return;
		}
		
		Node pre=null;
		Node cur=head;
		while(cur!=null&&cur.data!=key){
			pre=cur;
			cur=cur.next;
		}
		if(cur==null) return;
		
		pre.next=new Node(data,pre.next);
	}
	
	public void remove(int data){
		if(head==null) return;
		if(head.data==data){
			head=head.next;
		}
		
		Node pre=null;
		Node cur=head;
		while(cur!=null&&cur.data!=data){
			pre=cur;
			cur=cur.next;
		}
		if(cur==null) return;
		pre.next=cur.next;
	}
}
          