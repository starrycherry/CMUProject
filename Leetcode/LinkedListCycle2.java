/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Follow up:
Can you solve it without using extra space?
 * 
 * 
 * ʹ������ָ��slow,fast������ָ�붼�ӱ�ͷ��ʼ�ߣ�slowÿ����һ����fastÿ�������������fast����null����˵��û�л�������false�����slow==fast��˵���л������Ҵ�ʱfast����slowһȦ������true��

Ϊʲô�л�������¶���һ���������أ���Ϊfast�Ƚ��뻷����slow����֮�������slow������ǰ�棬fast�ں���ÿ��ѭ������slow����1������һ�������������������fastֱ������slow�������

����������򵥣���

��һ������ʱslow�߹��ľ��룺a+b��fast�߹��ľ��룺a+b+c+b��

��Ϊfast���ٶ���slow������������fast�ߵľ�����slow���������� 2(a+b) = a+b+c+b�����Եõ�a=c��������ۺ���Ҫ������

���Ƿ���L=b+c=a+b��Ҳ����˵����һ��ʼ�����ߵ�һ��������ѭ���Ĵ����͵��ڻ��ĳ��ȡ�

2. �����Ѿ��õ��˽���a=c����ô������ָ��ֱ��X��Z��ʼ�ߣ�ÿ����һ������ô���û���Y������Ҳ���ǻ��ĵ�һ���ڵ㡣

3. ����һ���������󣬽�c����Y��֮ǰ���Ǹ��ڵ���Y�������жϼ��ɡ�

4. ����ж������������Ƿ��н��㣿���ж����������Ƿ��л������һ���л�һ��û�����϶����ཻ�����������û�л����ж������б��β���Ƿ���ȣ�����������л����ж�һ�������ϵ�Z���Ƿ�����һ�������ϡ�

����ҵ���һ���ཻ�Ľڵ㣿�����������ĳ���L1,L2������л�����Y�㵱��β�ڵ����㣩������L1<L2��������ָ��ֱ�����������ͷ����ʼ�ߣ�����ΪL2����������(L2-L1)����Ȼ������һ���ߣ�ֱ������������
 */
package Leetcode;

public class LinkedListCycle2 {
	  public ListNode detectCycle(ListNode head) {
	        if(head==null){
	            return null;
	        }
	        ListNode fast=head;
	        ListNode slow=head;
	        while(fast!=null&&fast.next!=null){
	            fast=fast.next.next;
	            slow=slow.next;
	            if(fast!=null&&fast.equals(slow)){
	                break;
	            }
	        }
	        if(fast==null||fast.next==null){
	            return null;
	        }
	        
	        fast=head;
	        while(!fast.equals(slow)){
	            slow=slow.next;
	            fast=fast.next;
	        }
	        
	        return fast;
	    }
	  
	  public static void main(String[] args){
		  LinkedListCycle2 l=new LinkedListCycle2();
		  ListNode root=new ListNode(1);
		  root.next=new ListNode(2);
		  
		  l.detectCycle(root);
	  }
}
