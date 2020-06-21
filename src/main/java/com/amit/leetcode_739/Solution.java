package com.amit.leetcode_739;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

	public int[] dailyTemperatures(int[] T) {
		Stack<Integer> stack = new Stack<>();
		int[] ans = new int[T.length];

		for (int i = T.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
				stack.pop();
			}
			ans[i] = (stack.isEmpty()) ? 0 : stack.peek() - i;
			stack.push(i);
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] T = { 73, 74, 75, 71, 69, 72, 76, 73 };
		int[] res = new Solution().dailyTemperatures(T);
		System.out.println(Arrays.toString(res));  // Output is [1, 1, 4, 2, 1, 1, 0, 0]
	}

}
