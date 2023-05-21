package topinterviewquestions;

public class Problem_0287_FindTheDuplicateNumber {
//给定一个包含n + 1 个整数的数组nums ，其数字都在[1, n]范围内（包括 1 和 n），可知至少存在一个重复的整数。
//假设 nums 只有 一个重复的整数 ，返回这个重复的数 。
//你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。

	//示例 1：
//输入：nums = [1,3,4,2,2]
//输出：2

	//示例 2：
//输入：nums = [3,1,3,4,2]
//输出：3

//https://leetcode.cn/problems/find-the-duplicate-number

		public int findDuplicate(int[] nums) {
			int n = nums.length;
			int l = 1, r = n - 1, ans = -1;

			while (l <= r) {
				int mid = (r + l) /2 ;
				int cnt = 0;

				for (int i = 0; i < n; ++i) {
					if (nums[i] <= mid) {
						cnt++;
					}
				}

				if (cnt <= mid) {
					l = mid + 1;
				} else {
					r = mid - 1;
					ans = mid;
				}
			}
			return ans;
		}




}
