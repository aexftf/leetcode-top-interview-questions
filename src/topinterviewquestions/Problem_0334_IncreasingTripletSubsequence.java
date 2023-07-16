package topinterviewquestions;
//给你一个整数数组nums ，判断这个数组中是否存在长度为 3 的递增子序列。
//如果存在这样的三元组下标 (i, j, k)且满足 i < j < k ，使得nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。

//示例 1：
//输入：nums = [1,2,3,4,5]
//输出：true
//解释：任何 i < j < k 的三元组都满足题意

//示例 2：
//输入：nums = [5,4,3,2,1]
//输出：false
//解释：不存在满足题意的三元组
//链接：https://leetcode.cn/problems/increasing-triplet-subsequence
public class Problem_0334_IncreasingTripletSubsequence {


//这个题和LC300.最长递增子序列类似，可以DP可以贪心，
// 直接一次遍历，每次保存最小的两个值，如果存在比他俩大的数，那就凑齐了三元递增子序列，空间O(1)走起

		public boolean increasingTriplet(int[] nums) {//贪心
			if (nums == null || nums.length < 3) {
				return false;
			}
			int a = Integer.MAX_VALUE;
			int b = Integer.MAX_VALUE;

			for (int num: nums) {
				if (num <= a) a = num;
				else if (num <= b) b = num;
				else return true;
			}
			return false;
		}























//
//	public static boolean increasingTriplet1(int[] arr) {
//		if (arr == null || arr.length < 3) {
//			return false;
//		}
//
//		int[] ends = new int[3];
//		ends[0] = arr[0];
//
//		int right = 0;
//		int l = 0;
//		int r = 0;
//		int m = 0;
//
//		for (int i = 1; i < arr.length; i++) {
//			l = 0;
//			r = right;
//
//			while (l <= r) {
//				m = (l + r) / 2;
//				if (arr[i] > ends[m]) {
//					l = m + 1;
//				} else {
//					r = m - 1;
//				}
//			}
//			right = Math.max(right, l);
//
//			if (right > 1) {
//				return true;
//			}
//			ends[l] = arr[i];
//		}
//		return false;
//	}
//
//






}
