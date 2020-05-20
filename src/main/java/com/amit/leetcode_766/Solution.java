package com.amit.leetcode_766;

public class Solution {

	public boolean isToeplitzMatrix(int[][] matrix) {
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
				if (matrix[i][j] != matrix[i - 1][j - 1]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] matrix = { 
				{ 1, 2, 3, 4 }, 
				{ 5, 1, 2, 3 }, 
				{ 9, 5, 1, 2 } };
		System.out.println(new Solution().isToeplitzMatrix(matrix));
	}

}
