package com.amit.leetcode_542;

/**
 * 
 * Time complexity: O(r⋅c). 2 passes of r.c each
 * Space complexity: O(r.c)
 *
 */
public class Solution {

	public int[][] updateMatrix(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] ans = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				ans[i][j] = Integer.MAX_VALUE - 1;
			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] == 0) {
					ans[i][j] = 0;
				} else {
					if (i > 0) {
						ans[i][j] = Math.min(ans[i][j], ans[i - 1][j] + 1);
					}
					if (j > 0) {
						ans[i][j] = Math.min(ans[i][j], ans[i][j - 1] + 1);
					}
				}
			}
		}

		for (int i = rows - 1; i >= 0; i--) {
			for (int j = cols - 1; j >= 0; j--) {

				if (i < rows - 1) {
					ans[i][j] = Math.min(ans[i][j], ans[i + 1][j] + 1);
				}
				if (j < cols - 1) {
					ans[i][j] = Math.min(ans[i][j], ans[i][j + 1] + 1);
				}
			}
		}

		return ans;
	}

}
