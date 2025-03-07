package topinterviewquestions;

public class Problem_0091_DecodeWays {
//条包含字母A-Z 的消息通过以下映射进行了 编码 ：
//'A' -> "1"
//'B' -> "2"
//...
//'Z' -> "26"
//要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
//"AAJF" ，将消息分组为 (1 1 10 6)
//"KJF" ，将消息分组为 (11 10 6)
//注意，消息不能分组为(1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
//给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数。
//题目数据保证答案肯定是一个 32 位 的整数。
//链接：https://leetcode.cn/problems/decode-ways
	public static int numDecodings1(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		char[] str = s.toCharArray();
		return process(str, 0);
	}


	// 潜台词：str[0...index-1]已经转化完了，不用操心了
	// str[index....] 能转出多少有效的，返回方法数
	public static int process(char[] str, int index) {
		if (index == str.length) {
			return 1;
		}
		//第一个是0，就完蛋了，必须有前面的数字带着。
		if (str[index] == '0') {
			return 0;
		}

		// index还有字符, 又不是‘0’

		int ways = process(str, index + 1);

		//  ....越界返回
		if (index + 1 == str.length) {
			return ways;
		}

		//  （index 1 ~ 9）index单独转，(index index + 1) -> index + 2 双转(index index + 1) "23" -> 23 "17" -> 17
		int num = (str[index] - '0') * 10 + str[index + 1] - '0';

		// num > 26越界返回
		if (num <= 26) {
			ways += process(str, index + 2);
		}

		return ways;
	}









	public static int numDecodings2(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		char[] str = s.toCharArray();
		int N = str.length;


		// dp[i] ->就是 process(str, index)的返回值 index 0 ~ N
		int[] dp = new int[N + 1];
		dp[N] = 1;

		// dp依次填好 dp[i] dp[i+1] dp[i+2]
		for (int i = N - 1; i >= 0; i--) {
			if (str[i] != '0') {
				dp[i] = dp[i + 1];

				if (i + 1 == str.length) {
					continue;
				}
				int num = (str[i] - '0') * 10 + str[i + 1] - '0';
				if (num <= 26) {
					dp[i] += dp[i + 2];
				}
			}
		}
		return dp[0];
	}

















}
