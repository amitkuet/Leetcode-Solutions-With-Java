package com.amit.leetcode_1189;

// Time - O(N) where N is the number of characters
// Space - O(1)
public class Solution {

	public int maxNumberOfBalloons(String text) {
		int[] chars = new int[26];

		for (char ch : text.toCharArray()) {
			chars[ch - 'a']++;
		}

		int ans = Integer.MAX_VALUE;
		for (char ch : "balloon".toCharArray()) {
			int count = (ch == 'l' || ch == 'o') ? chars[ch - 'a'] / 2 : chars[ch - 'a'];
			ans = Math.min(ans, count);
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().maxNumberOfBalloons("nlaebolko")); // 1
		System.out.println(new Solution().maxNumberOfBalloons("loonbalxballpoon")); // 2
	}

}
