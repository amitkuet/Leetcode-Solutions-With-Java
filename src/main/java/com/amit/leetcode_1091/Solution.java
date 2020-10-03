package com.amit.leetcode_1091;

import java.util.LinkedList;
import java.util.Queue;

class Point {
	int row;
	int col;
	int level;

	public Point(int row, int col, int level) {
		this.row = row;
		this.col = col;
		this.level = level;
	}
}

public class Solution {
	public int shortestPathBinaryMatrix(int[][] grid) {
		if (grid[0][0] == 1)
			return -1;
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0, 0, 1));
		grid[0][0] = 1;

		int[][] DIRS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 } };

		while (!queue.isEmpty()) {
			Point point = queue.poll();
			if (point.row == grid.length - 1 && point.col == grid[0].length - 1)
				return point.level;
			for (int i = 0; i < 8; i++) {
				int newRow = point.row + DIRS[i][0];
				int newCol = point.col + DIRS[i][1];

				if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[newRow].length
						|| grid[newRow][newCol] == 1)
					continue;
				grid[newRow][newCol] = 1;
				queue.offer(new Point(newRow, newCol, point.level + 1));
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] grid = { { 0, 1 }, { 1, 0 } };
		System.out.println(s.shortestPathBinaryMatrix(grid)); // output is 2

		int[][] grid2 = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };
		System.out.println(new Solution().shortestPathBinaryMatrix(grid2)); // output is 4
	}
}
