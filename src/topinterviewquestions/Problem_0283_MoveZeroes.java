package topinterviewquestions;

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
