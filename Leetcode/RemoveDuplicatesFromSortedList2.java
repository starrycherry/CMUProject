	/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 */
package Leetcode;

public class RemoveDuplicatesFromSortedList2 {
	public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        
        
        ListNode preHead=new ListNode(0);
        preHead.next=head;
        ListNode pre=preHead;
        ListNode node=head;
        
        if(node.next==null){
            return head;
        }
        
        while(node!=null&&node.next!=null){
            if(node.val==node.next.val){
                node=node.next;
            }else{
                if(node.equals(pre.next)){
                    pre=node;
                    node=node.next;
                }else{
                    pre.next=node.next;
                    node=pre.next;
                }
                
            }
        }
        
        if(!node.equals(pre.next)){
             pre.next=node.next;
        }
       
        return preHead.next;
    }
}
