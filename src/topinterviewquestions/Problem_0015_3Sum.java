package topinterviewquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class

//三数之和
//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
//你返回所有和为 0 且不重复的三元组。
//注意：答案中不可以包含重复的三元组。

//示例 1：
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
Problem_0015_3Sum {

	public static List<List<Integer>> threeSum1(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> ans = new ArrayList<>();

		// 第一个数选了i位置的数
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || nums[i - 1] != nums[i]) {

				List<List<Integer>> nexts = twoSum1(nums, i + 1, -nums[i]);
				for (List<Integer> cur : nexts) {
					cur.add(0, nums[i]);//凑三个数
					ans.add(cur);//三个数，添加上。
				}

			}
		}
		return ans;
	}

	// nums已经有序了
	// nums[begin......]范围上，找到累加和为target的所有二元组
	public static List<List<Integer>> twoSum1(int[] nums, int begin, int target) {
		int L = begin;
		int R = nums.length - 1;
		List<List<Integer>> ans = new ArrayList<>();

		while (L < R) {
			if (nums[L] + nums[R] > target) {
				R--;
			} else if (nums[L] + nums[R] < target) {
				L++;
			} else {
				if (L == begin || nums[L - 1] != nums[L]) {
					List<Integer> cur = new ArrayList<>();
					cur.add(nums[L]);
					cur.add(nums[R]);//凑2个数
					ans.add(cur);//凑2个数，并加上
				}
				L++;
			}
		}
		return ans;
	}







//=======-----------------------------------------------------------






	public static List<List<Integer>> threeSum2(int[] nums) {
		Arrays.sort(nums);
		int N = nums.length;
		List<List<Integer>> ans = new ArrayList<>();
		for (int i = N - 1; i > 1; i--) {
			if (i == N - 1 || nums[i] != nums[i + 1]) {
				List<List<Integer>> nexts = twoSum2(nums, i - 1, -nums[i]);
				for (List<Integer> cur : nexts) {
					cur.add(nums[i]);
					ans.add(cur);
				}
			}
		}
		return ans;
	}



	public static List<List<Integer>> twoSum2(int[] nums, int end, int target) {
		int L = 0;
		int R = end;
		List<List<Integer>> ans = new ArrayList<>();
		while (L < R) {
			if (nums[L] + nums[R] > target) {
				R--;
			} else if (nums[L] + nums[R] < target) {
				L++;
			} else {
				if (L == 0 || nums[L - 1] != nums[L]) {
					List<Integer> cur = new ArrayList<>();
					cur.add(nums[L]);
					cur.add(nums[R]);
					ans.add(cur);
				}
				L++;
			}
		}
		return ans;
	}

}
