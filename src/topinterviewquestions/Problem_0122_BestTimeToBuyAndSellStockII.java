package topinterviewquestions;

public class Problem_0122_BestTimeToBuyAndSellStockII {

//给你一个整数数组 prices ，其中prices[i] 表示某支股票第 i 天的价格。
//在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
//返回 你能获得的 最大 利润。

//示例 1：
//输入：prices = [7,1,5,3,6,4]
//输出：7
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
//随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
//总利润为 4 + 3 = 7 。

//示例 2：
//输入：prices = [1,2,3,4,5]
//输出：4
//解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
//  总利润为 4 。
//链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii

//	终于碰到个简单题，简单题搞啥动态规划啊，99%
//	因为交易次数不受限，如果可以把所有的上坡全部收集到，一定是利益最大化的

	public int maxProfit(int[] arr) {
		if (arr == null || arr.length <= 1) return 0;

		int ans = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i-1]) {  // 卖出有利可图
				ans += (arr[i] - arr[i-1]);//所有的    规律，和最大减去最小 一个结果。
			}
		}

		return ans;
	}










	public static int maxProfit1(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int ans = 0;
		for (int i = 1; i < prices.length; i++) {
            ans += Math.max(prices[i] - prices[i-1], 0);
		}
		return ans;
	}





}
