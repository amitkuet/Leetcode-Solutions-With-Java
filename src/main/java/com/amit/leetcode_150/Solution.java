package com.amit.leetcode_150;

import java.util.Stack;

public class Solution {

	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();

		for (String token : tokens) {
			if ("+-*/".contains(token)) {
				int b = stack.pop();
				int a = stack.pop();
				if (token.equals("+")) {
					stack.push(a + b);
				} else if (token.equals("-")) {
					stack.push(a - b);
				} else if (token.equals("*")) {
					stack.push(a * b);
				} else if (token.equals("/")) {
					stack.push(a / b);
				}
			} else {
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.peek();
	}

	public static void main(String[] args) {
		System.out.println(new Solution().evalRPN(new String[] { "2", "1", "+", "3", "*" })); // Output is 9
		System.out.println(new Solution()
				.evalRPN(new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" })); // Output is 22
	}

}
