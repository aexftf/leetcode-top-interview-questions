package HardToWrittenExamination;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
//求在该柱状图中，能够勾勒出来的矩形的最大面积。
//
//
//
//示例 1:
public class Problem_0084_LargestRectangleInHistogram {





	public int largestRectangleArea(int[] heights) {
		int n = heights.length;
		int[] left = new int[n];
		int[] right = new int[n];

		Deque<Integer> mono_stack = new ArrayDeque<Integer>();

		for (int i = 0; i < n; ++i) {
			while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
				mono_stack.pop();
			}
			left[i] = (          mono_stack.isEmpty() ? -1 : mono_stack.peek());
			mono_stack.push(i);
		}

		mono_stack.clear();
		for (int i = n - 1; i >= 0; --i) {
			while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
				mono_stack.pop();
			}
			right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());
			mono_stack.push(i);
		}

		int ans = 0;
		for (int i = 0; i < n; ++i) {
			ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
		}
		return ans;
	}











	public static int largestRectangleArea1(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int maxArea = 0;
		// 只放下标
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
				int j = stack.pop();
				int k = stack.isEmpty() ? -1 : stack.peek();
				int curArea = (i - k - 1) * height[j];
				maxArea = Math.max(maxArea, curArea);
			}
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			int j = stack.pop();
			int k = stack.isEmpty() ? -1 : stack.peek();
			int curArea = (height.length - k - 1) * height[j];
			maxArea = Math.max(maxArea, curArea);
		}
		return maxArea;
	}

}
