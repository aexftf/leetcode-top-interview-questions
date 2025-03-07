package topinterviewquestions;

/**
 * @author mac给定一个包含红色、白色和蓝色、
 * 共n 个元素的数组nums，原地对它们进行排序，
 * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 *
 *很清楚了已经
 * */
public class Problem_0075_SortColors {
	public static int[] sortColors(int[] nums) {

		int less = -1;
		int more = nums.length;
		int index = 0;

		while (index < more) {
			if (nums[index] == 1) {
				index++;
			} else if (nums[index] == 0) {
				swap(nums, index++, ++less);
			} else {
				swap(nums, index, --more);
			}
		}

		return nums;
	}








	public static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}









	public static void main(String[] args) {
		int[] ints = {2, 1, 2,1,0,0,0,1,1,1,2,2,2,2};

		int[] ints1 = sortColors(ints);
		for (int i = 0; i <ints1.length ; i++) {
			System.out.println(ints1[i]);
		}

	}

}
