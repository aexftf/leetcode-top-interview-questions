package topinterviewquestions;

public class Problem_0204_CountPrimes {
//质数个数
	//给定整数 n ，返回 所有小于非负整数n的质数的数量 。

//示例 1：
//输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。

//示例 2：
//输入：n = 0
//输出：0

	//示例 3：
//输入：n = 1
//输出：0

	//https://leetcode.cn/problems/count-primes/solution/ji-shu-zhi-shu-by-leetcode-solution/




	public int countPrimes(int n) {
		int ans = 0;
		for (int i = 2; i < n; ++i) {
			ans += isPrime(i) ? 1 : 0;
		}
		return ans;
	}

	public boolean isPrime(int x) {
		for (int i = 2; i * i <= x; ++i) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}

//	链接：https://leetcode.cn/problems/count-primes/solutions/507273/ji-shu-zhi-shu-by-leetcode-solution/














	public static int countPrimes1(int n) {// 6为例    2，4，6干掉   1，3，5剩下计数
		if (n < 3) {
			return 0;
		}
		boolean[] f = new boolean[n];

		//2的倍数肯定不是，先干掉一半
		int count = n / 2;

		//只有这些才有可能是
		for (int i = 3; i * i < n; i += 2) {
			if (f[i]) {
				continue;
			}
			for (int j = i * i; j < n; j += 2 * i) {
				if (!f[j]) {
					--count;
					f[j] = true;
				}
			}

		}
		return count;
	}

}
