package topinterviewquestions;
//347. 前 K 个高频元素
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。

//示例 1:
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
//示例 2:
//输入: nums = [1], k = 1
//输出: [1]

//https://leetcode.cn/problems/top-k-frequent-elements/solution/qian-k-ge-gao-pin-yuan-su-by-leetcode-solution/
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
			if (heap.size() > k) {  //[1,1,1,1,1,1,1,11,,11,1,1]
					heap.poll(); //拉小的出去
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
