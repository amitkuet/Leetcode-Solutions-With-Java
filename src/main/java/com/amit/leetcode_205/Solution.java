package com.amit.leetcode_205;

public class Solution {

	public boolean isIsomorphic(String s, String t) {
		if (s == null || t == null || s.length() != t.length()) {
			return false;
		}
		int len = s.length();
		int[] sArr = new int[256];
		int[] tArr = new int[256];

		for (int i = 0; i < len; i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);
			if (sArr[c1] != tArr[c2]) {
				return false;
			}
			sArr[c1] = i + 1;
			tArr[c2] = i + 1;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().isIsomorphic("bar", "foo")); // Output is false
		System.out.println(new Solution().isIsomorphic("egg", "add")); // Output is true
		System.out.println(new Solution().isIsomorphic("paper", "title")); // Output is true
	}

}
