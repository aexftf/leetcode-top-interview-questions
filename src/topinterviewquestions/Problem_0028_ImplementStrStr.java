package topinterviewquestions;
//28. 找出字符串中第一个匹配项的下标
public class Problem_0028_ImplementStrStr {
//给你两个字符串 haystack 和 needle ，
// 请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
// 如果needle 不是 haystack 的一部分，则返回-1 。

//示例 1：
//
//输入：haystack = "sadbutsad", needle = "sad"
//输出：0
//解释："sad" 在下标 0 和 6 处匹配。
//第一个匹配项的下标是 0 ，所以返回 0 。

//示例 2：
//输入：haystack = "leetcode", needle = "leeto"
//输出：-1
//解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。


//暴力解
	public int strStr1(String haystack, String needle) {
		int n = haystack.length(), m = needle.length();

		for (int i = 0; i + m <= n; i++) {
			boolean flag = true;
			for (int j = 0; j < m; j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				return i;
			}
		}
		return -1;
	}






	//

	public static int strStr(String haystack, String needle) {
		return getIndexOf(haystack, needle);
	}

	public static int getIndexOf(String s, String m) {
		if (s == null || m == null || s.length() < m.length()) {
			return -1;
		}

		if (m.length() == 0) {
			return 0;
		}

		char[] str1 = s.toCharArray();
		char[] str2 = m.toCharArray();

		int x = 0;
		int y = 0;

		int[] next = getNextArray(str2);

		while (x < str1.length && y < str2.length) {
			if (str1[x] == str2[y]) {
				x++;
				y++;
			} else if (next[y] == -1) {
				x++;
			} else {
				y = next[y];
			}
		}
		return y == str2.length ? x - y : -1;
	}

	public static int[] getNextArray(char[] ms) {
		if (ms.length == 1) {
			return new int[] { -1 };
		}

		int[] next = new int[ms.length];

		next[0] = -1;
		next[1] = 0;
		int i = 2;

		// cn代表，cn位置的字符，是当前和i-1位置比较的字符
		int cn = 0;

		while (i < next.length) {
			if (ms[i - 1] == ms[cn]) {
				next[i++] = ++cn;
			} else if (cn > 0) {
				cn = next[cn];
			} else {
				next[i++] = 0;
			}
		}

		return next;
	}


}
