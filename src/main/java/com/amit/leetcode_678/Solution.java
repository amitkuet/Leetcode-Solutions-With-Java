package com.amit.leetcode_678;

import java.util.Stack;

public class Solution {

	public boolean checkValidString(String s) {
		Stack<Integer> open = new Stack<>();
		Stack<Integer> star = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				open.push(i);
			} else if (s.charAt(i) == '*') {
				star.push(i);
			} else {
				if (!open.isEmpty()) {
					open.pop();
				} else if (!star.isEmpty()) {
					star.pop();
				} else {
					return false;
				}
			}
		}

		while (!open.isEmpty()) {
			if (star.isEmpty()) {
				return false;
			}
			if (open.peek() < star.peek()) {
				open.pop();
				star.pop();
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().checkValidString("()")); // true
		System.out.println(new Solution().checkValidString("(*)")); // true
		System.out.println(new Solution().checkValidString("(*))")); // true
		System.out.println(new Solution().checkValidString("(*)))")); // false
	}

}
