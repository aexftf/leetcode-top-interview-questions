package topinterviewquestions;

public class Problem_0238_ProductOfArrayExceptSelf {

	//除了自己其他都乘

	public int[] productExceptSelf(int[] nums) {
		int zeros = 0;
		int all = 1;

		for (int num : nums) {
			if (num == 0) {
				zeros++;
			} else {
				all *= num;
			}
		}

		if (zeros > 1) {//全是0
			for (int i = 0; i < nums.length; i++) {
				nums[i] = 0;
			}

		} else {
			if (zeros == 0) {//没有0
				for (int i = 0; i < nums.length; i++) {
					nums[i] = all / nums[i];
				}

			} else {//一个0
				for (int i = 0; i < nums.length; i++) {
					nums[i] = nums[i] == 0 ? all : 0;
				}
			}
		}
		return nums;
	}













}
