package topinterviewquestions;

public class Problem_0053_MaximumSubarray {
//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//子数组 是数组中的一个连续部分。

//示例 1：
//
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组[4,-1,2,1] 的和最大，为6 。





	//
	public static int maxSubArray(int[] nums) {
		int cur = 0;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			cur += nums[i];
			max = Math.max(max, cur);
			cur = cur < 0 ? 0 : cur;
		}
		return max;
	}








	//动态规划版本，没意思
	public static int maxSum(int[] nums) {
		int N = nums.length;
		// dp[i] 含义：子数组必须以i结尾的时候，所有可以得到的子数组中，最大累加和是多少？
		int[] dp = new int[N];
		dp[0] = nums[0];
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < N; i++) {
			int p1 = nums[i];
			int p2 = nums[i] + dp[i - 1];
			dp[i] = Math.max(p1, p2);
			max = Math.max(max, dp[i]);
		}
		return max;
	}









}
