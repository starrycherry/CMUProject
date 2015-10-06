/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * mergeSort
 */
package Leetcode;

public class SortList {
   	// merge the two sorted sublists
	private ListNode merge(ListNode head1, ListNode head2) {
		if (head1 == null) {
			return head2;
		} else if (head2 == null) {
			return head1;
		}

		ListNode head, prev;
		if (head1.val < head2.val) {
			head = head1;
			head1 = head1.next;
		} else {
			head = head2;
			head2 = head2.next;
		}
		prev = head;

		while (head1 != null && head2 != null) {
			if (head1.val < head2.val) {
				prev.next = head1;
				head1 = head1.next;
			} else {
				prev.next = head2;
				head2 = head2.next;
			}
			prev = prev.next;
		}

		if (head1 != null) {
			prev.next = head1;
		} else if (head2 != null) {
			prev.next = head2;
		}

		return head;
	}

	public ListNode sortList(ListNode head) {
		ListNode head1, head2; // sublist heads

		// split the list into two sublists
		if (head == null || head.next == null) {
			return head;
		} else {
			ListNode fastNode = head.next, slowNode = head;
			while (fastNode != null) {
				fastNode = fastNode.next;
				if (fastNode != null) {
					fastNode = fastNode.next;
					slowNode = slowNode.next;
				}
			}

			head1 = head;
			head2 = slowNode.next;
			slowNode.next = null;
		}

		// sort the two sublists recursively
		head1 = sortList(head1);
		head2 = sortList(head2);

		return merge(head1, head2);
	}
}
