package com.amit.leetcode_62;

import java.util.Arrays;

public class Solution {

	// Time : O(m * n) Space: O(m * n)
	public int uniquePaths(int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		int[][] matrix = new int[m][n];
		for (int i = 0; i < n; i++) {
			matrix[0][i] = 1;
		}
		for (int i = 0; i < m; i++) {
			matrix[i][0] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
			}
		}
		return matrix[m - 1][n - 1];
	}

	// Time : O(m * n) Space: O(n)
	public int uniquePathsLowSpaceSolution(int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[j] += dp[j - 1];
			}
		}
		return dp[n - 1];
	}

	public static void main(String[] args) {
		System.out.println(new Solution().uniquePaths(3, 2)); // Output is 3
		System.out.println(new Solution().uniquePaths(7, 3)); // Output is 28

		System.out.println(new Solution().uniquePathsLowSpaceSolution(3, 2)); // Output is 3
		System.out.println(new Solution().uniquePathsLowSpaceSolution(7, 3)); // Output is 28
	}

}
