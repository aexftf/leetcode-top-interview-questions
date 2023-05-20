package followupAndFuckYou;

import java.util.ArrayList;
import java.util.TreeMap;

public class Problem_0673_NumberOfLongestIncreasingSubsequence {

	public static int findNumberOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		ArrayList<TreeMap<Integer, Integer>> dp = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {

			int L = 0;
			int R = dp.size() - 1;
			int find = -1;

			while (L <= R) {
				int mid = (L + R) / 2;

				if (dp.get(mid).firstKey() >= nums[i]) {
					find = mid;
					R = mid - 1;
				} else {
					L = mid + 1;
				}
			}

			int num = 1;
			int index = find == -1 ? dp.size() : find;

			if (index > 0) {

				TreeMap<Integer, Integer> lastMap = dp.get(index - 1);
				num = lastMap.get(lastMap.firstKey());

				if (lastMap.ceilingKey(nums[i]) != null) {
					num -= lastMap.get(lastMap.ceilingKey(nums[i]));
				}
			}

			if (index == dp.size()) {
				TreeMap<Integer, Integer> newMap = new TreeMap<Integer, Integer>();

				newMap.put(nums[i], num);
				dp.add(newMap);
			} else {
				TreeMap<Integer, Integer> curMap = dp.get(index);
				curMap.put(nums[i], curMap.get(curMap.firstKey()) + num);
			}
		}
		return dp.get(dp.size() - 1).firstEntry().getValue();
	}



















}
