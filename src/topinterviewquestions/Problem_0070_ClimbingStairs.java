package topinterviewquestions;

public class Problem_0070_ClimbingStairs {


//标签：动态规划
//本问题其实常规解法可以分成多个子问题，爬第n阶楼梯的方法数量，等于 2 部分之和
//爬上
//n−1 阶楼梯的方法数量。因为再爬1阶就能到第n阶
//爬上
//n−2 阶楼梯的方法数量，因为再爬2阶就能到第n阶
//所以我们得到公式
//dp[n]=dp[n−1]+dp[n−2]
//同时需要初始化
//dp[0]=1 和
//dp[1]=1
//时间复杂度：
//O(n)
	public int climbStairs1(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}


	public int climbStairs2(int n) {
		int p = 0, q = 0, r = 1;
		for (int i = 1; i <= n; ++i) {
			p = q;
			q = r;
			r = p + q;
		}
		return r;
	}












//
//    public static int climbStairs(int n) {
//		if (n < 1) {
//			return 0;
//		}
//		if (n == 1 || n == 2) {
//			return n;
//		}
//		int[][] base = { { 1, 1 }, { 1, 0 } };
//		int[][] res = matrixPower(base, n - 2);
//		return 2 * res[0][0] + res[1][0];
//	}
//
//	public static int[][] matrixPower(int[][] m, int p) {
//		int[][] res = new int[m.length][m[0].length];
//		for (int i = 0; i < res.length; i++) {
//			res[i][i] = 1;
//		}
//
//		// res = 矩阵中的1
//		int[][] tmp = m;// 矩阵1次方
//		for (; p != 0; p >>= 1) {
//			if ((p & 1) != 0) {
//				res = muliMatrix(res, tmp);
//			}
//			tmp = muliMatrix(tmp, tmp);
//		}
//		return res;
//	}
//
//	// 两个矩阵乘完之后的结果返回
//	public static int[][] muliMatrix(int[][] m1, int[][] m2) {
//		int[][] res = new int[m1.length][m2[0].length];
//
//		for (int i = 0; i < m1.length; i++) {
//			for (int j = 0; j < m2[0].length; j++) {
//				for (int k = 0; k < m2.length; k++) {
//					res[i][j] += m1[i][k] * m2[k][j];
//				}
//			}
//		}
//		return res;
//	}
//
//








}

