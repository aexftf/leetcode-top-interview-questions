package topinterviewquestions;

import java.util.Comparator;
import java.util.PriorityQueue;
//给你一个链表数组，每个链表都已经按升序排列。
//请你将所有链表合并到一个升序链表中，返回合并后的链表。

//示例 1：
//输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6

//示例 2：
//输入：lists = []
//输出：[]
public class Problem_0023_MergeKSortedLists {

//	最简单的做法
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode ans = null;
		for (int i = 0; i < lists.length; ++i) {
			ans = mergeTwoLists(ans, lists[i]);
		}
		return ans;
	}

	public ListNode mergeTwoLists(ListNode a, ListNode b) {
		if (a == null || b == null) {
			return a != null ? a : b;
		}
		ListNode head = new ListNode(0);//虚拟头节点
		ListNode tail = head, aPtr = a, bPtr = b;

		while (aPtr != null && bPtr != null) {
			if (aPtr.val < bPtr.val) {
				tail.next = aPtr;
				aPtr = aPtr.next;
			} else {
				tail.next = bPtr;
				bPtr = bPtr.next;
			}
			tail = tail.next;
		}
		tail.next = (aPtr != null ? aPtr : bPtr);
		return head.next;
	}







//-----------------------------------------------------------------

	//方法三：使用优先队列合并
	//思路
	//这个方法和前两种方法的思路有所不同，我们需要维护当前每个链表没有被合并的元素的最前面一个，
	//k 个链表就最多有
	//k 个满足这样条件的元素，每次在这些元素里面选取
	//val
	//val 属性最小的元素合并到答案中。在选取最小元素的时候，我们可以用优先队列来优化这个过程。
	//用堆排序
	public static ListNode mergeKLists1(ListNode[] lists) {
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








	public static class ListNodeComparator implements Comparator<ListNode> {
		@Override
		public int compare(ListNode o1, ListNode o2) {//小根堆
			return o1.val - o2.val;
		}
	}

	public static class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int val) {
		}
	}

}
