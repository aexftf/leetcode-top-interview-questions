package topinterviewquestions;

public class Problem_0328_OddEvenLinkedList {




	public ListNode oddEvenList(ListNode head) {

		ListNode firstOdd = null;
		ListNode firstEven = null;
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









	public static class ListNode {
		int val;
		ListNode next;
	}
}
