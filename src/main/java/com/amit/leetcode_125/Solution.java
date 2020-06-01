package com.amit.leetcode_125;

public class Solution {

	public boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;
		s = s.toLowerCase();

		while (left < right) {
			while (left < right && !isValidChar(s.charAt(left)))
				left++;
			while (left < right && !isValidChar(s.charAt(right)))
				right--;

			if (s.charAt(left++) != s.charAt(right--)) {
				return false;
			}
		}
		return true;
	}

	private boolean isValidChar(char c) {
		return Character.isLetter(c) || Character.isDigit(c);
	}

	public static void main(String[] args) {
		System.out.println(new Solution().isPalindrome("A man, a plan, a canal: Panama")); // Output is true
		System.out.println(new Solution().isPalindrome("race a car")); // Output is false
	}

}
