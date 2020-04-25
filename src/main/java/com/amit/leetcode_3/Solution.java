package com.amit.leetcode_3;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static int lengthOfLongestSubstring(String s) {
		int longestSubStringLength = 0;
		int i = 0;
		int j = 0;
		Set<Character> set = new HashSet<>();

		while (i < s.length() && j < s.length()) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				longestSubStringLength = Math.max(longestSubStringLength, set.size());
			} else {
				set.remove(s.charAt(i++));
			}
		}

		return longestSubStringLength;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb")); // Output is 3
		System.out.println(lengthOfLongestSubstring("bbbbb")); // Output is 1
		System.out.println(lengthOfLongestSubstring("pwwkew")); // Output is 3
	}

}
