package topinterviewquestions;

import java.util.Arrays;
import java.util.Comparator;
//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
//注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。

//示例 1：
//输入：nums = [10,2]
//输出："210"
//示例2：
//输入：nums = [3,30,34,5,9]
//输出："9534330"
//链接：https://leetcode.cn/problems/largest-number
public class Problem_0179_LargestNumber {

	public static class MyComparator implements Comparator<String> {

		@Override//这个是关键
		public int compare(String o1, String o2) {
			return (o2 + o1).compareTo(o1 + o2);
		}

	}

	public String largestNumber(int[] nums) {
		String[] strs = new String[nums.length];

		for (int i = 0; i < nums.length; i++) {
			strs[i] = String.valueOf(nums[i]);
		}

		Arrays.sort(strs, new MyComparator());
		StringBuilder builder = new StringBuilder();

		for (String str : strs) {
			builder.append(str);
		}

		String ans = builder.toString();
		char[] str = ans.toCharArray();

		int index = -1;

		//鸡肋,判first0用的
		for (int i = 0; i < str.length; i++) {
			if (str[i] != '0') {
				index = i;
				break;
			}
		}
		return index == -1 ? "0" : ans.substring(index);
	}

}
