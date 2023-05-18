package topinterviewquestions;
 //x	摆动排序 II你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
//
//你可以假设所有输入数组都可以得到满足题目要求的结果。
//
// 
//
//示例 1：
//
//输入：nums = [1,5,1,1,6,4]
//输出：[1,6,1,5,1,4]
//解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
//示例 2：
//
//输入：nums = [1,3,2,2,3,1]
//输出：[2,3,1,3,1,2]
//
//来源：力扣（LeetCode）
//链接：https://leetcode.cn/problems/wiggle-sort-ii
//就他妈一hard
import java.util.Arrays;

public class Problem_0324_WiggleSortII {


	public void wiggleSort1(int[] nums) {
			int[] arr = nums.clone();
			Arrays.sort(arr);
			int n = nums.length;
			int x = (n + 1) / 2;
			for (int i = 0, j = x - 1, k = n - 1; i < n; i += 2, j--, k--) {
				nums[i] = arr[j];
				if (i + 1 < n) {
					nums[i + 1] = arr[k];
				}
			}
		}












	// 时间复杂度O(N)，额外空间复杂度O(1)
	public void wiggleSort(int[] nums) {
		if (nums == null || nums.length < 2) {
			return;
		}
		int N = nums.length;

		findIndexNum(nums, 0, nums.length - 1, N / 2);

		if ((N & 1) == 0) {
			shuffle(nums, 0, nums.length - 1);
			reverse(nums, 0, nums.length - 1);
		} else {
			shuffle(nums, 1, nums.length - 1);
		}
	}

	public static int findIndexNum(int[] arr, int L, int R, int index) {
		int pivot = 0;
		int[] range = null;

		while (L < R) {
			pivot = arr[L + (int) (Math.random() * (R - L + 1))];
			range = partition(arr, L, R, pivot);
			if (index >= range[0] && index <= range[1]) {
				return arr[index];
			} else if (index < range[0]) {
				R = range[0] - 1;
			} else {
				L = range[1] + 1;
			}
		}
		return arr[L];
	}

	public static int[] partition(int[] arr, int L, int R, int standard) {
		int less = L - 1;
		int more = R + 1;
		int cur = L;

		while (cur < more) {
			if (arr[cur] < standard) {
				swap(arr, ++less, cur++);
			} else if (arr[cur] > standard) {
				swap(arr, cur, --more);
			} else {
				cur++;
			}
		}
		return new int[] { less + 1, more - 1 };
	}

	public static void shuffle(int[] nums, int l, int r) {

		while (r - l + 1 > 0) {
			int lenAndOne = r - l + 2;
			int bloom = 3;
			int k = 1;

			while (bloom <= lenAndOne / 3) {
				bloom *= 3;
				k++;
			}

			int m = (bloom - 1) / 2;
			int mid = (l + r) / 2;
			rotate(nums, l + m, mid, mid + m);
			cycles(nums, l - 1, bloom, k);
			l = l + bloom - 1;
		}
	}

	public static void cycles(int[] nums, int base, int bloom, int k) {
		for (int i = 0, trigger = 1; i < k; i++, trigger *= 3) {
			int next = (2 * trigger) % bloom;
			int cur = next;
			int record = nums[next + base];
			int tmp = 0;
			nums[next + base] = nums[trigger + base];

			while (cur != trigger) {
				next = (2 * cur) % bloom;
				tmp = nums[next + base];
				nums[next + base] = record;
				cur = next;
				record = tmp;
			}
		}
	}

	public static void rotate(int[] arr, int l, int m, int r) {
		reverse(arr, l, m);
		reverse(arr, m + 1, r);
		reverse(arr, l, r);
	}

	public static void reverse(int[] arr, int l, int r) {
		while (l < r) {
			swap(arr, l++, r--);
		}
	}

	public static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

}
