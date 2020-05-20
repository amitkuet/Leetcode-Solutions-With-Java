package com.amit.leetcode_76;

public class Solution {

	public String minWindow(String s, String t) {
		if (s == null || s.length() == 0)
			return "";
		int[] map = new int[128];

		for (char c : t.toCharArray()) {
			map[c]++;
		}
		int left = 0;
		int count = 0;
		int minLen = Integer.MAX_VALUE;
		String res = "";

		for (int right = 0; right < s.length(); right++) {
			if (--map[s.charAt(right)] >= 0)
				count++;

			while (count == t.length()) {
				if (minLen > right - left + 1) {
					minLen = right - left + 1;
					res = s.substring(left, right + 1);
				}
				if (++map[s.charAt(left)] > 0)
					count--;
				left++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC")); // Output is BANC
	}

}
