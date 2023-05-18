package topinterviewquestions;
//给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
//你可以假设数组是非空的，并且给定的数组总是存在多数元素。

//示例1：
//输入：nums = [3,2,3]
//输出：3

//示例2：
//输入：nums = [2,2,1,1,1,2,2]
//输出：2
//链接：https://leetcode.cn/problems/majority-element
public class Problem_0169_MajorityElement {
//很巧妙
	public static int majorityElement(int[] nums) {
		int cand = 0;
		int HP = 0;

		for (int i = 0; i < nums.length; i++) {
			if (HP == 0) {
				cand = nums[i];
				HP = 1;
			} else if (nums[i] == cand) {
				HP++;
			} else {
				HP--;
			}
		}
		return cand;
	}

}
