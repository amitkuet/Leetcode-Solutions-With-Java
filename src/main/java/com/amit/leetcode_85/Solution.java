package com.amit.leetcode_85;

import java.util.Stack;

public class Solution {

	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0) {
			return 0;
		}
		int max = 0;
		int[] height = new int[matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == '0') {
					height[j] = 0;
				} else {
					height[j]++;
				}
			}
			max = Math.max(max, findTheArea(height));
		}
		return max;
	}

	private int findTheArea(int[] height) {
		int max = 0;
		Stack<Integer> stack = new Stack<>();
		stack.add(0);

		for (int i = 1; i < height.length; i++) {
			int curr = height[i];
			if (curr >= height[stack.peek()]) {
				stack.add(i);
			} else {
				while (!stack.isEmpty() && curr < height[stack.peek()]) {
					int temp = height[stack.pop()];
					if (stack.isEmpty()) {
						max = Math.max(max, temp * i);
					} else {
						max = Math.max(max, temp * (i - stack.peek() - 1));
					}
				}
				stack.add(i);
			}
		}

		int i = height.length;
		while (!stack.isEmpty()) {
			int temp = height[stack.pop()];
			if (stack.isEmpty()) {
				max = Math.max(max, temp * i);
			} else {
				max = Math.max(max, temp * (i - stack.peek() - 1));
			}
		}
		return max;
	}

	public static void main(String[] args) {
		char [][] matrix = {
				{'1','0','1','0','0'},
				{'1','0','1','1','1'},
				{'1','1','1','1','1'},
				{'1','0','0','1','0'}
		                    };
		System.out.println(new Solution().maximalRectangle(matrix));  // Output is 6
	}

}
