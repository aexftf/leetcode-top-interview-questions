package topinterviewquestions;
//把0都放后面
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//请注意，必须在不复制数组的情况下原地对数组进行操作。
//示例 1:
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]

//示例 2:
//输入: nums = [0]
//输出: [0]
//链接：https://leetcode.cn/problems/move-zeroes
public class Problem_0283_MoveZeroes {


	//思想：两个指针一个指向已完成的末尾，另一个一直往前跑，跑完即结束。
	public static void moveZeroes(int[] nums) {
		int to = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				swap(nums, to++, i);
			}
		}
	}




	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
