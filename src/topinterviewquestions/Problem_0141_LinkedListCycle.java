package topinterviewquestions;
//141. 环形链表
//给你一个链表的头节点 head ，判断链表中是否有环。
//如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
//为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递。
//仅仅是为了标识链表的实际情况。
//如果链表中存在环，则返回 true 。 否则，返回 false 。
//链接：https://leetcode.cn/problems/linked-list-cycle
public class Problem_0141_LinkedListCycle {




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






	public static class ListNode {
		int val;
		ListNode next;
	}
}
