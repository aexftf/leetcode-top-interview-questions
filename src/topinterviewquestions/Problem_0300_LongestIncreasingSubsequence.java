package topinterviewquestions;
//300. 最长递增子序列
public class Problem_0300_LongestIncreasingSubsequence {
//给你一个整数数组 nums ，找到其中最长严格递增 《子序列》（不是子串） 的长度。
//子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。

	//示例 1：
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。

	//示例 2：
//输入：nums = [0,1,0,3,2,3]
//输出：4
//链接：https://leetcode.cn/problems/longest-increasing-subsequence




	public int lengthOfLIS(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		dp[0] = 1;
		int maxans = 1;

		for (int i = 1; i < nums.length; i++) {
			dp[i] = 1;

			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {  //就算大，加一也根本够不到
					dp[i] = Math.max(dp[i], dp[j] + 1);//前几次虚谎一枪最后一次才做改变
				}
			}
			maxans = Math.max(maxans, dp[i]);
		}

		return maxans;
	}



	//===============================================================================


	public static int lengthOfL(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}

		int[] ends = new int[arr.length];
		ends[0] = arr[0];
		int right = 0;

		int l = 0;
		int r = 0;
		int m = 0;
		int max = 1;

		for (int i = 1; i < arr.length; i++) {
			l = 0;
			r = right;

			while (l <= r) {
				m = (l + r) / 2;
				if (arr[i] > ends[m]) {
					l = m + 1;
				} else {
					r = m - 1;
				}
			}

			right = Math.max(right, l);
			ends[l] = arr[i];
			max = Math.max(max, l + 1);
		}
		return max;
	}


}
