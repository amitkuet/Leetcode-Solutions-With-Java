package com.amit.leetcode_994;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public int orangesRotting(int[][] grid) {
		int noOfFreshOrange = 0;
		Queue<int[]> queue = new LinkedList<>();
		int level = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1)
					noOfFreshOrange++;
				else if (grid[i][j] == 2)
					queue.offer(new int[] { i, j });
			}
		}

		int[][] DIRS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		while (noOfFreshOrange > 0 && !queue.isEmpty()) {
			level++;
			int size = queue.size();

			for (int q = 0; q < size; q++) {
				int[] point = queue.poll();
				for (int i = 0; i < 4; i++) {
					int newRow = point[0] + DIRS[i][0];
					int newCol = point[1] + DIRS[i][1];
					if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[newRow].length
							|| grid[newRow][newCol] != 1)
						continue;
					grid[newRow][newCol] = 2;
					noOfFreshOrange--;
					queue.offer(new int[] { newRow, newCol });
				}
			}
		}

		return (noOfFreshOrange > 0) ? -1 : level;
	}

	public static void main(String[] args) {
		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		System.out.println(new Solution().orangesRotting(grid)); // output is 4
	}

}
