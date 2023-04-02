package topinterviewquestions;

public class Problem_0204_CountPrimes {
//质数个数
	public static int countPrimes(int n) {
		if (n < 3) {
			return 0;
		}
		boolean[] f = new boolean[n];

		//2的倍数肯定不是
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
