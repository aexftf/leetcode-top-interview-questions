package topinterviewquestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
public class Problem_0046_Permutations {

	public static List<List<Integer>> permutes(int[] nums) {
		//结果数组
		List<List<Integer>> ans = new ArrayList<>();
		//去重set
		HashSet<Integer> rest = new HashSet<>();
		for (int num : nums) {
			rest.add(num);
		}
		//每个可能性数组
		ArrayList<Integer> path = new ArrayList<>();

		f(rest, path, ans);
		return ans;
	}

	// rest中有剩余数字，已经选过的数字不在rest中，选过的数字在path里
	public static void f(HashSet<Integer> rest, ArrayList<Integer> path, List<List<Integer>> ans) {
		if (rest.isEmpty()) {
			ans.add(path);
		} else {
			for (int num : rest) {
				ArrayList<Integer> curPath = new ArrayList<>(path);
				curPath.add(num);

				HashSet<Integer> clone = cloneExceptNum(rest, num);
				f(clone, curPath, ans);
			}
		}
	}

//回溯
	public static HashSet<Integer> cloneExceptNum(HashSet<Integer> rest, int num) {
		HashSet<Integer> clone = new HashSet<>(rest);
		clone.remove(num);
		return clone;
	}






















	//------------------------------------------------------------------------

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		process(nums, 0, ans);
		return ans;
	}

	public static void process(int[] nums, int index, List<List<Integer>> ans) {
		if (index == nums.length) {
			ArrayList<Integer> cur = new ArrayList<>();

			for (int num : nums) {
				cur.add(num);
			}
			ans.add(cur);
		} else {
			for (int j = index; j < nums.length; j++) {
				swap(nums, index, j);

				process(nums, index + 1, ans);

				swap(nums, index, j);
			}
		}
	}


















	public static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

}
