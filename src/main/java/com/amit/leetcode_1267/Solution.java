package com.amit.leetcode_1267;

public class Solution {

	public int countServers(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		int ans = 0;
		int[] rows = new int[m];
		int[] cols = new int[n];

		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				if (grid[row][col] == 1) {
					rows[row]++;
					cols[col]++;
				}
			}
		}

		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				if (grid[row][col] == 1 && (rows[row] > 1 || cols[col] > 1)) {
					ans++;
				}
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		int[][] grid = { { 1, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 } };
		System.out.println(new Solution().countServers(grid)); // Output is 4
	}

}
