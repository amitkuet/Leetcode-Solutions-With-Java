package com.amit.leetcode_224;

import java.util.Stack;

public class Solution {

	public int calculate(String s) {
		int sign = 1;
		int sum = 0;
		Stack<Integer> stack = new Stack<>();
		int n = s.length();

		for (int i = 0; i < n; i++) {
			// number
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				int num = 0;
				while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
					num = num * 10 + s.charAt(i) - '0';
					i++;
				}
				i--;
				sum += num * sign;
			}
			// +
			else if (s.charAt(i) == '+') {
				sign = 1;
			}
			// -
			else if (s.charAt(i) == '-') {
				sign = -1;
			}
			// (
			else if (s.charAt(i) == '(') {
				stack.push(sum);
				stack.push(sign);
				sign = 1;
				sum = 0;
			}
			// )
			else if (s.charAt(i) == ')') {
				sum = stack.pop() * sum;
				sum += stack.pop();
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().calculate("1 + 1")); // Output is 2
		System.out.println(new Solution().calculate(" 2-1 + 2 ")); // Output is 3
		System.out.println(new Solution().calculate("(1+(4+5+2)-3)+(6+8)")); // Output is 23
	}

}
