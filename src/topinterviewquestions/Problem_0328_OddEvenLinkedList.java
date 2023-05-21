package topinterviewquestions;

public class Problem_0328_OddEvenLinkedList {

//给定单链表的头节点head，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
//第一个节点的索引被认为是 奇数 ， 第二个节点的索引为偶数 ，以此类推。
//请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
//你必须在O(1)的额外空间复杂度和O(n)的时间复杂度下解决这个问题。
//链接：https://leetcode.cn/problems/odd-even-linked-list


	public ListNode oddEvenList1(ListNode head) {

		ListNode firstOdd = null;//鸡头
		ListNode firstEven = null;//偶尾
		ListNode odd = null;
		ListNode even = null;
		ListNode next = null;
		int count = 1;

		while (head != null) {
			next = head.next;
			head.next = null;

			if ((count & 1) == 1) {
				firstOdd = firstOdd == null ? head : firstOdd;
				if (odd != null) {
					odd.next = head;
				}
				odd = head;
			} else {
				firstEven = firstEven == null ? head : firstEven;
				if (even != null) {
					even.next = head;
				}
				even = head;
			}
			count++;
			head = next;
		}

		if (odd != null) {
			odd.next = firstEven;
		}

		return firstOdd != null ? firstOdd : firstEven;
	}





		public ListNode oddEvenList(ListNode head) {
			// 分别定义奇偶链表的 虚拟头结点 和 尾结点
			ListNode oddHead = new ListNode();
			ListNode oddTail = oddHead;
			ListNode evenHead = new ListNode();
			ListNode evenTail = evenHead;
			// 遍历原链表，根据 isOdd 标识位决定将当前结点插入到奇链表还是偶链表（尾插法）
			boolean isOdd = true;
			while (head != null) {
				if (isOdd) {
					oddTail.next = head;

					oddTail = oddTail.next;
				} else {
					evenTail.next = head;

					evenTail = evenTail.next;
				}

				head = head.next;
				isOdd = !isOdd;
			}
			// 将奇链表后面拼接上偶链表，并将偶链表的next设置为null
			oddTail.next = evenHead.next;

			evenTail.next = null;

			return oddHead.next;
		}





	public static class ListNode {
		int val;
		ListNode next;
	}
}
