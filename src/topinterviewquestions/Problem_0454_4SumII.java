package topinterviewquestions;

import java.util.HashMap;
//454. 四数相加 II
public class Problem_0454_4SumII {
//给你四个整数数组 nums	1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
//0 <= i, j, k, l < n
//nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0

//示例 1：
//输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
//输出：2
//解释：
//两个元组如下：
//1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
//2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0

	//示例 2：
//输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
//输出：1
//链接：https://leetcode.cn/problems/4sum-ii
	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;

		for (int i = 0; i < A.length; i++) {

			for (int j = 0; j < B.length; j++) {
				sum = A[i] + B[j];

				if  (!map.containsKey(sum)) {
					map.put(sum, 1);
				} else {
					map.put(sum, map.get(sum) + 1);
				}
			}
		}
		int ans = 0;

		for (int i = 0; i < C.length; i++) {

			for (int j = 0; j < D.length; j++) {

				sum = C[i] + D[j];

				if (map.containsKey(-sum)) {
					ans += map.get(-sum);
				}
			}
		}
		return ans;
	}

}
