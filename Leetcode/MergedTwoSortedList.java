/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * ����mergeSort�ķ���. 
 * 
 * ��ʱ����Գ��Եڶ��ַ���
 * ���ַ����õ��˶ѵ����ݽṹ��˼·�Ƚ����뵽��������ʵԭ��Ƚϼ򵥡�ά��һ����СΪk�Ķѣ�ÿ��ȡ�Ѷ�����СԪ�طŵ�����У�Ȼ���ȡ��Ԫ�ص���һ��Ԫ�ط�����У�����ά���á���Ϊÿ������������ģ�
 * ÿ������ȥ��ǰk��Ԫ������С�ģ����Ե�������������ʱ���������ʱ������Ԫ�ذ���С������ڽ�������С�����㷨ÿ��Ԫ��Ҫ��ȡһ�Σ�����k*n�Σ�Ȼ��ÿ�ζ�ȡԪ��Ҫ����Ԫ�ز������Ҫlogk�ĸ��Ӷȣ�
 * ������ʱ�临�Ӷ���O(nklogk)���ռ临�Ӷ��ǶѵĴ�С����ΪO(k)��
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
