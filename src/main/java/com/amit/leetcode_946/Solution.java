package com.amit.leetcode_946;

import java.util.Stack;

public class Solution {

	public boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> stack = new Stack<>();
		int i = 0, n = pushed.length;

		for (int num : pushed) {
			stack.push(num);
			while (!stack.isEmpty() && stack.peek() == popped[i]) {
				stack.pop();
				i++;
			}
		}
		return i == n;
	}

	public static void main(String[] args) {
		int[] pushed = { 1, 2, 3, 4, 5 };
		int[] popped = { 4, 5, 3, 2, 1 };
		System.out.println(new Solution().validateStackSequences(pushed, popped));

		pushed = new int[] { 1, 2, 3, 4, 5 };
		popped = new int[] { 4, 3, 5, 1, 2 };
		System.out.println(new Solution().validateStackSequences(pushed, popped));
	}

}
