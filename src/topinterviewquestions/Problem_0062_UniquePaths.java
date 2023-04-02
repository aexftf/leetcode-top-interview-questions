package topinterviewquestions;

public class Problem_0062_UniquePaths {


	//高中数组鹅，最短路径fuck，求背过本题
	public static int uniquePaths(int m, int n) {
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
