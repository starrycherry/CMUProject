/**
 * Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
package Leetcode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode preHead=new ListNode(0);
        preHead.next=head;
        ListNode node=preHead;
        
        while(node.next!=null&&node.next.next!=null){
            ListNode temp=node.next;
             node.next=node.next.next;
             temp.next=node.next.next;
            
            node.next.next=temp;
            node=node.next.next;
        }
        
        return preHead.next;
    }
    
    public static void main(String[] args){
    	SwapNodesInPairs s=new SwapNodesInPairs();
    	ListNode head=new ListNode(1);
    	head.next=new ListNode(2);
    	s.swapPairs(head);
    }
}
