package topinterviewquestions;

import java.util.Comparator;
import java.util.PriorityQueue;
//	还要看不太懂
public class Problem_0023_MergeKSortedLists {

	public static class ListNode {
		public int val;
		public ListNode next;
	}

	public static class ListNodeComparator implements Comparator<ListNode> {
		@Override
		public int compare(ListNode o1, ListNode o2) {//小根堆
			return o1.val - o2.val;
		}
	}

	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists == null) {
			return null;
		}
		//条件反射：有门槛的条件东西，要用堆
		PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());

		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				heap.add(lists[i]);
			}
		}
		if (heap.isEmpty()) {
			return null;
		}

		ListNode head = heap.poll();
		ListNode pre = head;
		if (pre.next != null) {
			heap.add(pre.next);
		}

		while (!heap.isEmpty()) {
			ListNode cur = heap.poll();
			pre.next = cur; //
			pre = cur;

			if (cur.next != null) {
				heap.add(cur.next);
			}
		}
		return head;
	}

}
