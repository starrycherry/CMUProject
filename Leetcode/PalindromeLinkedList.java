package Leetcode;
/**
 * Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
 * @author Cherrie
 * 此题的思路就是把后半部分的linkedlist反转,然后和前面的作对比,但是反转linkedList要尤其注意. 
 *
 */
public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
        if(head==null){
            return true;
        }
        
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
            if(fast!=null){
                fast=fast.next;
            }
        }
        if(slow==null){
            return true;
        }
        
        
        ListNode rhead=new ListNode(0);
        rhead.next=slow;
        ListNode pre=rhead;
        ListNode cur=slow;
        ListNode end=cur;
        while(cur!=null){
        ListNode temp=pre.next;
        	pre.next=cur;
        	ListNode next=cur.next;
        	cur.next=temp;
        	end.next=next;
        	cur=next;
           }
        ListNode node1=head;
        ListNode node2=rhead.next;
        while(node1!=null&&node2!=null){
            if(node1.val!=node2.val){
                return false;
            }
            node1=node1.next;
            node2=node2.next;
        }
        return true;
    }
    
	   public static void main(String[] args){
		   ListNode head=new ListNode(1);
		   head.next=new ListNode(0);
		   head.next.next=new ListNode(3);
		   head.next.next.next=new ListNode(4);
		   head.next.next.next.next=new ListNode(0);
		   head.next.next.next.next.next=new ListNode(1);
		   PalindromeLinkedList p=new PalindromeLinkedList();
		   System.out.println(p.isPalindrome(head));
	   }
}
