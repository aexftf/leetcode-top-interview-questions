package topinterviewquestions;
//请你来实现一个myAtoi(string s)函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
//
//函数myAtoi(string s) 的算法如下：
//1读入字符串并丢弃无用的前导空格
//2检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
//3读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
//将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
//如果整数数超过 32 位有符号整数范围 [−231, 231− 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231− 1 的整数应该被固定为 231− 1 。
//返回整数作为最终结果。
//注意：
//本题中的空白字符只包括空格字符 ' ' 。
//除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。

//示例1：
//输入：s = "42"
//输出：42
//解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
//第 1 步："42"（当前没有读入字符，因为没有前导空格）
//         ^
//第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
//         ^
//第 3 步："42"（读入 "42"）
//           ^
//解析得到整数 42 。
//由于 "42" 在范围 [-231, 231 - 1] 内，最终结果为 42 。

//示例2：
//输入：s = "   -42"
//输出：-42
//解释：
//第 1 步："   -42"（读入前导空格，但忽视掉）
//            ^
//第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
//             ^
//第 3 步："   -42"（读入 "42"）
//               ^
//解析得到整数 -42 。
//由于 "-42" 在范围 [-231, 231 - 1] 内，最终结果为 -42 。

//示例3：
//输入：s = "4193 with words"
//输出：4193
//解释：
//第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
//         ^
//第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
//         ^
//第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
//             ^
//解析得到整数 4193 。
//
public class Problem_0008_StringToInteger {


//确地说，这是确定有限状态机（deterministic finite automaton, DFA）。
// 其实这题已经不算是容易写“出臃肿代码”的了。
// 考虑清楚边界（主要是溢出处理）和输入种类（+, -, 0-9以及其他），大概在20行内完成代码不难。
// 说实话LC官方题解里很少见给出标准DFA解法的，点个赞。
// 另外看到评论区乌烟瘴气的，真让人唏嘘（没有一点基本的敬畏心、浮躁功利、认为题目边界太复杂导致自己不能AC，那是何其自负）。
// 给两个更加需要DFA的题目吧：utf-8-validation ( 附dfa解法 ) 以及 valid-number。 顺便贴一下普通解法（那种臃肿的、易错的、可能会被test cases虐到骂娘的；但如果骂娘了，本质还是基本功不扎实）。


	public int myAtoi(String str) {
		str = str.trim();
		if (str.length() == 0) return 0;
		if (!Character.isDigit(str.charAt(0))
				&& str.charAt(0) != '-' && str.charAt(0) != '+')
			return 0;

		long ans = 0L;
		boolean neg = str.charAt(0) == '-';
		int i = !Character.isDigit(str.charAt(0)) ? 1 : 0;

		while (i < str.length() && Character.isDigit(str.charAt(i))) {
			ans = ans * 10 + (str.charAt(i++) - '0');

			if (!neg && ans > Integer.MAX_VALUE) {
				ans = Integer.MAX_VALUE;
				break;
			}

			if (neg && ans > 1L + Integer.MAX_VALUE) {
				ans = 1L + Integer.MAX_VALUE;//1L
				break;
			}
		}
		return neg ? (int) -ans : (int) ans;
	}






















	public static int myAtoi1(String s) {
		//过滤
		if (s == null || s.equals("")) {
			return 0;
		}

		s = removeHeadZero(s.trim());

		if (s == null || s.equals("")) {
			return 0;
		}

		char[] str = s.toCharArray();
		if (!isValid(str)) {
			return 0;
		}



		// str 是符合日常书写的，正经整数形式
		boolean posi = str[0] == '-' ? false : true;

		int minq = Integer.MIN_VALUE / 10;
		int minr = Integer.MIN_VALUE % 10;
		int res = 0;
		int cur = 0;

		for (int i = (str[0]   == '-' || str[0] == '+') ? 1 : 0; i < str.length; i++) {
			cur = '0' - str[i];

			if ((res < minq) || (res == minq && cur < minr)) {
				return posi ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			res = res * 10 + cur;
		}

		// res 负
		if (posi && res == Integer.MIN_VALUE) {
			return Integer.MAX_VALUE;
		}
		return posi ? -res : res;
	}









	public static String removeHeadZero(String str) {
		boolean r = (str.startsWith("+") || str.startsWith("-"));
		int s = r ? 1 : 0;

		for (; s < str.length(); s++) {
			if (str.charAt(s) != '0') {
				break;
			}
		}
		// s 到了第一个不是'0'字符的位置
		int e = -1;
		// 左<-右
		for (int i = str.length() - 1; i >= (r ? 1 : 0); i--) {
			if (str.charAt(i) < '0' || str.charAt(i) > '9') {
				e = i;
			}
		}
		// e 到了最左的 不是数字字符的位置
		return (r ? String.valueOf(str.charAt(0)) : "") + str.substring(s, e == -1 ? str.length() : e);
	}





	public static boolean isValid(char[] chas) {
		if (chas[0] != '-' && chas[0] != '+' && (chas[0] < '0' || chas[0] > '9')) {
			return false;
		}

		if ((chas[0] == '-' || chas[0] == '+') && chas.length == 1) {
			return false;
		}

		// 0 +... -... num
		for (int i = 1; i < chas.length; i++) {
			if (chas[i] < '0' || chas[i] > '9') {
				return false;
			}
		}
		return true;
	}























}
