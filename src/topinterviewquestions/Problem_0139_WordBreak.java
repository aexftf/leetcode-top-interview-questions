package topinterviewquestions;

import java.util.HashSet;
import java.util.List;
//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
//注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。

//示例 1：
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。

//示例 2：
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//注意，你可以重复使用字典中的单词。
//链接：https://leetcode.cn/problems/word-break
public class Problem_0139_WordBreak {


//递归  直接返回几种，增加了难度属于是
	public static boolean wordBreak2(String s, List<String> wordDict) {
		return process(s, 0, new HashSet<>(wordDict)) != 0;
	}

	// s[0......index-1]这一段，已经分解过了，不用在操心
	// s[index.....] 这一段字符串，能够被分解的方法数，返回
	public static int process(String s, int index, HashSet<String> wordDict) {
		if (index == s.length()) {
			return 1;
		}
		// index没到最后
		// index...index
		// index...index+1
		// index....index+2
		// index....end
		int ways = 0;
		for (int end = index; end < s.length(); end++) {
			// s[index....end]
			String pre = s.substring(index, end + 1);

			if (wordDict.contains(pre)) {
				ways += process(s, end + 1, wordDict);
			}
		}
		return ways;
	}







	//=================================------------------------

	//动态规划
	public static boolean wordBreak(String s, List<String> wordDict) {
		Node root = new Node();

		for (String str : wordDict) {

			char[] chs = str.toCharArray();
			Node node = root;
			int index = 0;

			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';

				if (node.nexts[index] == null) {
					node.nexts[index] = new Node();
				}
				node = node.nexts[index];
			}
			node.end = true;
		}

		char[] str = s.toCharArray();
		int N = str.length;
		boolean[] dp = new boolean[N + 1];
		dp[N] = true;

		for (int i = N - 1; i >= 0; i--) {
			Node cur = root;

			for (int end = i; end < N; end++) {
				int path = str[end] - 'a';

				if (cur.nexts[path] == null) {
					break;
				}
				cur = cur.nexts[path];

				if (cur.end && dp[end + 1]) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[0];
	}












	public static class Node {
		public boolean end;
		public Node[] nexts;

		public Node() {
			end = false;
			nexts = new Node[26];
		}
	}


}
