package com.amit.leetcode_200;

public class Solution {

	private int numOfIslands = 0;

	public int numIslands(char[][] grid) {
		if (grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					numOfIslands++;
					dfs(grid, i, j);
				}
			}
		}
		return numOfIslands;
	}

	private void dfs(char[][] grid, int row, int col) {
		if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != '1') {
			return;
		}
		grid[row][col] = 0;
		dfs(grid, row + 1, col); // down
		dfs(grid, row - 1, col); // up
		dfs(grid, row, col + 1); // right
		dfs(grid, row, col - 1); // left
	}

	public static void main(String[] args) {
		char[][] grid = { 
							{ '1', '1', '1', '1', '0' }, 
							{ '1', '1', '0', '1', '0' }, 
							{ '1', '1', '0', '0', '0' },
							{ '0', '0', '0', '0', '0' } };
		System.out.println(new Solution().numIslands(grid)); // Output is 1
	}

}
