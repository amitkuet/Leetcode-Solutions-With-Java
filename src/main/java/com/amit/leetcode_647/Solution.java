package com.amit.leetcode_647;

public class Solution {

	public int countSubstrings(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];
		int count = 0;

		for (int i = 0; i < n; i++) {
			dp[i][i] = 1;
			count++;
		}

		for (int col = 1; col < n; col++) {
			for (int row = 0; row < col; row++) {
				if (col - 1 == row && s.charAt(row) == s.charAt(col)) {
					dp[row][col] = 1;
					count++;
				} else if (dp[row + 1][col - 1] == 1 && s.charAt(row) == s.charAt(col)) {
					dp[row][col] = 1;
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().countSubstrings("abc")); // Output is 3
		System.out.println(new Solution().countSubstrings("aaa")); // Output is 6
	}

}
