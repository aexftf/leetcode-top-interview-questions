package topinterviewquestions;
//给定n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

//示例 1：
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。

//示例 2：
//输入：height = [4,2,0,3,2,5]
//输出：9
public class Problem_0042_TrappingRainWater {


	//接雨水问题
	public static int trap(int[] arr) {
		if (arr == null || arr.length < 3) {
			return 0;
		}
		int N = arr.length;

		int L = 1;
		int leftMax = arr[0];

		int R = N - 2;
		int rightMax = arr[N - 1];

		int water = 0;

		while (L <= R) {
			if (leftMax <= rightMax) {      //按照小的来
				water += Math.max(0, leftMax - arr[L]);//
				leftMax = Math.max(leftMax, arr[L++]);
			} else {
				water += Math.max(0, rightMax - arr[R]);//
				rightMax = Math.max(rightMax, arr[R--]);
			}
		}
		return water;
	}

}
