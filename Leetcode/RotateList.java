/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 */
package Leetcode;

public class RotateList {
	   public ListNode rotateRight(ListNode head, int k) {
	        if(head==null){
	            return null;
	        }
	        
	        int count=0;
	       
	        ListNode preHead=new ListNode(0);
	        preHead.next=head;
	        ListNode pre=preHead;
	        ListNode node=head;
	        
	        while(node!=null){
	            pre=node;
	            node=node.next;
	            count++;
	        }
	        ListNode tail=pre;
	        int len=count;
	        
	        count=0;
	        pre=preHead;
	        node=head;
	        while(count<len-k%len-1&&node!=null){
	            pre=node;
	            node=node.next;
	            count++;
	        }
	        
	        if(node==null||node.next==null){
	            return preHead.next;
	        }
	        
	       
	        preHead.next=node.next;
	        tail.next=head;
	        node.next=null;
	        
	        return preHead.next;
	    }
	 public static void main(String[] args){
		 RotateList r=new RotateList();
		 ListNode head=new ListNode(1);
		 head.next=new ListNode(2);
		 /*head.next.next=new ListNode(3);
		 head.next.next.next=new ListNode(4);
		 head.next.next.next.next=new ListNode(5);*/
		 r.rotateRight(head, 1);
	 }
}
