package Leetcode;
/**
 * Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
 * @author Cherrie
 *
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return head;
        }
        
        ListNode preHead=new ListNode(0);
        preHead.next=head;
        ListNode pre=preHead;
        ListNode node=head;
        while(node!=null){
            if(node.val==val){
                pre.next=node.next;
                node=pre.next;
            }else{
                pre=node;
                node=node.next;
            }
            
        }
        return preHead.next;
    }
}
