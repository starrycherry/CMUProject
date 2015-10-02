/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 */
package Leetcode;

public class PartitionList {
	   public ListNode partition(ListNode head, int x) {
	        if(head==null){
	            return null;
	        }
	        ListNode head2=null;
	        ListNode node=head;
	        ListNode node2=head2;
	        ListNode pre=head;
	        while(node!=null){
	            if(node.val>=x){
	                if(head2==null){
	                    head2=node;
	                    node2=head2;
	                }else{
	                    node2.next=node;
	                    node2=node2.next;
	                }
	            }else{
	                if(!node.equals(head)){
	                    pre.next=node;
	                    pre=pre.next;
	                }
	               
	            }
	            node=node.next;
	        }
	        node2.next=null;
	        pre.next=head2;
	        return head;
	    }
	   
	    public ListNode partition1(ListNode head, int x) {
	        if(head==null){
	            return null;
	        }
	        
	        ListNode helper=new ListNode(0);
	        helper.next=head;
	        ListNode less=helper;
	        ListNode big=helper;
	      
	      while(big.next!=null){
	          if(big.next.val<x){
	              if(big!=less){
	                  ListNode next=big.next.next;
	                  big.next.next=less.next;
	                  less.next=big.next;
	                  big.next=next;
	                  less=less.next;
	              }else{
	                  big=big.next;
	                  less=less.next;
	              }
	          }else{
	              big=big.next;
	          }
	      }
	      return helper.next;
	    }
	   
	   public static void main(String[] args){
		   PartitionList p=new PartitionList();
		   ListNode node=new ListNode(3);
		   node.next=new ListNode(1);
		   node.next.next=new ListNode(2);
	/*	   node.next.next.next=new ListNode(2);
		   node.next.next.next.next=new ListNode(5);
		   node.next.next.next.next.next=new ListNode(2);*/
		   
		   p.partition1(node, 3);
	   }
}
