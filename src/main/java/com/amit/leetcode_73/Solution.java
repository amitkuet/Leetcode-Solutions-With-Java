package com.amit.leetcode_73;

public class Solution {

	public void setZeroes(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		boolean isRowZeros = false, isColZeros = false;
		int m = matrix.length;
		int n = matrix[0].length;

		for (int i = 0; i < n; i++) {
			if (matrix[0][i] == 0) {
				isRowZeros = true;
				break;
			}
		}

		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == 0) {
				isColZeros = true;
				break;
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[0][j] == 0 || matrix[i][0] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		if (isRowZeros) {
			for (int i = 0; i < n; i++) {
				matrix[0][i] = 0;
			}
		}
		if (isColZeros) {
			for (int i = 0; i < m; i++) {
				matrix[i][0] = 0;
			}
		}

	}

	public static void main(String[] args) {
		int [][] matrix = {
		                   {1, 1, 1},
		                   {1, 0, 1},
		                   {1, 1, 1}
		                 };
		new Solution().setZeroes(matrix);
		for(int [] vals : matrix) {
			for(int val : vals) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}

}
