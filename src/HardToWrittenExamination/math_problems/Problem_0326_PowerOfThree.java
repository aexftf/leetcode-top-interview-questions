package math_problems;
//只有笔试会考
public class Problem_0326_PowerOfThree {

	// 如果一个数字是3的某次幂，那么这个数一定只含有3这个质数因子
	// 1162261467是int型范围内，最大的3的幂，它是3的19次方
	// 这个1162261467只含有3这个质数因子，如果n也是只含有3这个质数因子，那么
	// 1162261467 % n == 0
	public static boolean isPowerOfThree(int n) {
		return (n > 0 && 1162261467 % n == 0);
	}

}
