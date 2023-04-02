package topinterviewquestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem_0078_Subsets {
//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
//解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		LinkedList<Integer> path = new LinkedList<>();

		process(nums, 0, path, ans);
		return ans;
	}

	// 当前来到index位置，做决定，1）不要当前位置的数   2）要当前位置的数
	// 如果要当前位置的数，把该数字，放入到path中去
	// 如果不要当前位置的数，不把该数字，放入到path中去
	public static void process(int nums[], int index, LinkedList<Integer> path, List<List<Integer>> ans) {
		if (index == nums.length) {
			ans.add(copy(path));
		} else {

			process(nums, index + 1, path, ans);
			path.addLast(nums[index]);
			process(nums, index + 1, path, ans);
			path.removeLast();

		}
	}

	public static ArrayList<Integer> copy(LinkedList<Integer> path) {
		ArrayList<Integer> ans = new ArrayList<>();

		for (Integer num : path) {
			ans.add(num);
		}
		return ans;
	}

}
