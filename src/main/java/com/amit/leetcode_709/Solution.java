package com.amit.leetcode_709;

public class Solution {

	public String toLowerCase(String str) {
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] >= 'A' && chars[i] <= 'Z') {
				chars[i] = (char) (chars[i] + 32);
			}
		}
		return new String(chars);
	}

	public static void main(String[] args) {
		System.out.println(new Solution().toLowerCase("Hello")); // Output is hello
		System.out.println(new Solution().toLowerCase("here")); // Output is here
		System.out.println(new Solution().toLowerCase("LOVELY")); // Output is lovely
	}

}
