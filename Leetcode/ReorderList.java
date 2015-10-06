package Leetcode;

public class ReorderList {
	 public void reorderList(ListNode head) {
	        if(head==null){
	            return;
	        }
	        ListNode slow=head;
	        ListNode fast=head;
	        
	        while(fast!=null&&fast.next!=null){
	            slow=slow.next;
	            fast=fast.next.next;
	        }
	        
	        ListNode head2=reverse(slow);
	        slow.next=null;
	        
	        ListNode node=head;
	        ListNode node2=head2;
	        while(node!=null&&node2!=null){
	            ListNode temp=node.next;
	            ListNode temp2=node2.next;
	            node.next=node2;
	            node2=temp;
	            node=temp;
	            node2=temp2;
	        }
	        
	        /*if(node!=null){
	            node2.next=node;
	        }else{
	            node.next=node2;
	        }*/
	    }
	    
	    private ListNode reverse(ListNode head){
	        ListNode node=head;
	        ListNode parent=null;
	        while(node.next!=null){
	            ListNode temp=node.next;
	            node.next=parent;
	            parent=node;
	            node=temp;
	        }
	        return node;
	    }
	    
	    
	    public void reorderList2(ListNode head) {
	        if(head==null || head.next==null)
	            return;
	        //split
	        ListNode fast = head;
	        ListNode slow = head;
	        while(true)
	        {
	            fast = fast.next.next;
	            if(fast==null || fast.next==null)
	                break;
	            slow = slow.next;
	        }
	        fast = slow.next;
	        slow.next = null;
	        slow = head;
	        //reverse fast
	        fast = reverse(fast);
	        //insert
	        while(slow!=null && fast!=null)
	        {
	            ListNode snext=slow.next;
	            ListNode fnext=fast.next;
	            slow.next=fast;
	            if(snext!=null)
	                fast.next=snext;
	            slow = snext;
	            fast = fnext;
	        }
	    }
	    public ListNode reverse2(ListNode head)
	    {
	        ListNode cur = head;
	        ListNode pre = null;
	        while(cur!=null)
	        {
	            ListNode temp = cur.next;
	            cur.next = pre;
	            pre = cur;
	            cur = temp;
	        }
	        return pre;
	    }
	    public static void main(String[] args){
	    	ReorderList r=new ReorderList();
	    	ListNode head=new ListNode(1);
	    	head.next=new ListNode(2);
	    	head.next.next=new ListNode(3);
	    	r.reorderList(head);
	    }
}
