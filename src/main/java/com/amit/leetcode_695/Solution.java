package com.amit.leetcode_695;

public class Solution {

	public int maxAreaOfIsland(int[][] grid) {
		int maxArea = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					maxArea = Math.max(maxArea, dfs(grid, i, j));
				}
			}
		}
		return maxArea;
	}

	private int dfs(int[][] grid, int row, int col) {
		if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == 0) {
			return 0;
		}
		grid[row][col] = 0;

		return 1 + dfs(grid, row + 1, col) + dfs(grid, row - 1, col) + dfs(grid, row, col - 1)
				+ dfs(grid, row, col + 1);
	}

	public static void main(String[] args) {
		int [][] matrix = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
		                   {0,0,0,0,0,0,0,1,1,1,0,0,0},
		                   {0,1,1,0,1,0,0,0,0,0,0,0,0},
		                   {0,1,0,0,1,1,0,0,1,0,1,0,0},
		                   {0,1,0,0,1,1,0,0,1,1,1,0,0},
		                   {0,0,0,0,0,0,0,0,0,0,1,0,0},
		                   {0,0,0,0,0,0,0,1,1,1,0,0,0},
		                   {0,0,0,0,0,0,0,1,1,0,0,0,0}};
		System.out.println(new Solution().maxAreaOfIsland(matrix)); // Output is 6
	}

}
