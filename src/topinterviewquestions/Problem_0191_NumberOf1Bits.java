package topinterviewquestions;

public class Problem_0191_NumberOf1Bits {
    
//编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
//提示：
//请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
//在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在示例 3中，输入表示有符号整数 -3。

	//示例 1：
//输入：n = 00000000000000000000000000001011
//输出：3
//解释：输入的二进制串 00000000000000000000000000001011中，共有三位为 '1'。

	//示例 2：
//输入：n = 00000000000000000000000010000000
//输出：1
//解释：输入的二进制串 00000000000000000000000010000000中，共有一位为 '1'。
//链接：https://leetcode.cn/problems/number-of-1-bits

//

	public int hammingWeight(int n) {
		int ret = 0;
		for (int i = 0; i < 32; i++) {
			if ((n & (1 << i)) != 0) {//检查每一位
				ret++;
			}
		}
		return ret;
	}










	public static int hammingWeight1(int n) {
		int bits = 0;
		int rightOne = 0;

		while(n != 0) {
			bits++;
			rightOne = n & (-n);
			n ^= rightOne;	
		}
		return bits;
	}

	
}
