package topinterviewquestions;
//早看完了
public class Problem_0206_ReverseLinkedList {



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
		int val;
		ListNode next;
	}

}
