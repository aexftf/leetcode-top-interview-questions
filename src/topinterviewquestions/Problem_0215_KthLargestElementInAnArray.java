package topinterviewquestions;

import java.util.Arrays;

//215. 数组中的第K个最大元素
public class Problem_0215_KthLargestElementInAnArray {
//经典面试13
// 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。   快速排序的选择方法

//示例 1:
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
//示例2:
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4
//链接：https://leetcode.cn/problems/kth-largest-element-in-an-array








	public int findKthLargest2b(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}





//===========================================================================


	public int findKthLargest(int[] nums, int k) {
		return minKth(nums, nums.length + 1 - k);
	}

	//
	public static int minKth(int[] arr, int k) {
		return process(arr, 0, arr.length - 1, k - 1);
	}
//
	public static int process(int[] arr, int L, int R, int index) {
		if (L == R) {
			return arr[L];
		}

		int pivot = arr[L + (int) (Math.random() * (R - L + 1))];

		int[] range = partition(arr, L, R, pivot);

		if (index >= range[0] && index <= range[1]) {
			return arr[index];
		} else if (index < range[0]) {
			return process(arr, L, range[0] - 1, index);
		} else {
			return process(arr, range[1] + 1, R, index);
		}

	}




	public static int[] partition(int[] arr, int L, int R, int pivot) {
		int less = L - 1;
		int more = R + 1;
		int cur = L;

		while (cur < more) {
			if (arr[cur] < pivot) {
				swap(arr, ++less, cur++);
			} else if (arr[cur] > pivot) {
				swap(arr, cur, --more);
			} else {
				cur++;
			}
		}
		return new int[] { less + 1, more - 1 };
	}
















	public static void swap(int[] arr, int i1, int i2) {
		int tmp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = tmp;
	}












}
