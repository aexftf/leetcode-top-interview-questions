package topinterviewquestions;
//268. 丢失的数字
public class Problem_0268_MissingNumber {


	//给定一个包含 [0, n]中n个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。

	//示例 1：
	//输入：nums = [3,0,1]
	//输出：2
	//解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。

	//示例 2：
	//输入：nums = [0,1]
	//输出：2
	//解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。

	//示例 3：
	//输入：nums = [9,6,4,2,3,5,7,0,1]
	//输出：8
	//解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
	//链接：https://leetcode.cn/problems/missing-number



	public static int missingNumber(int[] arr) {

		int l = 0;
		int r = arr.length;

		while (l < r) {
			if (arr[l] == l) {
				l++;
			} else if (arr[l] < l || arr[l] >= r || arr[arr[l]] == arr[l]) {
				swap(arr, l, --r);
			} else {
				swap(arr, l, arr[l]);
			}
		}
		return l;
	}











	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
