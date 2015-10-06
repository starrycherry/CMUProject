/**
 * Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
 */
package Leetcode;

public class LinkedListCycle {
	  public boolean hasCycle(ListNode head) {
	        if(head==null){
	            return false;
	        }
	        
	        ListNode runner=head;
	        ListNode node=head;
	        
	        while(runner!=null&&runner.next!=null){
	            
	            runner=runner.next.next;
	            node=node.next;
	            if(node!=null&&node.equals(runner)){
	                return true;
	            }
	        }
	        
	        return false;
	    }
}
