package com.amit.leetcode_733;

import java.util.Arrays;

public class Solution {

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if (image[sr][sc] == newColor) {
			return image;
		}
		helper(image, sr, sc, image[sr][sc], newColor);
		return image;
	}

	private void helper(int[][] image, int row, int col, int color, int newColor) {
		int m = image.length;
		int n = image[0].length;
		if (row < 0 || row >= m || col < 0 || col >= n || image[row][col] != color) {
			return;
		}
		image[row][col] = newColor;

		helper(image, row - 1, col, color, newColor);
		helper(image, row + 1, col, color, newColor);
		helper(image, row, col - 1, color, newColor);
		helper(image, row, col + 1, color, newColor);
	}

	public static void main(String[] args) {
		int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		new Solution().floodFill(image, 1, 1, 2);
		for (int[] vals : image) {
			for (int val : vals) {
				System.out.print(val + " ");
			}
			System.out.println();     // Output is [[2,2,2],[2,2,0],[2,0,1]]
		}
	}

}
