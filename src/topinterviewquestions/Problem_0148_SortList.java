package topinterviewquestions;
//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
public class Problem_0148_SortList {

	//time:nlogn

//看解释不看不懂
	//https://leetcode.cn/problems/sort-list/solution/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/


		public ListNode sortList(ListNode head) {
			if (head == null || head.next == null)
				return head;
			ListNode fast = head.next, slow = head;

			while (fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			ListNode tmp = slow.next;
			slow.next = null;

			ListNode left = sortList(head);
			ListNode right = sortList(tmp);

			ListNode h = new ListNode(0);
			ListNode res = h;

			while (left != null && right != null) {
				if (left.val < right.val) {
					h.next = left;
					left = left.next;
				} else {
					h.next = right;
					right = right.next;
				}
				h = h.next;
			}

			h.next = left != null ? left : right;
			return res.next;
		}





//============================================================================

	//个人感觉递归分割链表时写成这样好理解些
	public ListNode sortList1(ListNode head) {
		return sort(head, null);
	}

	private ListNode sort(ListNode start, ListNode end) {
		if(start == end)        return start;

		ListNode fast = start, slow = start;
		while(fast != end && fast.next != end){
			fast = fast.next.next;
			slow = slow.next;
		}

		ListNode l2 = sort(slow.next, end);
		slow.next = null;//断开变成了俩了
		ListNode l1 = sort(start, slow);


		return merge(l1, l2);
	}


	//递归
	private ListNode merge(ListNode l1, ListNode l2) {
		if(l1 == null || l2 == null)
			return l1 == null ? l2 : l1;

		if(l1.val < l2.val){
			l1.next = merge(l1.next, l2);
			return l1;
		}else{
			l2.next = merge(l1, l2.next);
			return l2;
		}
	}



//============================================================================

	// 自底向上归并排序
	public ListNode sortList2(ListNode head) {
		if(head == null){
			return head;
		}

		// 1. 首先从头向后遍历,统计链表长度
		int length = 0; // 用于统计链表长度
		ListNode node = head;
		while(node != null){
			length++;
			node = node.next;
		}

		// 2. 初始化 引入dummynode
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;

		// 3. 每次将链表拆分成若干个长度为subLen的子链表 , 并按照每两个子链表一组进行合并
		for(int subLen = 1;subLen < length;subLen = subLen*2){ // subLen每次左移一位（即sublen = sublen*2） PS:位运算对CPU来说效率更高
			ListNode prev = dummyHead;
			ListNode curr = dummyHead.next;     // curr用于记录拆分链表的位置

			while(curr != null){               // 如果链表没有被拆完
				// 3.1 拆分subLen长度的链表1
				ListNode head_1 = curr;        // 第一个链表的头 即 curr初始的位置
				for(int i = 1; i < subLen && curr != null && curr.next != null; i++){     // 拆分出长度为subLen的链表1
					curr = curr.next;
				}

				// 3.2 拆分subLen长度的链表2
				ListNode head_2 = curr.next;  // 第二个链表的头  即 链表1尾部的下一个位置
				curr.next = null;             // 断开第一个链表和第二个链表的链接
				curr = head_2;                // 第二个链表头 重新赋值给curr

				for(int i = 1;i < subLen && curr != null && curr.next != null;i++){      // 再拆分出长度为subLen的链表2
					curr = curr.next;
				}

				// 3.3 再次断开 第二个链表最后的next的链接
				ListNode next = null;
				if(curr != null){
					next = curr.next;   // next用于记录 拆分完两个链表的结束位置
					curr.next = null;   // 断开连接
				}

				// 3.4 合并两个subLen长度的有序链表
				ListNode merged = mergeTwoLists(head_1,head_2);
				prev.next = merged;        // prev.next 指向排好序链表的头
				while(prev.next != null){  // while循环 将prev移动到 subLen*2 的位置后去
					prev = prev.next;
				}
				curr = next;              // next用于记录 拆分完两个链表的结束位置
			}
		}
		// 返回新排好序的链表
		return dummyHead.next;
	}









	// 此处是Leetcode21 --> 合并两个有序链表
	public ListNode mergeTwoLists(ListNode l1,ListNode l2){
		ListNode dummy = new ListNode(0);
		ListNode curr  = dummy;

		while(l1 != null && l2!= null){ // 退出循环的条件是走完了其中一个链表
			// 判断l1 和 l2大小
			if (l1.val < l2.val){
				// l1 小 ， curr指向l1
				curr.next = l1;
				l1 = l1.next;       // l1 向后走一位
			}else{
				// l2 小 ， curr指向l2
				curr.next = l2;
				l2 = l2.next;       // l2向后走一位
			}
			curr = curr.next;       // curr后移一位
		}

		// 退出while循环之后,比较哪个链表剩下长度更长,直接拼接在排序链表末尾
		if(l1 == null) curr.next = l2;
		if(l2 == null) curr.next = l1;

		// 最后返回合并后有序的链表
		return dummy.next;
	}













	public static class ListNode {
		int val;
		ListNode next;
		public ListNode(int v) {
			val = v;
		}
	}















}
