package topinterviewquestions;

//两数相加
//
//给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
//
//请你将两个数相加，并以相同形式返回一个表示和的链表。
//
//你可以假设除了数字 0 之外，这两个数都不会以 0开头。
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.

//示例 2：
//输入：l1 = [0], l2 = [0]
//输出：[0]

//示例 3：
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
public class Problem_0002_AddTwoNumbers {


//规律，加完之后倒过来，记住正好了一样  //看以前画的图就懂了
	public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
		int ca = 0;
		int n1 = 0;
		int n2 = 0;
		int n = 0;

		ListNode c1 = head1;
		ListNode c2 = head2;
		ListNode node = null;
		ListNode pre = null;

		while (c1 != null || c2 != null) {
			n1 = c1 != null ? c1.val : 0;
			n2 = c2 != null ? c2.val : 0;

			n = n1 + n2 + ca;
			pre = node;

			node = new ListNode(n % 10);
			node.next = pre;

			ca = n / 10;
			c1 = c1 != null ? c1.next : null;
			c2 = c2 != null ? c2.next : null;
		}
		if (ca == 1) {
			pre = node;
			node = new ListNode(1);
			node.next = pre;
		}
		return reverseList(node);
	}







//=========================================
	public static ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode next = null;

		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}





















		public static class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int value) {
			this.val = value;
		}
	}


}
