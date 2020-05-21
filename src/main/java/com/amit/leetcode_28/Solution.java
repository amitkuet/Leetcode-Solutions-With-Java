package com.amit.leetcode_28;

public class Solution {

	public int strStr(String haystack, String needle) {
		if (needle == null || needle.isEmpty()) {
			return 0;
		}
		int m = haystack.length();
		int n = needle.length();
		if (m < n) {
			return -1;
		}
		for (int i = 0; i <= m - n; i++) {
			if (haystack.charAt(i) == needle.charAt(0)) {
				int p1 = i + 1;
				int p2 = 1;
				while (p2 < n && haystack.charAt(p1) == needle.charAt(p2)) {
					p1++;
					p2++;
				}
				if (p2 == n) {
					return i;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().strStr("hello", "ll")); // Output is 2
		System.out.println(new Solution().strStr("aaaaa", "bba")); // Output is -1
	}

}
