/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
package Leetcode;

// Definition for singly-linked list.
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
 
public class AddLinkedList {
	   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        int carry=0;
	        ListNode head=null;
	        ListNode r=null;
	        
	        while(l1!=null&&l2!=null){
	            int sum=l1.val+l2.val+carry;
	            carry=sum/10;
	           if(head==null){
		                head=new ListNode((int)(sum%10));;
		                r=head;
		            }else{
		                r.next=new ListNode((int)(sum%10));
		                r=r.next;
		            }
	            l1=l1.next;
	            l2=l2.next;
	        }
	        
	        while(l1!=null){
	            int sum=l1.val+0+carry;
	            carry=sum/10;
	            r.next=new ListNode((int)(sum%10));
	            r=r.next;
	            l1=l1.next;
	        }
	        
	           while(l2!=null){
	            int sum=l2.val+0+carry;
	            carry=sum/10;
	            r.next=new ListNode((int)(sum%10));
	            r=r.next;
	            l2=l2.next;
	        }
	        
	        if(carry!=0){
	            r.next=new ListNode(carry);
	        }
	       return head;
	    }
	 
	 public static void main(String[] args){
		 AddLinkedList a=new AddLinkedList();
		 ListNode l1=new ListNode(5);
		 ListNode l2=new ListNode(5);
		 ListNode r=a.addTwoNumbers(l1, l2);
		 while(r!=null){
			 System.out.println(r.val);
			 r=r.next;
		 }
	 }
}
