package topinterviewquestions;

public class Problem_0141_LinkedListCycle {

	public static class ListNode {
		int val;
		ListNode next;
	}

	public static boolean hasCycle(ListNode head) {
		return getFirstLoopNode(head) != null;
	}
	//快慢指针解
	public static ListNode getFirstLoopNode(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		//快指针一次走两步，慢指针一次走一步，有环一定会相遇
		ListNode slow = head.next;
		ListNode fast = head.next.next;

		while (slow != fast) {

			if (fast.next == null || fast.next.next == null) {
				return null;
			}

			fast = fast.next.next;
			slow = slow.next;
		}
		//相遇后-快指·针从头开始走
		fast = head;
		//快指针变成一次走一步
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

}
