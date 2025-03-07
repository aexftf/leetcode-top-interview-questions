package topinterviewquestions;
//打乱数组（简单题）
public class Problem_0384_ShuffleAnArray {
//给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。打乱后，数组的所有排列应该是等可能的。
//实现 Solution class:
//Solution(int[] nums) 使用整数数组 nums 初始化对象
//int[] reset() 重设数组到它的初始状态并返回
//int[] shuffle() 返回数组随机打乱后的结果

	//示例 1：
//输入
//["Solution", "shuffle", "reset", "shuffle"]
//[[[1, 2, 3]], [], [], []]
//输出
//[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
//解释
//Solution solution = new Solution([1, 2, 3]);
//solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
//solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
//solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
	class Solution {
		private int[] origin;
		private int[] shuffle;
		private int N;


		public Solution(int[] nums) {
			origin = nums;
			N = nums.length;
			shuffle = new int[N];

			for (int i = 0; i < N; i++) {
				shuffle[i] = origin[i];
			}
		}


		public int[] reset() {
			return origin;
		}

		public int[] shuffle() {
			for (int i = N - 1; i >= 0; i--) {

				int r = (int) (Math.random() * (i + 1));//1~i+1随机

				int tmp = shuffle[r];
				shuffle[r] = shuffle[i];
				shuffle[i] = tmp;

			}
			return shuffle;
		}




	}






}
