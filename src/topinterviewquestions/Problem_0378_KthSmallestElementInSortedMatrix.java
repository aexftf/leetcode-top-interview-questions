package topinterviewquestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
//给你一个n x n矩阵matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
//请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
//你必须找到一个内存复杂度优于O(n2) 的解决方案。

//示例 1：
//输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
//输出：13
//解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
//示例 2：
//输入：matrix = [[-5]], k = 1
//输出：-5
public class Problem_0378_KthSmallestElementInSortedMatrix {
//https://leetcode.cn/problems/top-k-frequent-elements/solution/qian-k-ge-gao-pin-yuan-su-by-leetcode-solution/

//最直接的做法是将这个二维数组转成一维数组，并对该一维数组进行排序。最后这个一维数组中的第
//k 个数即为答案。
	public int kthSmallest(int[][] matrix, int k) {
		int rows = matrix.length, columns = matrix[0].length;
		int[] sorted = new int[rows * columns];
		int index = 0;

		for (int[] row : matrix) {
			for (int num : row) {
				sorted[index++] = num;
			}
		}
		Arrays.sort(sorted);
		return sorted[k - 1];
	}






}
