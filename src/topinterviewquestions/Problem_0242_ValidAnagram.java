package topinterviewquestions;
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。

//示例1:
//输入: s = "anagram", t = "nagaram"
//输出: true
//示例 2:
//输入: s = "rat", t = "car"
//输出: false
//链接：https://leetcode.cn/problems/valid-anagram
public class Problem_0242_ValidAnagram {

	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		char[] str = s.toCharArray();
		char[] tar = t.toCharArray();
		int[] count = new int[256];

		for (char cha : str) {
			count[cha]++;
		}

		for (char cha : tar) {
			if (--count[cha] < 0) {//  --操作符  操作前先做减法
				return false;
			}
		}
		return true;
	}




}
