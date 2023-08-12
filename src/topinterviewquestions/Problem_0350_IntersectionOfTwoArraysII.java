package topinterviewquestions;

import java.util.ArrayList;
import java.util.HashMap;
//给你两个整数数组nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
//示例 1：
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
//示例 2:
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9]
public class Problem_0350_IntersectionOfTwoArraysII {
//由于同一个数字在两个数组中都可能出现多次，因此需要用哈希表存储每个数字出现的次数。对于一个数字，其在交集中出现的次数等于该数字在两个数组中出现次数的最小值。
//
//首先遍历第一个数组，并在哈希表中记录第一个数组中的每个数字以及对应出现的次数，然后遍历第二个数组，对于第二个数组中的每个数字，如果在哈希表中存在这个数字，则将该数字添加到答案，并减少哈希表中该数字出现的次数。
//
//为了降低空间复杂度，首先遍历较短的数组并在哈希表中记录每个数字以及对应出现的次数，然后遍历较长的数组得到交集。
	public static int[] intersect(int[] nums1, int[] nums2) {

		HashMap<Integer, Integer> map1 = new HashMap<>();

		for (int num : nums1) {
			if (!map1.containsKey(num)) {
				map1.put(num, 1);
			} else {
				map1.put(num, map1.get(num) + 1);
			}
		}

		HashMap<Integer, Integer> map2 = new HashMap<>();

		for (int num : nums2) {
			if (!map2.containsKey(num)) {
				map2.put(num, 1);
			} else {
				map2.put(num, map2.get(num) + 1);
			}
		}

		ArrayList<Integer> list = new ArrayList<>();

		for (int key : map1.keySet()) {
			if (map2.containsKey(key)) {
				int n = Math.min(map1.get(key), map2.get(key));

				for (int i = 0; i < n; i++) {
					list.add(key);
				}
			}
		}

		int[] ans = new int[list.size()];

		for (int i = 0; i < ans.length; i++) {
			ans[i] = list.get(i);
		}
		return ans;
	}




}
