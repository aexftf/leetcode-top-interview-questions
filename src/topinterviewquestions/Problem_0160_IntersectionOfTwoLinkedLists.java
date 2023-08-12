package topinterviewquestions;
//160. 相交链表
public class Problem_0160_IntersectionOfTwoLinkedLists {
//给你两个单链表的头节点headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
//
//图示两个链表在节点 c1 开始相交：
//题目数据 保证 整个链式结构中不存在环。
//注意，函数返回结果后，链表必须 保持其原始结构 。
//自定义评测：
//评测系统 的输入如下（你设计的程序 不适用 此输入）：
//intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
//listA - 第一个链表
//listB - 第二个链表
//skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
//skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数
//评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 视作正确答案 。

//示例 1：
//输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
//输出：Intersected at '8'
//解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
//在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
//— 请注意相交节点的值不为 1，因为在链表 A 和链表 B 之中值为 1 的节点 (A 中第二个节点和 B 中第三个节点) 是不同的节点。换句话说，它们在内存中指向两个不同的位置，而链表 A 和链表 B 中值为 8 的节点 (A 中第三个节点，B 中第四个节点) 在内存中指向相同的位置。




	//     https://leetcode.cn/problems/intersection-of-two-linked-lists/solutions/10774/tu-jie-xiang-jiao-lian-biao-by-user7208t/


//	弄这么多字也没讲明白。若相交，链表A： a+c, 链表B : b+c. a+c+b+c = b+c+a+c 。则会在公共处c起点相遇。若不相交，a +b = b+a 。因此相遇处是NULL
//	受评论区启发加上自己理解：大家可以这样看 有相交时A：a+c，B：b+c，且满足等式a+c+b+c=b+c+a+c，因此他们走了a+b+c之后在c处相遇。 无相交时A：a+c1，B：b+c2。c1与c2仅仅结点数量相同，因此a+c1+b+c2=b+c2+a+c1，且a+c1+b=b+c2+a；但是接下来一个走c1一个走c2，距离NULL距离相同但是并非相交。
//看图一看就懂

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) return null;
		ListNode pA = headA, pB = headB;
		while (pA != pB) {
			pA = pA == null ? headB : pA.next;
			pB = pB == null ? headA : pB.next;
		}
		return pA;
	}

//链接：https://leetcode.cn/problems/intersection-of-two-linked-lists











	public static ListNode getIntersectionNode1(ListNode head1, ListNode head2) {
		if (head1 == null || head2 == null) {
			return null;
		}

		ListNode cur1 = head1;
		ListNode cur2 = head2;
		int n = 0;

		while (cur1.next != null) {
			n++;
			cur1 = cur1.next;
		}

		// cur1  end1
		while (cur2.next != null) {
			n--;
			cur2 = cur2.next;
		}

		// cur2 end2
		if (cur1 != cur2) {
			return null;
		}

		cur1 = n > 0 ? head1 : head2; // 谁是长链表，谁把头节点，给cur1赋值
		cur2 = cur1 == head1 ? head2 : head1;
		n = Math.abs(n);

		while (n != 0) {
			n--;
			cur1 = cur1.next;
		}

		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}

	public class ListNode {
		int val;
		ListNode next;
	}

}
