package com.amit.leetcode_48;

public class Solution {

	public void rotate(int[][] matrix) {

		// transpose matrix
		for (int i = 0; i < matrix.length - 1; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
				if (i < j) {
					swap(matrix, i, j);
				}
			}
		}

		// reverse row elements
		for (int i = 0; i < matrix.length; i++) {
			reverseRow(matrix, i);
		}
	}

	private void reverseRow(int[][] matrix, int row) {
		int left = 0;
		int right = matrix[row].length - 1;

		while (left < right) {
			int temp = matrix[row][left];
			matrix[row][left++] = matrix[row][right];
			matrix[row][right--] = temp;
		}
	}

	private void swap(int[][] matrix, int i, int j) {
		int temp = matrix[i][j];
		matrix[i][j] = matrix[j][i];
		matrix[j][i] = temp;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		new Solution().rotate(matrix);

		// Output is [7,4,1],[8,5,2],[9,6,3]
		for (int[] col : matrix) {
			for (int val : col) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}

}
