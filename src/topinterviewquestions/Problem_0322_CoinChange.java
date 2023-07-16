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




//可以看做是爬楼梯的进阶版
public class Problem_0322_CoinChange {


	//递归（超时）
	int res = Integer.MAX_VALUE;
	public int coinChange1(int[] coins, int amount) {
		if(coins.length == 0){
			return -1;
		}

		findWay(coins,amount,0);

		// 如果没有任何一种硬币组合能组成总金额，返回 -1。
		if(res == Integer.MAX_VALUE){
			return -1;
		}
		return res;
	}



	public void findWay(int[] coins,int amount,int count){
		if(amount < 0){
			return;
		}
		if(amount == 0){
			res = Math.min(res,count);
		}

		for(int i = 0;i < coins.length;i++){
			findWay(coins,amount-coins[i],count+1);
		}
	}



	//记忆化搜索
	int[] memo;
	public int coinChange(int[] coins, int amount) {
		if(coins.length == 0){
			return -1;
		}
		memo = new int[amount];

		return findWay(coins,amount);
	}
	// memo[n] 表示钱币n可以被换取的最少的硬币数，不能换取就为-1
	// findWay函数的目的是为了找到 amount数量的零钱可以兑换的最少硬币数量，返回其值int
	public int findWay(int[] coins,int amount){
		if(amount < 0){
			return -1;
		}
		if(amount == 0){
			return 0;
		}
		// 记忆化的处理，memo[n]用赋予了值，就不用继续下面的循环
		// 直接的返回memo[n] 的最优值
		if(memo[amount-1] != 0){
			return memo[amount-1];
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0;i < coins.length;i++){
			int res = findWay(coins,amount-coins[i]);
			if(res >= 0 && res < min){
				min = res + 1; // 加1，是为了加上得到res结果的那个步骤中，兑换的一个硬币
			}
		}
		memo[amount-1] = (min == Integer.MAX_VALUE ? -1 : min);
		return memo[amount-1];
	}












	public int coinChange3(int[] coins, int amount) {
		// 自底向上的动态规划
		if(coins.length == 0){
			return -1;
		}

		// memo[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
		int[] memo = new int[amount+1];
		memo[0] = 0;
		for(int i = 1; i <= amount;i++){

			int min = Integer.MAX_VALUE;

			for(int j = 0;j < coins.length;j++){
				if(i - coins[j] >= 0 && memo[i-coins[j]] < min){
					min = memo[i-coins[j]] + 1;
				}
			}
			// memo[i] = (min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min);
			memo[i] = min;
		}

		return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
	}











//
//	//i是硬币面值
//	//j是要拼凑成的金额
//	//dp是硬币个数
//	public static int coinChange3(int[] coins, int amount) {
//		if (coins == null || coins.length == 0 || amount < 0) {
//			return -1;
//		}
//		int N = coins.length;
//		int[][] dp = new int[N + 1][amount + 1];
//
//		for (int col = 1; col <= amount; col++) {
//			dp[N][col] = -1;
//		}
//
//		for (int i = N - 1; i >= 0; i--) {
//			for (int rest = 0; rest <= amount; rest++) {
//				dp[i][rest] = -1;
//
//				if (dp[i + 1][rest] != -1) {
//					dp[i][rest] = dp[i + 1][rest];
//				}
//
//				if (rest - coins[i] >= 0 && dp[i][rest - coins[i]] != -1) {
//					if (dp[i][rest] == -1) {
//						dp[i][rest] = dp[i][rest - coins[i]] + 1;
//					} else {
//						dp[i][rest] = Math.min(dp[i][rest], dp[i][rest - coins[i]] + 1);
//					}
//
//				}
//
//			}
//		}
//
//		return dp[0][amount];
//	}
//






	//---------------------------------


}
