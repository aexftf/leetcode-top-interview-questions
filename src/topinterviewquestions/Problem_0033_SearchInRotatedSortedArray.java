package topinterviewquestions;
//33. 搜索旋转排序数组（无序版二分查找）
//二分查找的时间复杂度是logn，快排的时间复杂度nlogn
public class Problem_0033_SearchInRotatedSortedArray {
// https://leetcode.cn/problems/search-in-rotated-sorted-array/solution/sou-suo-xuan-zhuan-pai-xu-shu-zu-by-leetcode-solut/
//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
//
//如果数组中不存在目标值 target，返回[-1, -1]。
//你必须设计并实现时间复杂度为O(log n)的算法解决此问题。

//示例 1：
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4]

//示2：
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1]

//示例 3：
//输入：nums = [], target = 0
//输出：[-1,-1]
;
//将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
//此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
	//对于有序数组，可以使用二分查找的方法查找元素。
	//但是这道题中，数组本身不是有序的，进行旋转后只保证了数组的局部是有序的，这还能进行二分查找吗？答案是可以的。
	//可以发现的是，我们将数组从中间分开成左右两部分的时候，一定有一部分的数组是有序的。拿示例来看，我们从 6 这个位置分开以后数组变成了 [4, 5, 6] 和 [7, 0, 1, 2] 两个部分，其中左边 [4, 5, 6] 这个部分的数组是有序的，其他也是如此。
	//这启示我们可以在常规二分查找的时候查看当前 mid 为分割位置分割出来的两个部分 [l, mid] 和 [mid + 1, r] 哪个部分是有序的，并根据有序的那个部分确定我们该如何改变二分查找的上下界，因为我们能够根据有序的那部分判断出 target 在不在这个部分：
	//如果 [l, mid - 1] 是有序数组，且 target 的大小满足
	//nums
	//nums
	//[
	//[nums[l],nums[mid])，则我们应该将搜索范围缩小至 [l, mid - 1]，否则在 [mid + 1, r] 中寻找。
	//如果 [mid, r] 是有序数组，且 target 的大小满足
	//(
	//nums
	//[
	//nums
	//(nums[mid+1],nums[r]]，则我们应该将搜索范围缩小至 [mid + 1, r]，否则在 [l, mid - 1] 中寻找。
	public int searchLeetCode(int[] nums, int target) {
		int n = nums.length;

		if (n == 0) {
			return -1;
		}
		if (n == 1) {
			return nums[0] == target ? 0 : -1;
		}

		int l = 0, r = n - 1;
//三种情况
		while (l <= r) {
			int mid = (l + r) / 2;
			if (nums[mid] == target) {//第一种直接太幸运，直接中点就是目标
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










	//=======================================================================


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
