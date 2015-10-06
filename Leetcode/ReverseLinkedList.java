package Leetcode;
/**
 * Reverse a singly linked list.
 * @author Cherrie
 *
 */
public class ReverseLinkedList {
	
	//Iterative method
	  public ListNode reverseListItr(ListNode head) {
	        if(head==null){
	            return null;
	        }
	        
	        ListNode preHead=new ListNode(0);
	        preHead.next=head;
	        ListNode pre=preHead;
	        ListNode node=head;
	        ListNode end=head;
	        while(node!=null){
	            ListNode temp=pre.next;
	            pre.next=node;
	            ListNode next=node.next;
	            node.next=temp;
	            end.next=next;
	            node=next;
	        }
	        return preHead.next;
	    }
	  
	  //recursive method
	  public ListNode reverseList(ListNode head) {
	        if(head==null||head.next==null){
	            return head;
	        }
	        
	        ListNode temp=head.next;
	        head.next=null;
	        ListNode rest=reverseList(temp);
	        temp.next=head;
	        return rest;
	    }
}
