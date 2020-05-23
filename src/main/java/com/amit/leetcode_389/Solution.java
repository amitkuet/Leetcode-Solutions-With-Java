package com.amit.leetcode_389;

public class Solution {

	public char findTheDifference(String s, String t) {
		char res = t.charAt(t.length() - 1);
		for (int i = 0; i < s.length(); i++) {
			res ^= s.charAt(i);
			res ^= t.charAt(i);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().findTheDifference("abcd", "abcde")); // Output is e
	}

}
