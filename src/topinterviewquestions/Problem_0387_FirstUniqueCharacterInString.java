package topinterviewquestions;
//定一个字符串s，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1。

//示例 1：
//输入: s = "leetcode"
//输出: 0

//示例 2:
//输入: s = "loveleetcode"
//输出: 2

public class Problem_0387_FirstUniqueCharacterInString {
//firstUniqChar
	public int firstUniqChar(String s) {

		char[] str = s.toCharArray();
		int N = str.length;
		int count[] = new int[26];

		for (int i = 0; i < N; i++) {
			count[str[i] - 'a']++;//当map用
		}

		for (int i = 0; i < N; i++) {
			if (count[str[i] - 'a'] == 1) {
				return i;
			}
		}
		return -1;
	}


}
