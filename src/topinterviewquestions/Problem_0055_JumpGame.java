package topinterviewquestions;
//给定一个非负整数数组nums ，你最初位于数组的 第一个下标 。
//
//数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
//判断你是否能够到达最后一个下标。
//这种方法所依据的核心特性：如果一个位置能够到达，那么这个位置左侧所有位置都能到达。 想到这一点，解法就呼之欲出了~
public class Problem_0055_JumpGame {
//解题思路：
//如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点
//可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新
//如果可以一直跳到最后，就成功了

	public static boolean canJump(int[] nums) {

		if (nums == null || nums.length < 2) {
			return true;
		}

		int max = nums[0];

		for (int i = 1; i < nums.length; i++) {

			//	if (max >= nums.length - 1) {
			//return true;
			// }

			if (i > max) {     //代入数 nums[i]<0就完了
				return false;
			}
			max = Math.max(max, i + nums[i]);
		}
		return true;
	}





}
