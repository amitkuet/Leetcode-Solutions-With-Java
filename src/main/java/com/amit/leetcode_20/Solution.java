package com.amit.leetcode_20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

	public boolean isValid(String s) {
		if (s == null || s.isEmpty()) {
			return true;
		}
		Map<Character, Character> map = new HashMap<>();
		map.put('}', '{');
		map.put(')', '(');
		map.put(']', '[');

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (map.containsKey(ch)) {
				char c = (stack.isEmpty()) ? '#' : stack.pop();
				if (c != map.get(ch)) {
					return false;
				}
			} else {
				stack.push(ch);
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(new Solution().isValid("()")); // Output is true
		System.out.println(new Solution().isValid("()[]{}")); // Output is true
		System.out.println(new Solution().isValid("(]")); // Output is false
		System.out.println(new Solution().isValid("([)]")); // Output is false
		System.out.println(new Solution().isValid("{[]}")); // Output is true
	}

}
