package topinterviewquestions;
import java.util.HashMap;
//最长连续序列
public class Problem_0128_LongestConsecutiveSequence {
//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//请你设计并实现时间复杂度为O(n) 的算法解决此问题。

//示例 1：
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
//示例 2：
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
//链接：https://leetcode.cn/problems/longest-consecutive-sequence

		public static int longestConsecutive(int[] nums) {

		HashMap<Integer, Integer> map = new HashMap<>();
		int len = 0;

		for (int num : nums) {

			if (!map.containsKey(num)) {
				map.put(num, 1);

				int preLen = map.containsKey(num - 1) ? map.get(num - 1) : 0;
				int posLen = map.containsKey(num + 1) ? map.get(num + 1) : 0;
				int all = preLen + posLen + 1;

				map.put(num - preLen, all);
				map.put(num + posLen, all);
				len = Math.max(len, all);
			}
		}
		return len;
	}

}
