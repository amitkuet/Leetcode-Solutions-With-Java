package com.amit.leetcode_520;

public class Solution {

	public boolean detectCapitalUse(String word) {
		int length = word.length();
		int counter = 0;

		for (char ch : word.toCharArray()) {
			if (!Character.isLowerCase(ch)) {
				counter++;
			}
		}
		return counter == 0 || counter == length || (counter == 1 && !Character.isLowerCase(word.charAt(0)));
	}

	public static void main(String[] args) {
		System.out.println(new Solution().detectCapitalUse("ABC")); // Output is true
		System.out.println(new Solution().detectCapitalUse("leetcode")); // Output is true
		System.out.println(new Solution().detectCapitalUse("FlaG")); // Output is false
	}

}
