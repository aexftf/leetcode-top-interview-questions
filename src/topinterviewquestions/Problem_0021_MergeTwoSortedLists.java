package topinterviewquestions;
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//示例 1：
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
//链接：https://leetcode.cn/problems/merge-two-sorted-lists
public class Problem_0021_MergeTwoSortedLists {
//背诵

//合并两个有序链表
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		else if (l2 == null) {
			return l1;
		}
		else if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		}
		else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}

	}





//-------------------------------------------------------------------------




//合并两个有序链表
	public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}
		//
		ListNode head = l1.val <= l2.val ? l1 : l2;
		ListNode cur1 = head.next;
		ListNode cur2 = head == l1 ? l2 : l1;
		ListNode pre = head;

		while (cur1 != null && cur2 != null) {
			//谁小放下去
			if (cur1.val <= cur2.val) {
				pre.next = cur1;
				cur1 = cur1.next;
			} else {
				pre.next = cur2;
				cur2 = cur2.next;
			}
			pre = pre.next;
		}

		pre.next = cur1 != null ? cur1 : cur2;
		return head;
	}









	public static class ListNode {
		public int val;
		public ListNode next;
	}
}
