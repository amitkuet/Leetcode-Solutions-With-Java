package com.amit.leetcode_84;

import java.util.Stack;

public class Solution {

	public int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length == 0) {
			return 0;
		}
		if (heights.length == 1) {
			return heights[0];
		}

		int max = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(0);

		for (int i = 1; i < heights.length; i++) {
			int curr = heights[i];
			if (curr >= heights[stack.peek()]) {
				stack.push(i);
			} else {
				while (!stack.isEmpty() && curr < heights[stack.peek()]) {
					int temp = heights[stack.pop()];
					if (stack.isEmpty()) {
						max = Math.max(max, temp * i);
					} else {
						max = Math.max(max, temp * (i - stack.peek() - 1));
					}
				}
				stack.add(i);
			}
		}

		int i = heights.length;
		while (!stack.isEmpty()) {
			int temp = heights[stack.pop()];
			if (stack.isEmpty()) {
				max = Math.max(max, temp * i);
			} else {
				max = Math.max(max, temp * (i - stack.peek() - 1));
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] heights = { 2, 1, 5, 6, 2, 3 };
		System.out.println(new Solution().largestRectangleArea(heights)); // Output is 10
	}

}
