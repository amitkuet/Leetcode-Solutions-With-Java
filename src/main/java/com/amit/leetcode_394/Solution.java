package com.amit.leetcode_394;

import java.util.Stack;

public class Solution {

	public String decodeString(String s) {
		Stack<Integer> is = new Stack<>();
		Stack<String> ss = new Stack<>();
		String res = "";
		int i = 0;

		while (i < s.length()) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				int num = 0;
				while (Character.isDigit(s.charAt(i))) {
					num = num * 10 + (s.charAt(i) - '0');
					i++;
				}
				is.push(num);
			} else if (ch == '[') {
				ss.push(res);
				res = "";
				i++;
			} else if (ch == ']') {
				StringBuilder sb = new StringBuilder(ss.pop());
				int count = is.pop();
				for (int k = 0; k < count; k++) {
					sb.append(res);
				}
				res = sb.toString();
				i++;
			} else {
				res += ch;
				i++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().decodeString("3[a]2[bc]")); // Output is aaabcbc
		System.out.println(new Solution().decodeString("3[a2[c]]")); // Output is accaccacc
	}

}
