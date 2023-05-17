package topinterviewquestions;
//如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
//字母和数字都属于字母数字字符。
//给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。

//示例 1：
//输入: s = "A man, a plan, a canal: Panama"
//输出：true
//解释："amanaplanacanalpanama" 是回文串。

//示例 2：
//输入：s = "race a car"
//输出：false
//解释："raceacar" 不是回文串。
//链接：https://leetcode.cn/problems/valid-palindrome
public class Problem_0125_ValidPalindrome {
//是回文
	public static boolean isPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}

		char[] str = s.toCharArray();
		int L = 0;
		int R = str.length - 1;


		while (L < R) {
			if (validChar(str[L]) && validChar(str[R])) {
				if (!equalMy(str[L], str[R])) {
					return false;
				}
				L++;
				R--;
			} else {
				L += validChar(str[L]) ? 0 : 1;
				R -= validChar(str[R]) ? 0 : 1;
			}
		}
		return true;
	}




	//
	public static boolean validChar(char c) {
		return isLetter(c) || isNumber(c);
	}

	public static boolean equalMy(char c1, char c2) {
		if (isNumber(c1) || isNumber(c2)) {
			return c1 == c2;
		}
		return (c1 == c2) || (Math.max(c1, c2) - Math.min(c1, c2) == 32);
	}


	public static boolean isLetter(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
	}

	public static boolean isNumber(char c) {
		return (c >= '0' && c <= '9');
	}

}
