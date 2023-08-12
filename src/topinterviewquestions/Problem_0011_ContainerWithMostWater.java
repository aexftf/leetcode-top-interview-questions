package topinterviewquestions;
//盛最多水的容器
//给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
//
//找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
//
//返回容器可以储存的最大水量。
//
//说明：你不能倾斜容器。
//
//链接：https://leetcode.cn/problems/container-with-most-water
public class Problem_0011_ContainerWithMostWater {

	public static int maxArea(int[] h) {
		int max = 0;
		int l = 0;
		int r = h.length - 1;

		//单纯得去想面积最大值，其他的不考虑。
		while (l < r) {

			max = Math.max(max, Math.min(h[l], h[r]) * (r - l));

			if (h[l] > h[r]) {
				r--;
			} else {
				l++;
			}
		}
		return max;
	}



}
