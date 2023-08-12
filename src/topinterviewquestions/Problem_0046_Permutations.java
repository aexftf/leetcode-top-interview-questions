package topinterviewquestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//示例1：
//
//输入： nums = [1,2,3]
//输出： [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1 ,2],[3,2,1]]
//示例2：
//
//输入： nums = [0,1]
//输出： [[0,1],[1,0]]
//示例3：
//
//输入： nums = [1]
//输出： [[1]]
public class Problem_0046_Permutations {
	//

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

				HashSet<Integer> clone = cloneExceptNum(rest, num);//回溯

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




















//66666666666666666666666666666666666666666666666666666666666666666666666666666666666

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



//66666666666666666666666666666666666666666666666666666666666666666666666666666666666





	public List<List<Integer>> permute1(int[] nums) {
		int len = nums.length;
		// 使用一个动态数组保存所有可能的全排列
		List<List<Integer>> res = new ArrayList<>();
		if (len == 0) {
			return res;
		}

		boolean[] used = new boolean[len];
		List<Integer> path = new ArrayList<>();

		dfs(nums, len, 0, path, used, res);
		return res;
	}

	private void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used,
					 List<List<Integer>> res) {
		if (depth == len) {
			res.add(path);
			return;
		}

		// 在非叶子结点处，产生不同的分支，这一操作的语义是：在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
		for (int i = 0; i < len; i++) {
			if (!used[i]) {
				path.add(nums[i]);
				used[i] = true;

				dfs(nums, len, depth + 1, path, used, res);
				// 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
				used[i] = false;
				path.remove(path.size() - 1);
			}
		}
	}

	//链接：https://leetcode.cn/problems/permutations/solutions/9914/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/








	public static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

}
