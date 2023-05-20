package topinterviewquestions;
 //x	摆动排序 II你一个整数数组nums，将它重新排列成nums[0] < nums[1] > nums[2] < nums[3]...的顺序。
//你可以假设所有输入数组都可以得到满足题目要求的结果。

//示例 1：
//输入：nums = [1,5,1,1,6,4]
//输出：[1,6,1,5,1,4]
//解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。

//示例 2：
//输入：nums = [1,3,2,2,3,1]
//输出：[2,3,1,3,1,2]
//
//链接：https://leetcode.cn/problems/wiggle-sort-ii
//就他妈一hard
import java.util.Arrays;

public class Problem_0324_WiggleSortII {


	public void wiggleSort1(int[] nums) {
			int[] arr = nums.clone();
			Arrays.sort(arr);
			int n = nums.length;
			int x = (n + 1) / 2;
			for (int i = 0, j = x - 1, k = n - 1; i < n; i += 2, j--, k--) {
				nums[i] = arr[j];
				if (i + 1 < n) {
					nums[i + 1] = arr[k];
				}
			}
		}

}
