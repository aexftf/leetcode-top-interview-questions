package topinterviewquestions;
//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
//
//计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
//
//你可以认为每种硬币的数量是无限的。

//示例1：
//输入：coins = [1, 2, 5], amount = 11
//输出：3
//解释：11 = 5 + 5 + 1

//示例 2：
//输入：coins = [2], amount = 3
//输出：-1

//示例 3：
//输入：coins = [1], amount = 0
//输出：0
//https://leetcode.cn/problems/coin-change
public class Problem_0322_CoinChange {

	//i是硬币面值
	//j是要拼凑成的金额
	//dp是硬币个数
	public static int coinChange1(int[] coins, int amount) {
		if (coins == null || coins.length == 0 || amount < 0) {
			return -1;
		}
		int N = coins.length;
		int[][] dp = new int[N + 1][amount + 1];

		for (int col = 1; col <= amount; col++) {
			dp[N][col] = -1;
		}

		for (int i = N - 1; i >= 0; i--) {
			for (int rest = 0; rest <= amount; rest++) {
				dp[i][rest] = -1;

				if (dp[i + 1][rest] != -1) {
					dp[i][rest] = dp[i + 1][rest];
				}

				if (rest - coins[i] >= 0 && dp[i][rest - coins[i]] != -1) {
					if (dp[i][rest] == -1) {
						dp[i][rest] = dp[i][rest - coins[i]] + 1;
					} else {
						dp[i][rest] = Math.min(dp[i][rest], dp[i][rest - coins[i]] + 1);
					}
				}
			}
		}
		return dp[0][amount];
	}







}
