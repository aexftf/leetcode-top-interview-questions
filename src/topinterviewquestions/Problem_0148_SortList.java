package topinterviewquestions;
//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
public class Problem_0148_SortList {


	// 自底向上归并排序
	public ListNode sortList(ListNode head) {
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











	//=========-----------------------------------------------------------=======




	public static ListNode sortList1(ListNode head) {
		int N = 0;
		ListNode cur = head;

		while (cur != null) {
			N++;
			cur = cur.next;
		}

		ListNode h = head;
		ListNode teamFirst = head;
		ListNode pre = null;

		for (int len = 1; len < N; len <<= 1) {

			while (teamFirst != null) {
				ListNode[] hthtn = hthtn(teamFirst, len);
				ListNode[] mhmt = merge1(hthtn[0], hthtn[1], hthtn[2], hthtn[3]);

				if (h == teamFirst) {
					h = mhmt[0];
					pre = mhmt[1];
				} else {
					pre.next = mhmt[0];
					pre = mhmt[1];
				}
				teamFirst = hthtn[4];
			}
			teamFirst = h;
			pre = null;
		}
		return h;
	}






	public static ListNode[] hthtn(ListNode teamFirst, int len) {

		ListNode ls = teamFirst;
		ListNode le = teamFirst;
		ListNode rs = null;
		ListNode re = null;
		ListNode next = null;
		int pass = 0;

		while (teamFirst != null) {
			pass++;

			if (pass <= len) {
				le = teamFirst;
			}
			if (pass == len + 1) {
				rs = teamFirst;
			}
			if (pass > len) {
				re = teamFirst;
			}
			if (pass == (len << 1)) {
				break;
			}
			teamFirst = teamFirst.next;
		}
		le.next = null;

		if (re != null) {
			next = re.next;
			re.next = null;
		}
		return new ListNode[] { ls, le, rs, re, next };
	}






	public static ListNode[] merge1(ListNode ls, ListNode le, ListNode rs, ListNode re) {
		if (rs == null) {
			return new ListNode[] { ls, le };
		}

		ListNode head = null;
		ListNode pre = null;
		ListNode cur = null;
		ListNode tail = null;

		while (ls != le.next && rs != re.next) {
			if (ls.val <= rs.val) {
				cur = ls;
				ls = ls.next;
			} else {
				cur = rs;
				rs = rs.next;
			}
			if (pre == null) {
				head = cur;
				pre = cur;
			} else {
				pre.next = cur;
				pre = cur;
			}
		}
		if (ls != le.next) {
			while (ls != le.next) {

				pre.next = ls;
				pre = ls;
				tail = ls;
				ls = ls.next;
			}
		} else {
			while (rs != re.next) {
				pre.next = rs;
				pre = rs;
				tail = rs;
				rs = rs.next;
			}
		}
		return new ListNode[] { head, tail };
	}










	public static class ListNode {
		int val;
		ListNode next;
		public ListNode(int v) {
			val = v;
		}
	}















}
