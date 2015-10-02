package Leetcode;

public class ReverseLinkedList2 {
	
	//Memory Limit Exceeds
	 public ListNode reverseBetween(ListNode head, int m, int n) {
	        if(head==null){
	            return null;
	        }
	        
	        if(m==n){
	            return head;
	        }
	        int count=1;
	        ListNode newHead = new ListNode(0);
	        newHead.next=head;
	        ListNode preMnode=newHead;
	        
	        while(count<m){
	            preMnode=preMnode.next;
	            ++count;
	        }
	        
	        ListNode node=preMnode.next;
	        ListNode curr=node.next;
	        ListNode temp=null; 
	        while(curr!=null&&count<n){
	            temp=curr.next;
	            curr.next=node;
	            node=curr;
	            curr=temp;
	            ++count;
	        }
	        curr=preMnode.next;
	        preMnode.next=node;
	        temp=curr;
	        return newHead.next;
	        
	    }
	 
	 
     public ListNode reverseBetween1(ListNode head, int m, int n) {
         if(head == null)
             return head;
         ListNode newHead = new ListNode(0);
         newHead.next=head;
         ListNode preMnode=newHead;
         int i=1;
         //找到m节点的前一个节点preMnode
         while(preMnode!=null && i<m)
         {
             preMnode = preMnode.next;
             i++;
         }
         if(i<m) 
             return head;
         ListNode Mnode=preMnode.next;
         //对m节点到n节点之间的节点进行转置，每次读取一个节点就放在preMnode节点的后面
         ListNode curNode=Mnode.next;
         while(curNode!=null && i<n)
         {
             ListNode next=curNode.next;
             curNode.next=preMnode.next;
             preMnode.next=curNode;
             Mnode.next=next;
             curNode=next;
             i++;      
         }
         return newHead.next;
     }
     
     public static void main(String[] args){
    	 ListNode node=new ListNode(1);
    	 node.next=new ListNode(2);
    	 node.next.next=new ListNode(3);
    	 node.next.next.next=new ListNode(4);
    	 node.next.next.next.next=new ListNode(5);
    	 ReverseLinkedList2 r=new ReverseLinkedList2();
    	 r.reverseBetween1(node, 2, 4);
     }
}
