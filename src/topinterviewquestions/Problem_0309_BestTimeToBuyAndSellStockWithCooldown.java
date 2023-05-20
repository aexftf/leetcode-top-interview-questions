package topinterviewquestions;

public class Problem_0309_BestTimeToBuyAndSellStockWithCooldown {

	// 该方法是对的，提交之后大量的测试用例通过，最后几个会超时
	// 如果把这个方法改成动态规划，是可以通过的，但这个尝试不是最优解
	public static int maxProfit1(int[] prices) {
		return process1(prices, false, 0, 0);
	}

	// buy == false 目前可以交易，而且当前没有购买行为
	// buy == true 已经买了，买入价buyPrices，待卖出
	public static int process1(int[] prices, boolean buy, int index, int buyPrices) {
		if (index >= prices.length) {
			return 0;
		}

		if (buy) {
			int noSell = process1(prices, true, index + 1, buyPrices);
			int yesSell = prices[index] - buyPrices + process1(prices, false, index + 2, 0);

			return Math.max(noSell, yesSell);
		} else {
			int noBuy = process1(prices, false, index + 1, 0);
			int yesBuy = process1(prices, true, index + 1, prices[index]);

			return Math.max(noBuy, yesBuy);
		}
	}












//
//	// 最优解就是方法2的空间优化而已
//	public static int maxProfit3(int[] prices) {
//		if (prices.length < 2) {
//			return 0;
//		}
//
//		int buy1 = Math.max(-prices[0], -prices[1]);
//		int sell1 = Math.max(0, prices[1] - prices[0]);
//		int sell2 = 0;
//
//		for (int i = 2; i < prices.length; i++) {
//			int tmp = sell1;
//			sell1 = Math.max(sell1, buy1 + prices[i]);
//			buy1 = Math.max(buy1, sell2 - prices[i]);
//			sell2 = tmp;
//		}
//		return sell1;
//	}

}
