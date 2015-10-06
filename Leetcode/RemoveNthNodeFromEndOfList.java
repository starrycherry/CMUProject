/**
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
 */

package Leetcode;

public class RemoveNthNodeFromEndOfList {
	 public ListNode removeNthFromEnd(ListNode head, int n) {
	        if(head==null){
	            return null;
	        }
	        if(n==0){
	            return head;
	        }
	        
	        ListNode slow=head;
	        ListNode fast=head;
	        int count=0;
	        while(count<n){
	            if(fast==null){
	                return head;
	            }
	            fast=fast.next;
	            count++;
	        }
	        if(fast==null){
	            return head.next;
	        }
	        
	        while(fast.next!=null){
	            slow=slow.next;
	            fast=fast.next;
	        }
	        
	        slow.next=slow.next.next;
	        return head;
	    }
	
	public static void main(String[] args){
		RemoveNthNodeFromEndOfList r=new RemoveNthNodeFromEndOfList();
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		r.removeNthFromEnd(head, 1);
	}
}
