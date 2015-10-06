/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * 用了mergeSort的方法. 
 * 
 * 有时间可以尝试第二种方法
 * 这种方法用到了堆的数据结构，思路比较难想到，但是其实原理比较简单。维护一个大小为k的堆，每次取堆顶的最小元素放到结果中，然后读取该元素的下一个元素放入堆中，重新维护好。因为每个链表是有序的，
 * 每次又是去当前k个元素中最小的，所以当所有链表都读完时结束，这个时候所有元素按从小到大放在结果链表中。这个算法每个元素要读取一次，即是k*n次，然后每次读取元素要把新元素插入堆中要logk的复杂度，
 * 所以总时间复杂度是O(nklogk)。空间复杂度是堆的大小，即为O(k)。
 */

package Leetcode;

public class MergedTwoSortedList {
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        if(l1==null&&l2==null){
	            return null;
	        }
	        if(l1==null&&l2!=null){
	            return l2;
	        }
	        if(l1!=null&&l2==null){
	            return l1;
	        }
	        
	        ListNode pre=new ListNode(0);
	        mergeSort(l1,l2,pre);
	        return pre.next;
	    }
	    private void mergeSort(ListNode l1,ListNode l2,ListNode l3){
	        while(l1!=null&&l2!=null){
	            if(l1.val<=l2.val){
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
	    }
}
