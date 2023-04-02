package topinterviewquestions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Problem_0347_TopKFrequentElements {
	//重点题，一种思路两种实现：排序直接调快排，或者用堆排。
	public static class Node {
		public int num;
		public int count;

		public Node(int k) {
			num = k;
			count = 1;
		}
	}

	public static class CountComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			return o1.count - o2.count;//小根堆
		}

	}

	public static int[] topKFrequent(int[] nums, int k) {

		HashMap<Integer, Node> map = new HashMap<>();

		for (int num : nums) {
			if (!map.containsKey(num)) {
				map.put(num, new Node(num));
			} else {
				map.get(num).count++;
			}
		}
		PriorityQueue<Node> heap = new PriorityQueue<>(new CountComparator());

		for (Node node : map.values()) {
			if (heap.size() < k || (heap.size() == k && node.count > heap.peek().count)) {
				heap.add(node);
			}
			if (heap.size() > k) {
				heap.poll();
			}
		}

		int[] ans = new int[k];
		int index = 0;
		while (!heap.isEmpty()) {
			ans[index++] = heap.poll().num;
		}
		return ans;
	}

}
