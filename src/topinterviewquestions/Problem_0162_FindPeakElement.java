package topinterviewquestions;
//162. 寻找峰值
public class Problem_0162_FindPeakElement {
//值元素是指其值严格大于左右相邻值的元素。
//给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
//你可以假设nums[-1] = nums[n] = -∞ 。
//你必须实现时间复杂度为 O(log n) 的算法来解决此问题。

//示例 1：
//输入：nums = [1,2,3,1]
//输出：2
//解释：3 是峰值元素，你的函数应该返回其索引 2。
//链接：https://leetcode.cn/problems/find-peak-element
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	public static int findPeakElement(int[] nums) {
		int N = nums.length;
		if (N < 2) {
			return 0;
		}

		if (nums[0] > nums[1]) {
			return 0;
		}

		if (nums[N - 1] > nums[N - 2]) {
			return N - 1;
		}

		int L = 1;
		int R = N - 2;
		int M = 0;

		while (L < R) {//变种二分法
			M = (L + R) / 2;
			if (nums[M - 1] < nums[M] && nums[M] > nums[M + 1]) {
				return M;
			} else if (nums[M - 1] > nums[M]) {
				R = M - 1;
			} else {
				L = M + 1;
			}
		}
		return L;
	}



}
