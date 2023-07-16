package topinterviewquestions;
//字母异位词
import java.util.*;

//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
//示例 1:
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
//示例 2:
//输入: strs = [""]
//输出: [[""]]
//示例 3:
//输入: strs = ["a"]
//输出: [["a"]]
//链接：https://leetcode.cn/problems/group-anagrams
public class Problem_0049_GroupAnagrams {



//由于互为字母异位词的两个字符串包含的字母相同，因此对两个字符串分别进行排序之后得到的字符串一定是相同的，故可以将排序之后的字符串作为哈希表的键。
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();

		for (String str : strs) {
			char[] array = str.toCharArray();
			Arrays.sort(array);
			String key = new String(array);

			List<String> list = map.getOrDefault(key, new ArrayList<String>());
			list.add(str);
			map.put(key, list);
		}
		return new ArrayList<List<String>>(map.values());
	}




	public static List<List<String>> groupAnagrams1(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();

		for (String str : strs) {

			int[] record = new int[26];

			for (char cha : str.toCharArray()) {
				record[cha - 'a']++;
			}

			StringBuilder builder = new StringBuilder();

			for (int value : record) {
				builder.append(String.valueOf(value)).append("_");
			}

			String key = builder.toString();

			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<String>());
			}

			map.get(key).add(str);
		}

		List<List<String>> res = new ArrayList<List<String>>();
		for (List<String> list : map.values()) {
			res.add(list);
		}
		return res;
	}












	public static List<List<String>> groupAnagrams2(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strs) {
			char[] chs = str.toCharArray();
			Arrays.sort(chs);
			String key = String.valueOf(chs);
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<String>());
			}
			map.get(key).add(str);
		}
		List<List<String>> res = new ArrayList<List<String>>();
		for (List<String> list : map.values()) {
			res.add(list);
		}
		return res;
	}

}
