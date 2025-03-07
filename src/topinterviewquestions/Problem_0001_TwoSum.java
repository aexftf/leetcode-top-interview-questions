package topinterviewquestions;
//忘了就看视频，最快速度过一遍
import java.util.HashMap;
//两数之和
public class Problem_0001_TwoSum {


	//给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target的那两个整数，并返回它们的数组下标。
	//
	//你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
	//
	//你可以按任意顺序返回答案。
	public static int[] twoSum(int[] nums, int target) {
		// key 某个之前的数   value 这个数出现的位置
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				return new int[] { map.get(target - nums[i]), i };
			}
			map.put(nums[i], i);
		}
		return new int[] { -1, -1 };
	}


}
