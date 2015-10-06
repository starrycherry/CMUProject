package Leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * @author Cherrie
 *
 */
public class MergeKLists {
	 public ListNode mergeKLists(ListNode[] lists) {
	        if(lists==null||lists.length==0){
	            return null;
	        }
	        
	        return mergeKListsHelper(lists,0,lists.length-1);
	    }
	    
	    private ListNode mergeKListsHelper(ListNode[] lists,int l, int r){
	        if(l<r){
	            int m=(l+r)/2;
	            return merge(mergeKListsHelper(lists,l,m),mergeKListsHelper(lists,m+1,r));
	        }
	        return lists[l];
	    }
	    
	    private ListNode merge(ListNode l1,ListNode l2){
	        ListNode pre=new ListNode(0);
	        ListNode l3=pre;
	        
	        while(l1!=null&&l2!=null){
	            if(l1.val<l2.val){
	                l3.next=new ListNode(l1.val);
	                l1=l1.next;
	            }else{
	                l3.next=new ListNode(l2.val);
	                l2=l2.next;
	            }
	            l3=l3.next;
	        }
	        if(l1!=null){
	            l3.next=l1;
	        }
	        if(l2!=null){
	            l3.next=l2;
	        }
	        
	        return pre.next;
	    }
    
	    
	    //�ڶ��ַ������öѵ����ݽṹ
	    //ά��һ����СΪk�Ķѣ�ÿ��ȡ�Ѷ�����СԪ�طŵ�����У�Ȼ���ȡ��Ԫ�ص���һ��Ԫ�ط�����У�����ά���á���Ϊÿ������������ģ�ÿ������ȥ��ǰk��Ԫ������С�ģ����Ե�������������ʱ������
	    //���ʱ������Ԫ�ذ���С������ڽ�������С�����㷨ÿ��Ԫ��Ҫ��ȡһ�Σ�����k*n�Σ�Ȼ��ÿ�ζ�ȡԪ��Ҫ����Ԫ�ز������Ҫlogk�ĸ��Ӷȣ�������ʱ�临�Ӷ���O(nklogk)��
	    public ListNode mergeKLists2(ListNode[] lists) {
	        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(10,new Comparator<ListNode>(){
	                @Override
	                public int compare(ListNode n1, ListNode n2)
	                {
	                    return n1.val-n2.val;
	                }
	            });
	        for(int i=0;i<lists.length;i++)
	        {
	            ListNode node = lists[i]; 
	            if(node!=null)
	            {
	                heap.offer(node);
	            }
	        }
	        ListNode head = null;
	        ListNode pre = head;
	        while(heap.size()>0)
	        {
	            ListNode cur = heap.poll();
	            if(head == null)
	            {
	                head = cur;
	                pre = head;
	            }
	            else
	            {
	                pre.next = cur;
	            }
	            pre = cur;
	            if(cur.next!=null)
	                heap.offer(cur.next);
	        }
	        return head;
	    }
    public static void main(String[] args){
    	MergeKLists m=new MergeKLists();
    	ListNode head1=new ListNode(0);
    	head1.next=new ListNode(5);
    	ListNode head2=new ListNode(1);
    	head2.next=new ListNode(2);
    	head2.next.next=new ListNode(4);
    	ListNode[] lists={head1,head2};
    	m.mergeKLists2(lists);
    }
}
