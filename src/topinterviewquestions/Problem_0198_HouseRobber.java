package topinterviewquestions;
//不敢连续偷的房屋大盗
public class Problem_0198_HouseRobber {

//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
//给定一个代表每个房屋存放金额的非负整数数组，计算你不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

//示例 1：
//输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//偷窃到的最高金额 = 1 + 3 = 4 。

//示例 2：
//输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
// 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
//链接：https://leetcode.cn/problems/house-robber
	public static int rob(int[] nums) {    //dp[]是结果集
		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return nums[0];
		}

		int N = nums.length;

		int[] dp = new int[N];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);

		for (int i = 2; i < N; i++) {
			dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);//
		}
		return dp[N - 1];
	}














	public static int rob2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int pre2 = nums[0];
		int pre1 = Math.max(nums[0], nums[1]);

		for (int i = 2; i < nums.length; i++) {
			int cur = Math.max(pre1, nums[i] + pre2);
			pre2 = pre1;
			pre1 = cur;
		}
		return pre1;
	}

}
