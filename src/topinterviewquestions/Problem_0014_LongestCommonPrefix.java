package topinterviewquestions;

public class Problem_0014_LongestCommonPrefix {
//编写一个函数来查找字符串数组中的最长公共前缀。
//注意是全部字符的公共前缀，不是部分符号串的。
//如果不存在公共前缀，返回空字符串 ""。
	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		char[] chs = strs[0].toCharArray();
		int min = Integer.MAX_VALUE;

		for (String str : strs) {
			char[] tmp = str.toCharArray();
			int index = 0;//又变成0了

			while (index < tmp.length && index < chs.length) {
				if (chs[index] != tmp[index]) {
					break;
				}
				index++;
			}
		//注意是全部字符的公共前缀，不是部分符号串的。就算两个相等的也没用。
			min = Math.min(index, min);
			if (min == 0) {
				return "";
			}
		}
		return strs[0].substring(0, min);
	}

}
