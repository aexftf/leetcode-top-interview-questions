package topinterviewquestions;

public class Problem_0019_RemoveNthNodeFromEndofList {


//删除链表的倒数第N个节点
	//方法一：计算链表长度
//思路与算法
//
//一种容易想到的方法是，我们首先从头节点开始对链表进行一次遍历，得到链表的长度
//L。随后我们再从头节点开始对链表进行一次遍历，当遍历到第
//L−n+1 个节点时，它就是我们需要删除的节点。
//为了与题目中的
//n 保持一致，节点的编号从
//1 开始，头节点为编号
//1 的节点。
//为了方便删除操作，我们可以从哑节点开始遍历
//L−n+1 个节点。当遍历到第
//L−n+1 个节点时，它的下一个节点就是我们需要删除的节点，这样我们只需要修改一次指针，就能完成删除操作。
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0, head);
		int length = getLength(head);
		ListNode cur = dummy;

		for (int i = 1; i < length - n + 1; ++i) {
			cur = cur.next;
		}
		cur.next = cur.next.next;
		ListNode ans = dummy.next;

		return ans;
	}

	public int getLength(ListNode head) {
		int length = 0;
		while (head != null) {
			++length;
			head = head.next;
		}
		return length;
	}


	//------------------------------------------------------------------------










//
//
//	public static ListNode removeNthFromEnd1(ListNode head, int n) {
//		ListNode cur = head;
//		ListNode pre = null;
////找到你
//		while (cur != null) {
//
//			n--;
//
//			if (n == -1) {
//				pre = head;
//			}
//
//			if (n < -1) {
//				pre = pre.next;
//			}
//			cur = cur.next;
//		}
//
////跳出来了
//		if (n > 0) {
//			return head;
//		}
//		if (pre == null) {
//			return head.next;
//		}
//
//		pre.next = pre.next.next;
//
//		return head;
//
//	}
//




	public static class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int val, ListNode head) {
		}
	}
}
