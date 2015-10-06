package Leetcode;

public class ConvertSortedListtoBST {
	   public TreeNode sortedListToBST(ListNode head) {
	        if(head==null){
	            return null;
	        }
	        
	        ListNode runner=head;
	        ListNode walker=head;
	        ListNode preHead=new ListNode(0);
	        preHead.next=head;
	        ListNode pre=preHead;
	  
	        while(runner!=null&&runner.next!=null){
	            runner=runner.next.next;
	            walker=walker.next;
	            pre=pre.next;
	        }
	        
	        pre.next=null;
	 
	        TreeNode node=new TreeNode(walker.val);
	        node.left=sortedListToBST(preHead.next);
	        node.right=sortedListToBST(walker.next);
	        
	        return node;
	    }
	    
	    public static void main(String[] args){
	    	ConvertSortedListtoBST c=new ConvertSortedListtoBST();
	    	ListNode head=new ListNode(0);
	    	c.sortedListToBST(head);
	    }
}
