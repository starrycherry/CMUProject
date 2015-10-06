package Leetcode;

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
	    if(head == null)
	        return null;
	    ListNode helper = new ListNode(0);
	    ListNode pre = helper;
	    ListNode cur = head;
	    while(cur!=null)
	    {
	        ListNode next = cur.next;
	        pre = helper;
	        while(pre.next!=null && pre.next.val<=cur.val)
	        {
	            pre = pre.next;
	        }
	        cur.next = pre.next;
	        pre.next = cur;
	        cur = next;
	    }
	    return helper.next;
	}
    
    public static void main(String[] args){
    	InsertionSortList i=new InsertionSortList();
    	ListNode head=new ListNode(3);
    	head.next=new ListNode(2);
    	head.next.next=new ListNode(4);
    	
    	i.insertionSortList(head);
    }
}
