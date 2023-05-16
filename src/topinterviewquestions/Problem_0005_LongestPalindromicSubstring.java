package topinterviewquestions;

public class Problem_0005_LongestPalindromicSubstring {

//最长的回文子串


	//暴力递归
	public String longestPalindrome1(String s) {
		int len = s.length();
		if (len < 2) {
			return s;
		}

		int maxlen=1;
		int begin = 0;

		char[] chars = s.toCharArray();

		for (int i = 0; i <chars.length-1 ; i++) {
			for (int j = i+1; j <chars.length ; j++) {
				boolean vilide = isVilide(chars, i, j);
				if (j-i+1>maxlen && vilide){
					maxlen = Math.max(maxlen, j-i+1);
					begin=i;
				}
			}

		}

		return s.substring(begin,begin+maxlen);
//1,2,3,4
	}

	private boolean isVilide(char[] chars, int l, int r) {
		for (int i = 0; i < chars.length-1; i++) {
			if (chars[i] == chars[r]){
				return true;
			}
			l++;
			r--;
		}
		return false;
	}










	//动态规划
	public String longestPalindrome2(String s) {
		int len = s.length();
		if (len < 2) {
			return s;
		}

		int maxLen = 1;
		int begin = 0;

		// dp[i][j] 表示 s[i..j] 是否是回文串
		boolean[][] dp = new boolean[len][len];

		// 初始化：所有长度为 1 的子串都是回文串
		for (int i = 0; i < len; i++) {
			dp[i][i] = true;
		}

		char[] charArray = s.toCharArray();

		// 递推开始
		// 先枚举子串长度
		for (int L = 2; L <= len; L++) {
			// 枚举左边界，左边界的上限设置可以宽松一些
			for (int i = 0; i < len; i++) {
				// 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
				int j = L + i - 1;
				// 如果右边界越界，就可以退出当前循环
				if (j >= len) {
					break;
				}

				if (charArray[i] != charArray[j]) {
					dp[i][j] = false;
				} else {
					if (j - i < 3) {
						dp[i][j] = true;
					} else {
						dp[i][j] = dp[i + 1][j - 1];
					}
				}

				// 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
				if (dp[i][j] && j - i + 1 > maxLen) {
					maxLen = j - i + 1;
					begin = i;
				}
			}
		}
		return s.substring(begin, begin + maxLen);
	}

















//		//	manacher
//	public static String longestPalindrome(String str) {
//		if (str == null || str.length() == 0) {
//			return "";
//		}
//
//		char[] charArr = manacherString(str);
//		int[] pArr = new int[charArr.length];
//
//		int index = -1;
//		int pR = -1;
//		int max = Integer.MIN_VALUE;
//		int mid = 0;
//
//		for (int i = 0; i != charArr.length; i++) {
//			pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
//
//			while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
//
//				if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
//					pArr[i]++;
//				else {
//					break;
//				}
//			}
//			if (i + pArr[i] > pR) {
//				pR = i + pArr[i];
//				index = i;
//			}
//
//			if (max < pArr[i]) {
//				max = pArr[i];
//				mid = i;
//			}
//		}
//		mid = (mid - 1) / 2;
//		max = max - 1;
//
//		return str.substring((max & 1) == 0 ? mid - (max / 2) + 1 : mid - (max / 2), mid + (max / 2) + 1);
//	}
//
//
//
//
//	public static char[] manacherString(String str) {
//		char[] charArr = str.toCharArray();
//		char[] res = new char[str.length() * 2 + 1];
//		int index = 0;
//		for (int i = 0; i != res.length; i++) {
//			res[i] = (i & 1) == 0 ? '#' : charArr[index++];
//		}
//		return res;
//	}

}
