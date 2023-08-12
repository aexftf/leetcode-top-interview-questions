package topinterviewquestions;
//给你一个整数数组 nums，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//测试用例的答案是一个32-位 整数。
//子数组 是数组的连续子序列。

//输入: nums = [2,3,-2,4]
//输出: 6
//解释:子数组 [2,3] 有最大乘积 6。

//示例 2:
//输入: nums = [-2,0,-1]
//输出: 0
//解释:结果不能为 2, 因为 [-2,-1] 不是子数组。
//https://leetcode.cn/problems/maximum-product-subarray
public class Problem_0152_MaximumProductSubarray {



	public static int maxProduct(int[] nums) {
		int ans = nums[0];
		int min = nums[0];
		int max = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int curmin = Math.min(nums[i], Math.min(min * nums[i], max * nums[i]));//可能负负得正
			int curmax = Math.max(nums[i], Math.max(min * nums[i], max * nums[i]));

			min = curmin;
			max = curmax;
			ans  = Math.max(ans, max);
		}
		return ans;
	}




}
