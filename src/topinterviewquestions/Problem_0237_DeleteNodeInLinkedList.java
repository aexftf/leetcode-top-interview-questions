package topinterviewquestions;

public class Problem_0237_DeleteNodeInLinkedList {

//   既然不能先删除自己，那就把自己整容成儿子，再假装儿子养活孙子
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}





	public static class ListNode {
		int val;
		ListNode next;
	}

}
