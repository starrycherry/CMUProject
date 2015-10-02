package chapter2;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

public class removeDup {
	public void remove(ImplementLinkedList list){
		Hashtable<Integer,Boolean> table=new Hashtable<Integer,Boolean>();
		Node tmp=list.head;
		Node pre=null;
		while(tmp!=null){
			if(table.contains(tmp.data)){
				pre.next=tmp.next;
			}else{
				table.put(tmp.data, true);
				pre=tmp;
			}
			tmp=tmp.next;
		}
	}
	
	public void remove2(ImplementLinkedList list){
		if(list.head==null) return;
		
		Node node1=list.head;
		Node node2=node1.next;
		Node pre=node1;
		while(node1!=null){
			while(node2!=null){
				if(node1.data==node2.data){
					pre.next=node2.next;
				}
				node1=node1.next;
				node2=node1;
				pre=node1;
			}
		}
	}
}
