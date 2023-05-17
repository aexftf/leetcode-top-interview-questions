package topinterviewquestions;
//116. 填充每个节点的下一个右侧节点指针
//给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
//填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
//初始状态下，所有next 指针都被设置为 NULL。
//链接：https://leetcode.cn/problems/populating-next-right-pointers-in-each-node
public class Problem_0116_PopulatingNextRightPointersInEachNode {


	public static Node connect(Node root) {
		if (root == null) {
			return root;
		}

		MyQueue queue = new MyQueue();
		queue.offer(root);

		while (!queue.isEmpty()) {
			// 第一个弹出的节点
			Node pre = null;
			int size = queue.size;

			for (int i = 0; i < size; i++) {
				Node cur = queue.poll();

				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
				if (pre != null) {
					pre.next = cur;
				}
				pre = cur;
			}
		}
		return root;
	}







	public static class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;
	}

	public static class MyQueue {
		public Node head;
		public Node tail;
		public int size;

		public MyQueue() {
			head = null;
			tail = null;
			size = 0;
		}

		public boolean isEmpty() {
			return size == 0;
		}

		public void offer(Node cur) {

			size++;

			if (head == null) {
				head = cur;
				tail = cur;
			} else {
				tail.next = cur;
				tail = cur;
			}
		}

		public Node poll() {
			size--;
			Node ans = head;
			head = head.next;
			ans.next = null;
			return ans;
		}


	}





}
