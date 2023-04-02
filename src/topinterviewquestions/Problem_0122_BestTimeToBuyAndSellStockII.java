package topinterviewquestions;

public class Problem_0122_BestTimeToBuyAndSellStockII {





//	终于碰到个简单题，简单题搞啥动态规划啊，99%
//
//	因为交易次数不受限，如果可以把所有的上坡全部收集到，一定是利益最大化的

	public int maxProfit(int[] arr) {
		if (arr == null || arr.length <= 1) return 0;

		int ans = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i-1]) {  // 卖出有利可图
				ans += (arr[i] - arr[i-1]);
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
