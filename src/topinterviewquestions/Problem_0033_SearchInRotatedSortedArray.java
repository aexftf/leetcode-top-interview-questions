package topinterviewquestions;

public class Problem_0033_SearchInRotatedSortedArray {


//34. 在排序数组中查找元素的第一个和最后一个位置
// https://leetcode.cn/problems/search-in-rotated-sorted-array/solution/sou-suo-xuan-zhuan-pai-xu-shu-zu-by-leetcode-solut/
//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
//
//如果数组中不存在目标值 target，返回 [-1, -1]。
//
//你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
//
// 
//
//示例 1：
//
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4]
//示例 2：
//
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1]
//示例 3：
//
//输入：nums = [], target = 0
//输出：[-1,-1]
// 
	//官方题解答案，更好理解一些
	public int searchLeetCode(int[] nums, int target) {
		int n = nums.length;

		if (n == 0) {
			return -1;
		}
		if (n == 1) {
			return nums[0] == target ? 0 : -1;
		}

		int l = 0, r = n - 1;
//三种情况，第一种直接太幸运，直接中点就是目标
		while (l <= r) {
			int mid = (l + r) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			//左边这个小区域
			if (nums[0] <= nums[mid]) {
				if (nums[0] <= target && target < nums[mid]) {
					r = mid - 1;//没找到，但是条件可以继续。继续向左二分
				} else {		//没找到，但是条件可以继续。继续向右二分
					l = mid + 1;
				}
				//右边这个小区域
			} else {//没找到，但是条件可以继续。继续向右二分
				if (nums[mid] < target && target <= nums[n - 1]) {
					l = mid + 1;
					//没找到，但是条件可以继续。继续向左二分是
				} else {
					r = mid - 1;
				}
			}
		}
		return -1;
	}


//	public static int search11(int[] nums, int target){
//
//			int	n = nums.length;
//			if (n==0){
//				return -1;
//			}
//			if (n==1){
//				return target==nums[0] ? 0 :-1;
//			}
//		int l = 0, r = n - 1;
//
//	}
//
//



	public static int search(int[] arr, int num) {
		int L = 0;
		int R = arr.length - 1;
		int M = 0;

		while (L <= R) {
			M = (L + R) / 2;
			if (arr[M] == num) {
				return M;
			}
			// arr[M] != num
			if (arr[L] == arr[M] && arr[M] == arr[R]) {
				while (L != M && arr[L] == arr[M]) {
					L++;
				}
				// L和M没撞上，[L]!=[M] L,.....M
				if (L == M) {
					L = M + 1;
					continue;
				}
			}
			// arr[M] != num
			// [L] [M] [R] 不都一样的情况
			if (arr[L] != arr[M]) {
				if (arr[M] > arr[L]) {
					if (num >= arr[L] && num < arr[M]) {
						R = M - 1;
					} else {
						L = M + 1;
					}
				} else { //  [L]  >  [M]
					if (num > arr[M] && num <= arr[R]) {
						L = M + 1;
					} else {
						R = M - 1;
					}
				}
			} else { // [L] === [M] ->  [M]!=[R]
				if (arr[M] < arr[R]) {
					if (num > arr[M] && num <= arr[R]) {
						L = M + 1;
					} else {
						R = M - 1;
					}
				} else {
					if (num >= arr[L] && num < arr[M]) {
						R = M - 1;
					} else {
						L = M + 1;
					}
				}
			}
		}
		return -1;
	}

}
