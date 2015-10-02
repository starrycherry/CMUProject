package chapter2;

import java.util.Stack;

public class Palindrome {
	public boolean isPalindrome(ImplementLinkedList list){
		Node fast=list.head;
		Node slow=list.head;
		Stack<Integer> s=new Stack<Integer>();
		Node node=list.head;

		while(fast!=null&&fast.next!=null){
			fast=fast.next.next;
			slow=slow.next;
		}

		while(slow!=null){
			if(fast!=null){
				slow=slow.next;
				fast=null;
			}
			s.push(slow.data);
			slow=slow.next;
		}
		
		while(!s.isEmpty()){
			if(!s.pop().equals(node.data)){
				return false; 
			}
			node=node.next;
		}
		return true;
	}
	
	public static void main(String[] args){
		Palindrome p=new Palindrome();
		ImplementLinkedList list=new ImplementLinkedList();
		list.head=new Node(0,new Node(1,new Node(2,new Node(1,new Node(0,null)))));
		System.out.println(p.isPalindrome(list));
	}

}
