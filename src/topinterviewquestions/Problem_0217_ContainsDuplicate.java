package topinterviewquestions;

import java.util.Arrays;
import java.util.HashSet;
//给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。

//示例 1：
//输入：nums = [1,2,3,1]
//输出：true
//示例 2：
//输入：nums = [1,2,3,4]
//输出：false
//示例3：
//输入：nums = [1,1,1,3,3,4,3,2,4,2]
//输出：true
//链接：https://leetcode.cn/problems/contains-duplicate
public class Problem_0217_ContainsDuplicate {





	public boolean containsDuplicate(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		for (int i = 0; i < n - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				return true;
			}
		}
		return false;
	}






}
