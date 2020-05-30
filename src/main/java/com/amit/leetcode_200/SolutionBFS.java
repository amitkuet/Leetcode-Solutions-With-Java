package com.amit.leetcode_200;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionBFS {

	int[][] DIRS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		Queue<int[]> queue = new LinkedList<>();
		int numOfIsland = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					numOfIsland++;
					queue.offer(new int[] { i, j });
					grid[i][j] = '0';
					bfs(grid, queue);
				}
			}
		}
		return numOfIsland;
	}

	private void bfs(char[][] grid, Queue<int[]> queue) {
		while (!queue.isEmpty()) {
			int[] pair = queue.poll();

			for (int k = 0; k < DIRS.length; k++) {
				int newRow = DIRS[k][0] + pair[0];
				int newCol = DIRS[k][1] + pair[1];
				if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[newRow].length
						|| grid[newRow][newCol] == '0') {
					continue;
				}
				grid[newRow][newCol] = '0';
				queue.add(new int[] { newRow, newCol });
			}
		}
	}

	public static void main(String[] args) {
		char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };
		System.out.println(new SolutionBFS().numIslands(grid)); // Output is 1
	}

}
