package topinterviewquestions;

import java.util.HashMap;

//无重复字符的最长子串
//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
public class Problem_0003_LongestSubstringWithoutRepeatingCharacters {

	//这道题主要用到思路是：滑动窗口
	//什么是滑动窗口？
	//其实就是一个队列,比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，当再进入 a，队列变成了 abca，这时候不满足要求。所以，我们要移动这个队列！
	//如何移动？
	//我们只要把队列的左边的元素移出就行了，直到满足题目要求！
	//一直维持这样的队列，找出队列出现最长的长度时候，求出解！
	//时间复杂度：
	//O(n)

	//链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters/solution/hua-dong-chuang-kou-by-powcai/
	public int lengthOfLongestSubstring1(String s) {
		if (s.length()==0) return 0;
			HashMap<Character, Integer> map = new HashMap<>();
			int maxLen = 0;//用于记录最大不重复子串的长度
			int left = 0;//滑动窗口左指针
			for (int i = 0; i < s.length() ; i++)
			{
				/**
				 1、首先，判断当前字符是否包含在map中，如果不包含，将该字符添加到map（字符，字符在数组下标）,
				 此时没有出现重复的字符，左指针不需要变化。此时不重复子串的长度为：i-left+1，与原来的maxLen比较，取最大值；

				 2、如果当前字符 ch 包含在 map中，此时有2类情况：
				 1）当前字符包含在当前有效的子段中，如：abca，当我们遍历到第二个a，当前有效最长子段是 abc，我们又遍历到a，
				 那么此时更新 left 为 map.get(a)+1=1，当前有效子段更新为 bca；
				 2）当前字符不包含在当前最长有效子段中，如：abba，我们先添加a,b进map，此时left=0，我们再添加b，发现map中包含b，
				 而且b包含在最长有效子段中，就是1）的情况，我们更新 left=map.get(b)+1=2，此时子段更新为 b，而且map中仍然包含a，map.get(a)=0；
				 随后，我们遍历到a，发现a包含在map中，且map.get(a)=0，如果我们像1）一样处理，就会发现 left=map.get(a)+1=1，实际上，left此时
				 应该不变，left始终为2，子段变成 ba才对。

				 为了处理以上2类情况，我们每次更新left，left=Math.max(left , map.get(ch)+1).
				 另外，更新left后，不管原来的 s.charAt(i) 是否在最长子段中，我们都要将 s.charAt(i) 的位置更新为当前的i，
				 因此此时新的 s.charAt(i) 已经进入到 当前最长的子段中！
				 */
				if(map.containsKey(s.charAt(i)))
				{
					left = Math.max(left , map.get(s.charAt(i))+1);
				}
				//不管是否更新left，都要更新 s.charAt(i) 的位置！
				map.put(s.charAt(i) , i);
				maxLen = Math.max(maxLen , i-left+1);
			}

			return maxLen;
		}













	public static int lengthOfLongestSubstring2(String s) {
		if (s == null || s.equals("")) {
			return 0;
		}

		char[] str = s.toCharArray();
		// map (a, ?) (b, ?)
		// a, 17
		// map[97] = 17
		int[] map = new int[256];

		for (int i = 0; i < 256; i++) {
			map[i] = -1;
		}

		// 收集答案
		int len = 0;
		int pre = -1; //这种思路： i-1位置结尾的情况下，往左推，推不动的位置是谁，枚举出来
		int cur = 0;

		for (int i = 0; i != str.length; i++) {
			// i位置结尾的情况下，往左推，推不动的位置是谁
			// pre (i-1信息) -> pre(i 结尾信息)

			pre = Math.max(pre, map[str[i]]);
			cur = i - pre;
			len = Math.max(len, cur);
			map[str[i]] = i;
		}
		return len;
	}



}
