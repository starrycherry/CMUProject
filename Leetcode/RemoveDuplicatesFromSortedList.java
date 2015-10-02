/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 */
package Leetcode;

public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        
        ListNode pre=head;
        ListNode node=head.next;
        
        while(node!=null){
            if(node.val==pre.val){
                node=node.next;
            }else{
                if(!pre.next.equals(node)){
                    pre.next=node;
                }
                pre=node;
                node=node.next;
            }
        }
        if(pre.next!=null&&!pre.next.equals(node)){
            pre.next=node;
            }
        return head;
    }
}
