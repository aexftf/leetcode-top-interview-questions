package topinterviewquestions;
//给定一个整数 n ，返回 n! 结果中尾随零的数量。
//
//提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
public class Problem_0172_FactorialTrailingZeroes {
//记住也可以,面试不考
	public static int trailingZeroes(int n) {
		int ans = 0;
		while (n != 0) {
			n /= 5;
			ans += n;
		}
		return ans;
	}

}
