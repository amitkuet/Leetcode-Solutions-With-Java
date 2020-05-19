package com.amit.leetcode_463;

public class Solution {

	public int islandPerimeter(int[][] grid) {
		int perimeter = 0;
		int rows = grid.length;
		int cols = grid[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 1) {
					// check top
					if (i - 1 < 0 || grid[i - 1][j] == 0) {
						perimeter++;
					}
					// check down
					if (i + 1 >= rows || grid[i + 1][j] == 0) {
						perimeter++;
					}
					// check left
					if (j - 1 < 0 || grid[i][j - 1] == 0) {
						perimeter++;
					}
					// check right
					if (j + 1 >= cols || grid[i][j + 1] == 0) {
						perimeter++;
					}
				}
			}
		}
		return perimeter;
	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		System.out.println(new Solution().islandPerimeter(grid));
	}

}
