package Leetcode;
/**
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
 * @author Cherrie
 * 
 * 此题无法知道之前的node是什么情况于是只能把现在node的值替换成后面的node即可
 *
 */
public class DeleteNodeInALinkedList {
	   public void deleteNode(ListNode node) {
	        if(node==null){
	            return;
	        }
	        
	        node.val=node.next.val;
	        node.next=node.next.next;
	    }
}
