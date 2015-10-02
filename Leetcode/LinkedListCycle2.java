/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Follow up:
Can you solve it without using extra space?
 * 
 * 
 * 使用两个指针slow,fast。两个指针都从表头开始走，slow每次走一步，fast每次走两步，如果fast遇到null，则说明没有环，返回false；如果slow==fast，说明有环，并且此时fast超了slow一圈，返回true。

为什么有环的情况下二者一定会相遇呢？因为fast先进入环，在slow进入之后，如果把slow看作在前面，fast在后面每次循环都向slow靠近1，所以一定会相遇，而不会出现fast直接跳过slow的情况。

方法三（最简单）：

第一次相遇时slow走过的距离：a+b，fast走过的距离：a+b+c+b。

因为fast的速度是slow的两倍，所以fast走的距离是slow的两倍，有 2(a+b) = a+b+c+b，可以得到a=c（这个结论很重要！）。

我们发现L=b+c=a+b，也就是说，从一开始到二者第一次相遇，循环的次数就等于环的长度。

2. 我们已经得到了结论a=c，那么让两个指针分别从X和Z开始走，每次走一步，那么正好会在Y相遇！也就是环的第一个节点。

3. 在上一个问题的最后，将c段中Y点之前的那个节点与Y的链接切断即可。

4. 如何判断两个单链表是否有交点？先判断两个链表是否有环，如果一个有环一个没环，肯定不相交；如果两个都没有环，判断两个列表的尾部是否相等；如果两个都有环，判断一个链表上的Z点是否在另一个链表上。

如何找到第一个相交的节点？求出两个链表的长度L1,L2（如果有环，则将Y点当做尾节点来算），假设L1<L2，用两个指针分别从两个链表的头部开始走，长度为L2的链表先走(L2-L1)步，然后两个一起走，直到二者相遇。
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
