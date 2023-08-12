package topinterviewquestions;

public class Problem_0062_UniquePaths {
//个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
//
//机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
//
//问总共有多少条不同的路径？


//我们令 dp[i][j] 是到达 i, j 最多路径
//
//动态方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
//
//注意，对于第一行 dp[0][j]，或者第一列 dp[i][0]，由于都是在边界，所以只能为 1
	//这是个杨辉三角形，每个位置的路径 = 该位置左边的路径 + 该位置上边的路径
		public int uniquePaths(int m, int n) {
			//初始化
			int[][] dp = new int[m][n];
			for (int i = 0; i < n; i++) dp[0][i] = 1;
			for (int i = 0; i < m; i++) dp[i][0] = 1;


			//计算路径数
			for (int i = 1; i < m; i++) {
				for (int j = 1; j < n; j++) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}

			return dp[m - 1][n - 1];
		}






















	//高中数组鹅，最短路径fuck，求背过本题
	public static int uniquePaths1(int m, int n) {
		int part = n - 1;
		int all = m + n - 2;
		long o1 = 1;
		long o2 = 1;

		//求阶乘
		for (int i = part + 1, 	j=1;   i <= all || j <= all - part;  i++,j++) {
			o1 *= i;
			o2 *= j;

			//防止溢出，求最大公约数。
			long gcd = gcd(o1,o2);
			o1 /= gcd;
			o2 /= gcd;
		}
		return (int)o1;
	}
	
	// 调用的时候，请保证初次调用时，m和n都不为0：辗转相除法
	public static long gcd(long m, long n) {
		return n == 0 ? m : gcd(n, m % n);
	}

}
