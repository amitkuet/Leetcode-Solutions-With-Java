package com.amit.leetcode_242;

public class Solution {

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] chars = new int[26];
		for (char ch : s.toCharArray()) {
			chars[ch - 'a']++;
		}

		for (int i = 0; i < t.length(); i++) {
			if (chars[t.charAt(i) - 'a'] <= 0) {
				return false;
			}
			chars[t.charAt(i) - 'a']--;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().isAnagram("anagram", "gramana")); // Output is true
		System.out.println(new Solution().isAnagram("car", "rat")); // Output is false
	}

}
