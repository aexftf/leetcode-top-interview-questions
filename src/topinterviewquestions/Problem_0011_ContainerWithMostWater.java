package topinterviewquestions;
//盛最多水的容器
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
